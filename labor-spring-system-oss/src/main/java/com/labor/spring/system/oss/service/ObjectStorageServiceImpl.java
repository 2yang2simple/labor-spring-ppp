package com.labor.spring.system.oss.service;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.labor.common.util.FileUtil;
import com.labor.common.util.ImageUtil;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.system.oss.AliyunOssUtil;
import com.labor.spring.system.oss.OSSApplicationProperties;
import com.labor.spring.feign.oss.ObjectStorageType;
import com.labor.spring.feign.oss.ObjectStorageUtil;
import com.labor.spring.feign.oss.ObjectStorageVO;
import com.labor.spring.system.oss.entity.ObjectBody;
import com.labor.spring.system.oss.entity.ObjectHeader;
import com.labor.spring.util.WebUtil;

@Service("ObjectStorageServiceImpl")
public class ObjectStorageServiceImpl implements ObjectStorageService{
	
	@Autowired
	private OSSApplicationProperties properties;
	@Autowired
	private ObjectHeaderRepository objectHeaderRepository;
	@Autowired
	private ObjectBodyRepository objectBodyRepository;

	@Override
	@Transactional
	public ObjectHeader createFile(ObjectStorageType ot, MultipartFile file) {
		return create(ot,file);
	}

	@Override
	@Transactional
	public ObjectHeader createFile(ObjectStorageType ot, byte[] fileBytes, String fileOriginalName) {
		return create(ot,fileBytes,fileOriginalName);
	}
	
	@Override
	@Transactional
	public ObjectHeader createImage(ObjectStorageType ot, MultipartFile file) {
		ObjectHeader ret = null;
		if (file.isEmpty()) {
	    	return ret;// file not exist;
		}
		String name = file.getOriginalFilename();		
		try {
			byte[] bytes = FileUtil.stream2Bytes(file.getInputStream());
			
			ret = createImage(ot,bytes,name);

		} catch (Exception e) {
			LogManager.getLogger().error("", e);
		} 
		return ret;
	}

	@Override
	@Transactional
	public ObjectHeader createImage(ObjectStorageType ot, byte[] fileBytes, String fileOriginalName) {
		ObjectHeader ret = null;
		if (fileBytes == null) {
	    	return ret;// file not exist;
		}
		
		byte[] rotateBytes = null;
		byte[] compressedBytes = null;
		String fileType = FileUtil.getFileType(fileOriginalName);
	
		//rotate image
		rotateBytes = ImageUtil.processRotateInfo(fileBytes,fileType);
		if (rotateBytes!=null) {
			//save the rotate image as the main image
			ret = create(ot, rotateBytes,fileOriginalName);
		}

		//compress image if store in nas.
		if (ObjectStorageType.NAS_IMAGE==ot){
			if (rotateBytes!=null) {
				//image larger than 300k should be compressed
				compressedBytes = ImageUtil.resize(rotateBytes, fileType, ImageUtil.IMAGE_COMPRESSED_KBSIZE);
				if (ret!=null&&
						compressedBytes!=null&&
						compressedBytes.length<rotateBytes.length){
					//save only the compressed image body with ext for display
					createBody(ot, fileType, compressedBytes, ret.getObjectBodyPath(), ret.getObjectBodyMd5(), ImageUtil.IMAGE_COMPRESSED_SUFFIX);
				}
	
			}
		}
		return ret;
	}
	
	@Override
	public ResponseEntity<byte[]> findEntityByFilename(String filename, String ext){
		ResponseEntity<byte[]> ret = null;
		byte[] fileBody = null;
		String attachment = "";
		ObjectStorageVO osvo = ObjectStorageUtil.url2objectstorage(filename);
		if (osvo != null) {
			osvo.setBytes(getBytes(osvo.getPath(),osvo.getName(),ext));
		} else {
			osvo = findObjectStorageByFileName(filename, ext);
		}
		if (osvo != null) {
			fileBody = osvo.getBytes();
			attachment = filename + "."+ osvo.getType();
		} 
		if (fileBody == null) {
			// if not exist or error, return 404.gif;
			fileBody = FileUtil.file2Bytes(WebUtil.getClassPath() + properties.IMG_DIR + File.separator + properties.IMG_FILE_404);
			attachment = properties.IMG_FILE_404;
		}
		if (fileBody == null) {
			return ret;
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=" + attachment);
		HttpStatus statusCode = HttpStatus.OK;
		ret = new ResponseEntity<byte[]>(fileBody, headers, statusCode);
		return ret;
	}
	
	
	@Override
	public ResponseEntity<byte[]> findImageEntityByFileName(String filename, boolean compressed, boolean getThumbnail, Double accuracy,Integer height, Integer width){
		ResponseEntity<byte[]> ret = null;
		byte[] fileBody = null;
		String attachment = "";
		ObjectStorageVO osvo = ObjectStorageUtil.url2objectstorage(filename);
		if (osvo != null) {
			osvo.setBytes(getBytes(osvo.getPath(),osvo.getName(),(compressed?ImageUtil.IMAGE_COMPRESSED_SUFFIX:"")));
		} else {
			osvo = findObjectStorageByFileName(filename, (compressed?ImageUtil.IMAGE_COMPRESSED_SUFFIX:""));
		}
		if (osvo != null) {
			if (getThumbnail) {
				fileBody = ImageUtil.resizeThumbnails(osvo.getBytes(),osvo.getType(),accuracy, height, width,
								WebUtil.getClassPath() + properties.IMG_DIR + File.separator + properties.IMG_FILE_WATERMARK);
			} else {
				fileBody = osvo.getBytes();
			}
			attachment = filename + "." + osvo.getType();
		}
		
		if (fileBody == null) {
			// if not exist or error, return notexist.gif;
			fileBody = FileUtil.file2Bytes(WebUtil.getClassPath() + properties.IMG_DIR + File.separator + properties.IMG_FILE_NOTEXIST);
			attachment = properties.IMG_FILE_NOTEXIST;
		} 
		if (fileBody == null) {
			return ret;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=" + attachment);
		HttpStatus statusCode = HttpStatus.OK;
		ret = new ResponseEntity<byte[]>(fileBody, headers, statusCode);
		return ret;
	}
	
	private ObjectStorageVO findObjectStorageByFileName(String filename, String ext) {
		ObjectStorageVO ret = null;
		Optional<ObjectHeader> oa = objectHeaderRepository.findOneByFileName(filename);
		if (oa.isPresent()) {
			ObjectHeader oh = oa.get();
			byte[] bytes = getBytes(oh.getObjectBodyPath(),oh.getObjectBodyMd5(),ext);
			ret = new ObjectStorageVO();
			ret.setBytes(bytes);
			ret.setType(oh.getFileType());
			ret.setName(oh.getName());
			ret.setSize(oh.getFileSize());
		}
		return ret;
	}
	
	private ObjectHeader create(ObjectStorageType ot, MultipartFile file) {
		ObjectHeader ret = null;
		if (file.isEmpty()) {
	    	return ret;// file not exist;
		}
		String name = file.getOriginalFilename();		
		try {
			byte[] bytes = FileUtil.stream2Bytes(file.getInputStream());
			
			ret = create(ot,bytes,name);

		} catch (Exception e) {
			LogManager.getLogger().error("", e);
		} 
		return ret;
	}
	
	private ObjectHeader create(ObjectStorageType ot, byte[] fileBytes, String fileOriginalName) {
		ObjectHeader ret = null;
		if (fileBytes == null) {
	    	return ret;// file not exist;
		}
		Long fileSize = Long.valueOf(fileBytes.length);

		/***** save the file , if user other oss service , do storage here; */
		String fileType = FileUtil.getFileType(fileOriginalName);
		ObjectBody objectBody = createBody(ot,fileType,fileBytes);
		if (objectBody!=null) {
			/***** save the file header */
			ObjectHeader objectHeader = new ObjectHeader();
			
			// save the header to db;
			objectHeader.setName(fileOriginalName);
			objectHeader.setFileType(fileType);
			objectHeader.setFileSize(fileSize);
			objectHeader.setObjectBodyId(objectBody.getId());
			
			//get the file from url direclty. 
			String url = ObjectStorageUtil.args2url(ot, objectBody.getPath(), objectBody.getMd5(), FileUtil.getFileType(fileOriginalName));
			objectHeader.setUrl(url);
			
			//or from object header in db
			//duplicate info equals data in the url;  	
			String fileName = TokenUtil.generateUUID();
			objectHeader.setFilePath(objectBody.getPath());
			objectHeader.setFileName(fileName);
			objectHeader.setObjectBodyPath(objectBody.getPath());
			objectHeader.setObjectBodyMd5(objectBody.getMd5());

			
			ret = objectHeaderRepository.save(objectHeader);
		}
		return ret;		
	}
	/***
	 * save file body by bytes
	 * @param fileBytes
	 * @return
	 */
	private ObjectBody createBody(ObjectStorageType ot, String fileType, byte[] fileBytes) {
		ObjectBody ret = null;
		if (fileBytes == null) {
	    	return ret;// file not exist;
		}
		String md5 = TokenUtil.md5(fileBytes);
		String path = new SimpleDateFormat("yyyyMMdd").format(new Date());
		ret = createBody(ot, fileType, fileBytes, path, md5, null);
		return ret;
	}

	/***
	 * save body directly with the path and md5 name ; 
	 * can storage the thb or zip of the original file;
	 * like 500c899c529f409bb6b0269049d46c53.thb or 500c899c529f409bb6b0269049d46c53.zip 
	 */	
	private ObjectBody createBody(ObjectStorageType ot, String fileType, byte[] fileBytes, String path, String md5, String ext) {
		ObjectBody ret = null;
		if (fileBytes == null) {
	    	return ret;// file not exist;
		}
//		if(ot!=null) {
//			//10+500c899c529f409bb6b0269049d46c53  or 11+500c899c529f409bb6b0269049d46c53
//			md5=ot.getType()+md5;
//		}
		if (ObjectStorageType.NAS_IMAGE==ot
				||ObjectStorageType.NAS_FILE==ot){

			if (!StringUtil.isEmpty(ext)) {
				md5=md5+ext;
			}
			Optional<ObjectBody> oob = objectBodyRepository.findOneByMd5(md5);
			if (oob.isPresent()) {
				ret = oob.get();
				LogManager.getLogger().debug("createBody: "+ret.getId()+" body exist.");
			}
			
		}
		if (ret==null) {
			// create a path and save the bytes to file;
			saveBytes(ot, path, md5, fileType, fileBytes);
			
			//save the body in db
			ObjectBody ob = new ObjectBody();
			ob.setPath(path);
			ob.setMd5(md5);
			ret = objectBodyRepository.save(ob);
		}
		return ret;
	}
	
	/***
	 * save bytes to storage
	 * @param fileFullPath
	 * @param fileBytes
	 * @return
	 */
	private void saveBytes(ObjectStorageType ot, String datePath, String fileName, String fileType, byte[] fileBytes) {
		switch(ot){
		    case NAS_FILE :	
		    	saveBytes2Nas(ot.getPath(), datePath, fileName, fileType, fileBytes);
		    	break;
		    case NAS_IMAGE :
		    	saveBytes2Nas(ot.getPath(), datePath, fileName, fileType, fileBytes);
		    	break;
		    case ALIYUN_OSS_FILE :
				saveBytes2AliyunOss(ot.getPath(), datePath, fileName, fileType, fileBytes);
		    	break;
		    case ALIYUN_OSS_IMAGE :
				saveBytes2AliyunOss(ot.getPath(), datePath, fileName, fileType, fileBytes);
		    	break;
		    default : 	
				saveBytes2Nas(ot.getPath(), datePath, fileName, fileType, fileBytes);
		    	break;
		}
	}
	/**
	 * save to nas 
	 * @param fileFullPath
	 * @param fileBytes
	 * @return
	 */
	private void saveBytes2Nas(String otPath, String datePath, String fileName, String fileType, byte[] fileBytes) {
		if (otPath==null||datePath==null||fileName==null||fileBytes==null) {
			return;
		}
		String fileFullPath = properties.OBJECTSTORAGE_DIR + File.separator 
//							+ otPath + File.separator 
							+ datePath + File.separator 
							+ fileName;
		
		File desFile = new File(fileFullPath);
		if (!desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdirs();
		}			
		FileUtil.writeFile(fileBytes, desFile);
	}
	/***
	 * save to aliyun 
	 * @param fileFullPath
	 * @param fileBytes
	 * @return
	 */
	private void saveBytes2AliyunOss(String otPath, String datePath, String fileName, String fileType, byte[] fileBytes) {
		if (otPath==null||datePath==null||fileName==null||fileBytes==null) {
			return;
		} 
		//aliyunoss: 对于任何一个以正斜线（/）结尾的对象，不论该对象是否存有数据，在控制台中都以文件目录的方式显示，您只能通过API或SDK的方式来下载该对象。
		String fileFullPath =  
//						otPath + "/" + 
						datePath + "/" + 
						fileName + "." + fileType;
		AliyunOssUtil.upload(fileFullPath, fileBytes);
	}

	private byte[] getBytes(String path, String md5, String ext) {
		byte[] ret = null;
		String regex = "^[a-z0-9A-Z]+$";
		File file = null;
		//path should be safe; validate the input. 
		if (!path.matches(regex)
				||!md5.matches(regex)) {
			LogManager.getLogger().error("getBytes: parameter illegel: "+File.separator 
					+ path + File.separator 
					+ md5 + ext);
			return ret;
		} 
		if (!StringUtil.isEmpty(ext)
				&&ext.substring(1).matches(regex)) {
			file = new File(properties.OBJECTSTORAGE_DIR + File.separator 
					+ path + File.separator 
					+ md5
					+ (ext==null?"":ext));
		} 
		if (file==null || !file.exists()) {
			file = new File(properties.OBJECTSTORAGE_DIR + File.separator 
					+ path + File.separator 
					+ md5);
		} 
		if (file!=null && file.exists()) {
			LogManager.getLogger().debug("getBytes:"+file.getName());
			ret = FileUtil.file2Bytes(file);
		}
		
		return ret;
	}
}

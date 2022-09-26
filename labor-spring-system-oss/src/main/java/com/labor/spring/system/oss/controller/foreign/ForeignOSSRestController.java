package com.labor.spring.system.oss.controller.foreign;

import org.apache.logging.log4j.LogManager;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.labor.common.util.QRCodeUtil;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultCode;
import com.labor.spring.system.oss.OSSApplicationProperties;
import com.labor.spring.feign.oss.ObjectStorageType;
import com.labor.spring.feign.oss.ObjectStorageUtil;
import com.labor.spring.feign.oss.ObjectStorageVO;
import com.labor.spring.system.oss.service.ObjectStorageService;



@RestController
@RequestMapping("/rest/foreign")
public class ForeignOSSRestController {

	@Autowired
	@Qualifier(value = "ObjectStorageServiceImpl")
	private ObjectStorageService objectStorageService;


	//create a object with entity;
	@RequiresPermissions("oss:create")
	@RequestMapping(value = {"/files"}, method = RequestMethod.POST)
	public Result createFile(
					@RequestPart("file") MultipartFile file) {
	    if (file.isEmpty()) {
	    	return Result.failure(ResultCode.FAILURE_PARAM_NULL, ResultCode.MSG_FAILURE_PARAM_NULL);
		}
		return Result.success(objectStorageService.createFile(ObjectStorageType.NAS_FILE,file));
	}
	
	//create a image with MultipartFile;
	@RequiresPermissions("oss:create")
	@RequestMapping(value = {"/images"}, method = RequestMethod.POST)
	public Result createImage(
					@RequestPart("file") MultipartFile file) {
	    if (file.isEmpty()) {
	    	return Result.failure(ResultCode.FAILURE_PARAM_NULL, ResultCode.MSG_FAILURE_PARAM_NULL);
		}
	    // image will be compressed in service;
		return Result.success(objectStorageService.createImage(ObjectStorageType.NAS_IMAGE,file));
	}
	
	//create a image with bytes;
	@RequiresPermissions("oss:create")
	@RequestMapping(value = {"/images/bytes"}, method = RequestMethod.POST)
	public Result createImageByBytes(
					@RequestBody byte[] filebytes,
					@RequestParam(value="filename", required=true) String filename) {
	    if (filebytes==null) {
	    	return Result.failure(ResultCode.FAILURE_PARAM_NULL, ResultCode.MSG_FAILURE_PARAM_NULL);
		}
	    // image will be compressed in service;
		return Result.success(objectStorageService.createImage(ObjectStorageType.NAS_IMAGE,filebytes,filename));
	}
	
//	@RequestMapping(value = { "/files/urls/{url}" }, method = RequestMethod.GET)
//	public ResponseEntity<byte[]> findFileByUrl(
//					@PathVariable(value="url") String url) {
//		return objectStorageService.findEntityByUrl(url);
//	}
//	
//	@RequestMapping(value = { "/images/urls/{url}" }, method = RequestMethod.GET)
//	public ResponseEntity<byte[]> findImageByUrl(
//					@PathVariable(value="url") String url) {
//		return objectStorageService.findImageEntityByUrl(url,true,false,Double.valueOf(1),null,null);//compressed to avoid large file.
//	}
	
	@RequestMapping(value = { "/files/{filename}" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findFileByFilename(
					@PathVariable(value="filename") String filename) {
		return objectStorageService.findEntityByFilename(filename, null);
	}
	
	@RequestMapping(value = { "/images/{filename}" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilename(
					@PathVariable(value="filename") String filename) {
		return objectStorageService.findImageEntityByFileName(filename,true,false,Double.valueOf(1),null,null);//compressed to avoid large file.
	}
	
	@RequestMapping(value = { "/images/{filename}/origin" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilenameByOrigin(
					@PathVariable(value="filename") String filename) {
		return objectStorageService.findImageEntityByFileName(filename,false,false,Double.valueOf(1),null,null);
	}
	
	@RequestMapping(value = { "/images/{filename}/size" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilenameBySize(
					@PathVariable(value="filename") String filename,
					@RequestParam(value="accuracy", required=false) Double accuracy,
					@RequestParam(value="height", required=false) Integer height,
					@RequestParam(value="width", required=false) Integer width) {
		return objectStorageService.findImageEntityByFileName(filename,true,true,accuracy,height,width);
	}
	
	@RequestMapping(value = {"/qr-code"}, method = RequestMethod.GET)
	public ResponseEntity<byte[]> qrCode(
						@RequestParam(value = "content", required=false) String content) {
		ResponseEntity<byte[]> ret = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=qr");
		HttpStatus statusCode = HttpStatus.OK;
		ret = new ResponseEntity<byte[]>(QRCodeUtil.createImageBytes(content, 200, 200), headers, statusCode);
		return ret;
	}
}

package com.labor.spring.feign.api.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.labor.common.util.QRCodeUtil;
import com.labor.common.util.StringUtil;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultCode;
import com.labor.spring.feign.api.OSSFeignClient;

@Service
@Primary
public class FeignOSSServiceImpl implements FeignOSSService{
	
	@Autowired
	private OSSFeignClient ossFeignClient;

	//create a object with entity;
	@Override
	@Transactional
	public Result createFile(MultipartFile file) {
	    if (file.isEmpty()) {
	    	return Result.failure(ResultCode.FAILURE_PARAM_NULL, ResultCode.MSG_FAILURE_PARAM_NULL);
		}
	    Result ret = null;
	    ret = ossFeignClient.createFile(file);
		return ret;
	}
	
	//create a image with entity;
	@Override
	@Transactional
	public Result createImage(MultipartFile file) {
	    if (file.isEmpty()) {
	    	return Result.failure(ResultCode.FAILURE_PARAM_NULL, ResultCode.MSG_FAILURE_PARAM_NULL);
		}
	    Result ret = null;
	    ret = ossFeignClient.createImage(file);
		return ret;
	}
	
	@Override
	@Transactional
	public Result createImageByBytes(byte[] filebytes, String filename) {
	    if (filebytes==null||StringUtil.isEmpty(filename)) {
	    	return Result.failure(ResultCode.FAILURE_PARAM_NULL, ResultCode.MSG_FAILURE_PARAM_NULL);
		}
	    Result ret = null;
	    ret = ossFeignClient.createImageByBytes(filebytes,filename);
		return ret;
	}
	
//	@Override
//	public ResponseEntity<byte[]> findFileByUrl(String url){
//		return ossFeignClient.findFileByUrl(url);
//	}
//	
//	@Override
//	public ResponseEntity<byte[]> findImageByUrl(String url){
//		return ossFeignClient.findImageByUrl(url);
//	}

	@Override
	public ResponseEntity<byte[]> findFileByFilename(String filename) {
		ResponseEntity<byte[]> ret = null;
		if (!StringUtil.isEmpty(filename)) {
	    	ret = ossFeignClient.findFileByFilename(filename);
		} 
		return ret;
	}
	
	@Override
	public ResponseEntity<byte[]> findImageByFilename(String filename) {
		ResponseEntity<byte[]> ret = null;
		if (!StringUtil.isEmpty(filename)) {
	    	ret = ossFeignClient.findImageByFilename(filename);
		} 
		return ret;
	}

	@Override
	public ResponseEntity<byte[]> findImageByFilenameByOrigin(String filename) {
		ResponseEntity<byte[]> ret = null;
		if (!StringUtil.isEmpty(filename)) {
	    	ret = ossFeignClient.findImageByFilenameByOrigin(filename);
		} 
		return ret;
	}

	@Override
	public ResponseEntity<byte[]> findImageByFilenameBySize(String filename,Double accuracy,Integer height,Integer width){
		ResponseEntity<byte[]> ret = null;
		if (!StringUtil.isEmpty(filename)) {
	    	ret = ossFeignClient.findImageByFilenameBySize(filename,accuracy,height,width);
		} 
		return ret;
	}
	

}

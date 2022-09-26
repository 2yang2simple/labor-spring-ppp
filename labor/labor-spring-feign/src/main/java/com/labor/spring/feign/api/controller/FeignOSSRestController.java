package com.labor.spring.feign.api.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.labor.common.util.QRCodeUtil;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultCode;
import com.labor.spring.feign.api.OSSFeignClient;
import com.labor.spring.feign.api.service.FeignOSSService;


@RestController
@RequestMapping("/rest/feign/oss")
public class FeignOSSRestController {
	
	@Autowired
	private FeignOSSService feignOSSService;

	//create a object with entity;
	@RequiresPermissions("oss:create")
	@RequestMapping(value = {"/files"}, method = RequestMethod.POST)
	public Result createFile(
					@RequestPart("file") MultipartFile file) {
		return feignOSSService.createFile(file);
	}
	
	//create a image with entity;
	@RequiresPermissions("oss:create")
	@RequestMapping(value = {"/images"}, method = RequestMethod.POST)
	public Result createImage(
					@RequestPart("file") MultipartFile file) {
		return feignOSSService.createImage(file);
	}
	
	@RequestMapping(value = { "/files/{filename}" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findFileByFilename(
					@PathVariable(value="filename") String filename) {
		return feignOSSService.findFileByFilename(filename);
	}
	
	@RequestMapping(value = { "/images/{filename}" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilename(
					@PathVariable(value="filename") String filename) {
		return feignOSSService.findImageByFilename(filename);
	}
	
	@RequestMapping(value = { "/images/{filename}/origin" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilenameByOrigin(
					@PathVariable(value="filename") String filename) {
		return feignOSSService.findImageByFilenameByOrigin(filename);
	}

	@RequestMapping(value = { "/images/{filename}/size" }, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilenameBySize(
			@PathVariable(value="filename") String filename,
			@RequestParam(value="accuracy", required=false) Double accuracy,
			@RequestParam(value="height", required=false) Integer height,
			@RequestParam(value="width", required=false) Integer width) {
		return feignOSSService.findImageByFilenameBySize(filename,accuracy,height,width);
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

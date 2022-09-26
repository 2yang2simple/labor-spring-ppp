package com.labor.spring.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.labor.spring.bean.Result;
import com.labor.spring.feign.FeignMultipartSupportConfig;

/***
 * get url from application.porperties
 * feign.url.oss=http://localhost:8080/oss
 */
@FeignClient(name = "oss", url = "${feign.url.oss}", configuration = FeignMultipartSupportConfig.class)
public interface OSSFeignClient {
	
	@RequestMapping(value = {"/rest/foreign/files"}, method = RequestMethod.POST, 
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Result createFile(@RequestPart("file") MultipartFile file);

	@RequestMapping(value = {"/rest/foreign/images"}, method = RequestMethod.POST, 
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Result createImage(@RequestPart("file") MultipartFile file);
	
	@RequestMapping(value = {"/rest/foreign/images/bytes"}, method = RequestMethod.POST)
	public Result createImageByBytes(
					@RequestBody byte[] filebytes,
					@RequestParam(value="filename", required=true) String filename);

	@RequestMapping(value = {"/rest/foreign/files/{filename}"}, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findFileByFilename(@PathVariable(value="filename") String filename);

	@RequestMapping(value = {"/rest/foreign/images/{filename}"}, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilename(@PathVariable(value="filename") String filename);
	
	@RequestMapping(value = {"/rest/foreign/images/{filename}/origin"}, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilenameByOrigin(@PathVariable(value="filename") String filename);
	
	@RequestMapping(value = {"/rest/foreign/images/{filename}/size"}, method = RequestMethod.GET)
	public ResponseEntity<byte[]> findImageByFilenameBySize(
					@PathVariable(value="filename") String filename,
					@RequestParam(value="accuracy", required=false) Double accuracy,
					@RequestParam(value="height", required=false) Integer height,
					@RequestParam(value="width", required=false) Integer width);

			
			
}

package com.labor.spring.feign.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.labor.spring.bean.Result;

public interface FeignOSSService {

	public Result createFile(MultipartFile file);
	public Result createImage(MultipartFile file);
	public Result createImageByBytes(byte[] filebytes, String filename);

//	public ResponseEntity<byte[]> findFileByUrl(String url);
//	public ResponseEntity<byte[]> findImageByUrl(String url);
	
	public ResponseEntity<byte[]> findFileByFilename(String filename);
	public ResponseEntity<byte[]> findImageByFilename(String filename);
	public ResponseEntity<byte[]> findImageByFilenameByOrigin(String filename);
	public ResponseEntity<byte[]> findImageByFilenameBySize(String filename,Double accuracy,Integer height,Integer width);
	
}

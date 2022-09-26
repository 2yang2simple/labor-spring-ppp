package com.labor.spring.system.oss.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.labor.spring.feign.oss.ObjectStorageType;
import com.labor.spring.system.oss.entity.ObjectHeader;


public interface ObjectStorageService {
	

	public ObjectHeader createFile(ObjectStorageType ot, MultipartFile file);
	public ObjectHeader createFile(ObjectStorageType ot, byte[] fileBytes, String fileOriginalName);
	public ObjectHeader createImage(ObjectStorageType ot, MultipartFile file);
	public ObjectHeader createImage(ObjectStorageType ot, byte[] fileBytes, String fileOriginalName);

	public ResponseEntity<byte[]> findEntityByFilename(String filename, String ext);
	public ResponseEntity<byte[]> findImageEntityByFileName(String fileName, boolean compressed, boolean getThumbnail, Double accuracy,Integer height, Integer width);


}

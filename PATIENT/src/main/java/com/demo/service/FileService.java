package com.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public String uploadFile(MultipartFile file);
	public byte[] getFile(String fileName) ;
	public String deleteFile(String filename);

}

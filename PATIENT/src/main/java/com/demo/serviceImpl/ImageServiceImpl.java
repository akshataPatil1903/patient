package com.demo.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.service.FileService;

@Service
public class ImageServiceImpl implements FileService {

	@Value("${upload.dir}")
	// file save - frontend
	private String path;

	@Override
	public String uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}

		String savefile = path + File.separator + file.getOriginalFilename();
		File saveimage = new File(savefile);
		try {
			file.transferTo(saveimage);

		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("File not Found");
		}

		return "file is upload successflly";
	}

	@Override
	public byte[] getFile(String fileName) {
		// TODO Auto-generated method stub
		
		Path file= Paths.get(path).resolve(fileName);
		
		
		try {
			return Files.readAllBytes(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			throw new RuntimeException(e);
		}
	}

	@Override
	public String deleteFile(String filename) {
		// TODO Auto-generated method stub
		Path file= Paths.get(path).resolve(filename);
	try {
		Files.deleteIfExists(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "File Delete Successfully";
	}

}

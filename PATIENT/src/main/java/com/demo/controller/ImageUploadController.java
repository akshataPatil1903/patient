package com.demo.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.service.FileService;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {

	@Autowired
	private FileService fileService;

	@GetMapping
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("File is Empty");
		}
		String message = this.fileService.uploadFile(file);
		return ResponseEntity.ok(message);
	}

	@GetMapping(value = "/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getFile(@PathVariable String fileName) {
		byte[] file = this.fileService.getFile(fileName);
		MediaType mediaType;
		// return new ResponseEntity<>(file, HttpStatus.OK);
//		  MediaType mediaType;
		try {
			String contentType = Files.probeContentType(Paths.get("uploads").resolve(fileName));
			mediaType = MediaType.parseMediaType(contentType);
		} catch (Exception e) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		}

		return ResponseEntity.ok().contentType(mediaType).body(file);

	}

	@DeleteMapping("/{fileName}")
	public ResponseEntity<String> deleteFile(@PathVariable String fileName){
		String message = this.fileService.deleteFile(fileName);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}

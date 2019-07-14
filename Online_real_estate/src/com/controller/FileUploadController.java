package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="upload.do")
    public void testUpload(MultipartHttpServletRequest request) throws IOException {
		Iterator<String> fileNames = request.getFileNames();
		while (fileNames.hasNext()) {
			String fileName=fileNames.next();
			System.out.println("fileName: "+fileName);
			List<MultipartFile> fileList=request.getFiles(fileName);
			if (fileList.size()>0) {
				Iterator<MultipartFile> fileIte=fileList.iterator();
				while (fileIte.hasNext()) {
					MultipartFile multipartFile=fileIte.next();
					String originalFilename = multipartFile.getOriginalFilename();
                    System.out.println("originalFilename: "+originalFilename);
                    //String path ="D:/testUpload/";
                    String path = request.getServletContext().getRealPath(
        	                "/fytp");
                    File filepath = new File(path,originalFilename);
                    if (!filepath.getParentFile().exists()) { 
        	        	filepath.getParentFile().mkdirs();
        	        }
                    multipartFile.transferTo(new File(path+File.separator+ originalFilename));
        			System.out.println("上传文件路径：" + (path+File.separator+ originalFilename));
                    String contentType=multipartFile.getContentType();
                    System.out.println("contentType: "+contentType);
                    String name=multipartFile.getName();
                    System.out.println("name: "+name);
                    long size=multipartFile.getSize();
                    System.out.println("size: "+size);
				}
			}
		}
	}
}

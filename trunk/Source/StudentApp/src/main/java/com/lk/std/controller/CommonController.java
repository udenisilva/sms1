package com.lk.std.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lk.std.util.FileDownloadManager;
import com.lk.std.util.FileUploadManager;

@Controller
public class CommonController {

	@RequestMapping(value="/uploadFile")
	public @ResponseBody String upload(@RequestParam("reportFile") CommonsMultipartFile file, @RequestParam("filePrefix") String filePrefix, HttpServletRequest request,HttpServletResponse response){
		StringBuffer buffer = new StringBuffer();
		String fileName = null;
		
		try {
			FileUploadManager fileUploadManager = new FileUploadManager();
			Map<String,Object> uploadedData = fileUploadManager.uploadFile(file, filePrefix);
			fileName = (String) uploadedData.get("fileName");
			buffer.append(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return buffer.toString();
	}
	
	@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
	public String getUserProfilePage(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) {
		FileDownloadManager downloadManager = new FileDownloadManager();
		try {
			downloadManager.downloadFile(filePath, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
}

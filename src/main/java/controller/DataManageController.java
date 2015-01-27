/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * DataManageController.java
 * 2015-1-23
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.UploadedFile;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 实现功能： upload and remove datauploadedFiles
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-1-23 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
@Controller
public class DataManageController {
	public static final Logger log = Logger
			.getLogger(DataManageController.class);
	public  final String classPath = this.getClass().getResource("/").getPath();

	@RequestMapping(value ={"/", "index.do","dataManage.do"} )
	public String  dataManage(HttpServletRequest request) {
		queryUploadFiles(request);
		return "dataManage";
	}
	
	@RequestMapping("upload.do")
	public String upload(HttpServletRequest request) {
		long startTime = System.currentTimeMillis();

		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = classPath +"sourceData/"+ file.getOriginalFilename();
					// 上传
					try {
						file.transferTo(new File(path));
					} catch (IOException e) {
						log.error("file upload failed !", e);
					}
				}
			}
		}
		
		long endTime = System.currentTimeMillis();
		log.info("Uploading file  costs：" + String.valueOf(endTime - startTime)
				+ "ms");
		queryUploadFiles(request);
		return "dataManage";
	}
	
	@RequestMapping("rmFile.do")
	public String rmFile(HttpServletRequest request){
		String fileName = request.getParameter("fileName");
		File removingFile = new File(classPath+"sourceData/"+fileName);
		if(removingFile.delete()){
			log.info("file :" + fileName + " delete successfully !");
		}else {
			log.error("file :" + fileName + " delete failed !");
		}
		
		queryUploadFiles(request);
		return "dataManage";
	}
	
	@RequestMapping("queryUploadFiles.do")
	public List<UploadedFile> queryUploadFiles(HttpServletRequest request) {
		File dir = new File(classPath+"sourceData/");
		File[] files = dir.listFiles();
		
		if (files.length ==  0) {
			log.warn("query files is null !");
			return null;
		}
		
		List<UploadedFile> fileList = new ArrayList<UploadedFile>();
		
		for (File file : files) {
			
			UploadedFile uf = new UploadedFile();
			uf.setFileName(file.getName());
			uf.setFilePath(file.getAbsolutePath());
			uf.setLastModifiedTime(new Date(file.lastModified()));
			uf.setSize(file.length());
			
			fileList.add(uf);
		}
		
		request.setAttribute("uploadedFiles", fileList);
		
		return fileList;
	}
}

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * UploadedFile.java
 * 2015-1-23
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model;

import java.util.Date;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015-1-23	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class UploadedFile {
	private String fileName ;
	private String filePath ;
	private Date lastModifiedTime ;
	private long size ;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
}


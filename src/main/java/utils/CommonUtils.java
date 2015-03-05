/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CommonUtils.java
 * 2015-3-4
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 实现功能：
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-4 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class CommonUtils {

	public static final Logger log = Logger.getLogger(DnbUtils.class);

	/**
	 * @param cmd
	 */
	public static void execShellCmd(String cmd) {
		Runtime rt = Runtime.getRuntime();
		BufferedInputStream bis;
		BufferedReader br;
		try {
			Process process = rt.exec(cmd);
			bis = new BufferedInputStream(process.getInputStream());
			br = new BufferedReader(new InputStreamReader(bis));

			String line;
			while ((line = br.readLine()) != null) {
				log.info(line);
			}

			if (process.waitFor() != 0) {
				if (process.exitValue() == 1) {
					log.error("exec shell cmd,incorrectly exit!");
				}
			}

			bis.close();
			br.close();
		} catch (Exception e) {
			log.error("exec shell cmd error", e);
		}
	}

	public static List<String> queryUploadFileNames(String classPath) {
		File dir = new File(classPath + "sourceData/");
		File[] files = dir.listFiles();

		if (files.length == 0) {
			log.warn("query files is null !");
			return null;
		}

		List<String> fileList = new ArrayList<String>();

		for (File file : files) {
			fileList.add(file.getName());
		}

		return fileList;
	}

}

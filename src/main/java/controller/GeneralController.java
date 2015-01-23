package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.UploadedFile;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	// public static final Log log = LogFactory.getLog(GeneralController.class);
	public static final Logger log = Logger.getLogger(GeneralController.class);
	public  final String classPath = this.getClass().getResource("/").getPath();

	@RequestMapping(value ={"/", "index.do"})
	public String  index(HttpServletRequest request) {
		queryUploadFileNames(request);
		return "index";
	}
	@RequestMapping(value = "grid.do")
	public String  grid(HttpServletRequest request) {
		return "grid";
	}
	@RequestMapping(value = "change_password.do")
	public String  change_password(HttpServletRequest request) {
		return "change_password";
	}
	@RequestMapping(value = "faq.do")
	public String  faq(HttpServletRequest request) {
		return "faq";
	}

	@RequestMapping(value = "charts.do")
	public String  charts(HttpServletRequest request) {
		return "charts";
	}
	@RequestMapping(value = "account.do")
	public String  account(HttpServletRequest request) {
		return "account";
	}
	@RequestMapping(value = "login.do")
	public String  login(HttpServletRequest request) {
		return "login";
	}

	@RequestMapping(value = "genDNB.do")
	public String genDNB(HttpServletRequest request) {
		String basePath =classPath; // request.getParameter("basePath");
		String fileName = request.getParameter("fileName");

		String periodCount = request.getParameter("periodCount");
		String periodSampleCount = request.getParameter("periodSampleCount");
		String periodSampleSep = request.getParameter("periodSampleSep");

		String featuresSdThreshold = request
				.getParameter("featuresSdThreshold");
		String clusterHclustH = request.getParameter("clusterHclustH");
		String pccOutAmount = request.getParameter("pccOutAmount");

		String cores = request.getParameter("cores");

		String cmd = classPath + "core/gdm4Par.R " +  
				" -p " + basePath + "  -f  " + fileName +
				"  --period.count   " + periodCount +
				"  --period.sample.count  " + periodSampleCount + 
				"  --period.sample.sep " + periodSampleSep +
				" --features.sd.threshold " + featuresSdThreshold +
				" --cluster.hclust.h " + clusterHclustH +
				" --pcc.out.amount " + pccOutAmount +
				" --cores " + cores;
		log.info("cmd:"+cmd);
		execShellCmd(cmd);

		return "index";
	}

	/**
	 * @param cmd
	 */
	private void execShellCmd(String cmd) {
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
	
	public List<String> queryUploadFileNames(HttpServletRequest request) {
		File dir = new File(classPath+"sourceData/");
		File[] files = dir.listFiles();
		
		if (files.length ==  0) {
			log.warn("query files is null !");
			return null;
		}
		
		List<String> fileList = new ArrayList<String>();
		
		for (File file : files) {
			fileList.add(file.getName());
		}
		
		request.setAttribute("fileNames", fileList);
		
		return fileList;
	}
}

package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CiData;
import model.DnbData;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DNBGenerateController {
	// public static final Log log = LogFactory.getLog(GeneralController.class);
	public static final Logger log = Logger
			.getLogger(DNBGenerateController.class);
	public final String classPath = this.getClass().getResource("/").getPath();

	/*
	 * @RequestMapping(value ={"/", "index.do"}) public String
	 * index(HttpServletRequest request) { queryUploadFileNames(request); return
	 * "index"; }
	 */
	@RequestMapping(value = "paramInput.do")
	public String paramInput(HttpServletRequest request) {
		queryUploadFileNames(request);
		return "paramInput";
	}

	@RequestMapping(value = "grid.do")
	public String grid(HttpServletRequest request) {
		return "grid";
	}

	@RequestMapping(value = "change_password.do")
	public String change_password(HttpServletRequest request) {
		return "change_password";
	}

	@RequestMapping(value = "faq.do")
	public String faq(HttpServletRequest request) {
		return "faq";
	}

	@RequestMapping(value = "charts.do")
	public String charts(HttpServletRequest request) {
		CiData ci = getAllCIs();
		String ciStr = JSONArray.fromObject(ci).get(0).toString();
		log.info(ciStr);
		request.setAttribute("ciData", ciStr);
		request.setAttribute("dnbDatas", getDnbDatas());
		return "charts";
	}

	private CiData getAllCIs() {
		CiData ci = new CiData();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					classPath + "all_ci.txt")));
			ci.setCategories(br.readLine().split("\t"));

			String[] dataStr = br.readLine().split("\t");
			int dataLen = dataStr.length;
			double[] data = new double[dataLen];
			for (int i = 0; i < dataLen; i++) {
				data[i] = Double.parseDouble(dataStr[i]);
			}

			ci.setData(data);
			br.close();
		} catch (IOException e) {
			log.error("read ci error!", e);
		}
		log.info("get ci value  successfully !");
		return ci;
	}

	public List<DnbData> getDnbDatas() {
		List<DnbData> dnbs = new ArrayList<DnbData>();

		String[] periods = getAllDnbPeriods();

		for (String period : periods) {
			DnbData dnb = new DnbData();
			dnb.setPeriod(period);
			dnb.setIds(getDnbGeneIds(period));
			dnbs.add(dnb);
		}
		log.info("get DNB data successfully !");
		return dnbs;
	}

	private List<String> getDnbGeneIds(String weekPeriod) {
		List<String> geneIds = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					classPath + "matrix_table_" + weekPeriod + "_dnb.txt")));
			while (br.ready()) {
				geneIds.add(br.readLine());
			}
			br.close();
		} catch (IOException e) {
			log.error("read ci_maxima_index error!", e);
		}
		log.info("geneIds:" + Arrays.toString(geneIds.toArray()));
		return geneIds;
	}

	private String[] getAllDnbPeriods() {
		String[] periods = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					classPath + "ci_maxima_index.txt")));
			periods = br.readLine().split("\t");
			br.close();
		} catch (IOException e) {
			log.error("read ci_maxima_index error!", e);
		}
		log.info("periods:" + Arrays.toString(periods));
		return periods;
	}

	@RequestMapping(value = "account.do")
	public String account(HttpServletRequest request) {
		return "account";
	}

	@RequestMapping(value = "login.do")
	public String login(HttpServletRequest request) {
		return "login";
	}

	@RequestMapping(value = "genDNB.do")
	public String genDNB(HttpServletRequest request) {
		String basePath = classPath; // request.getParameter("basePath");
		String caseFileName = request.getParameter("caseFileName");
		String controlFileName = request.getParameter("controlFileName");

		String periodCount = request.getParameter("periodCount");
		String periodSampleCount = request.getParameter("periodSampleCount");

		String featuresSdThreshold = request
				.getParameter("featuresSdThreshold");
		String clusterHclustH = request.getParameter("clusterHclustH");
		String pccOutAmount = request.getParameter("pccOutAmount");

		String cores = request.getParameter("cores");
		
		StringBuffer cmd = new StringBuffer();
		cmd.append(classPath).append("core/gdm4Par.R ").append(" -p ").append(basePath)
			.append("  --case.file.name  " ).append(caseFileName)
			.append("  --period.count   " ).append(periodCount)
			.append("  --period.sample.count  ").append(periodSampleCount)
			.append(" --features.sd.threshold  " ).append(featuresSdThreshold)
			.append(" --cluster.hclust.h  ").append(clusterHclustH)
			.append(" --pcc.out.amount  " ).append(pccOutAmount)
			.append(" --cores " ).append(cores);
		if (!StringUtils.isEmpty(controlFileName)) {
			cmd.append("  --control.file.name  ").append(controlFileName);
		}
		
		log.info("cmd:" + cmd.toString());
		execShellCmd(cmd.toString());

		return charts(request);
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

		request.setAttribute("fileNames", fileList);

		return fileList;
	}

	public static void main(String[] args) {
		String str = "[hello]";
		System.out.println(str.substring(1, str.length() - 1));
	}
}

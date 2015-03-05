package controller;

import javax.servlet.http.HttpServletRequest;

import model.CiData;
import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import utils.CommonUtils;
import utils.DnbUtils;

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
		request.setAttribute("fileNames",
				CommonUtils.queryUploadFileNames(classPath));
		return "paramInput";
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
		CiData ci = DnbUtils.getAllCIs(classPath);
		String ciStr = JSONArray.fromObject(ci).get(0).toString();
		log.info(ciStr);
		request.setAttribute("ciData", ciStr);
		request.setAttribute("dnbDatas", DnbUtils.getDnbDatas(classPath));
		return "charts";
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
		cmd.append(classPath).append("core/gdm4Par.R ").append(" -p ")
				.append(basePath).append("  --case.file.name  ")
				.append(caseFileName).append("  --period.count   ")
				.append(periodCount).append("  --period.sample.count  ")
				.append(periodSampleCount).append(" --features.sd.threshold  ")
				.append(featuresSdThreshold).append(" --cluster.hclust.h  ")
				.append(clusterHclustH).append(" --pcc.out.amount  ")
				.append(pccOutAmount).append(" --cores ").append(cores);
		if (!StringUtils.isEmpty(controlFileName)) {
			cmd.append("  --control.file.name  ").append(controlFileName);
		}

		log.info("cmd:" + cmd.toString());
		CommonUtils.execShellCmd(cmd.toString());

		return charts(request);
	}

	public static void main(String[] args) {
		String str = "[hello]";
		System.out.println(str.substring(1, str.length() - 1));
	}
}

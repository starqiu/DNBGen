package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	// public static final Log log = LogFactory.getLog(GeneralController.class);
	public static final Logger log = Logger.getLogger(GeneralController.class);

	@RequestMapping(value = "index.do")
	public String  index(Model model) {
		return "index";
	}
	@RequestMapping(value = "grid.do")
	public String  grid(Model model) {
		return "grid";
	}
	@RequestMapping(value = "change_password.do")
	public String  change_password(Model model) {
		return "change_password";
	}
	@RequestMapping(value = "faq.do")
	public String  faq(Model model) {
		return "faq";
	}
	@RequestMapping(value = "plans.do")
	public String  plans(Model model) {
		return "plans";
	}
	@RequestMapping(value = "charts.do")
	public String  charts(Model model) {
		return "charts";
	}
	@RequestMapping(value = "account.do")
	public String  account(Model model) {
		return "account";
	}
	@RequestMapping(value = "login.do")
	public String  login(Model model) {
		return "login";
	}

	@RequestMapping(value = "genDNB.do")
	public String genDNB(Model model, HttpServletRequest request) {
		String basePath = request.getParameter("basePath");
		String fileName = request.getParameter("fileName");

		String periodCount = request.getParameter("periodCount");
		String periodSampleCount = request.getParameter("periodSampleCount");
		String periodSampleSep = request.getParameter("periodSampleSep");

		String featuresSdThreshold = request
				.getParameter("featuresSdThreshold");
		String clusterHclustH = request.getParameter("clusterHclustH");
		String pccOutAmount = request.getParameter("pccOutAmount");

		String cores = request.getParameter("cores");

		String classPath = this.getClass().getResource("/").getPath();
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
}

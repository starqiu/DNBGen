/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CytoscapePictureController.java
 * 2015-3-3
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.cytoscape.CytoscapeEdge;
import model.cytoscape.CytoscapeEdgeData;
import model.cytoscape.CytoscapeElement;
import model.cytoscape.CytoscapeNode;
import model.cytoscape.CytoscapeNodeData;
import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import utils.CommonUtils;
import utils.DnbUtils;

/**
 * 实现功能：Cytoscape 绘图控制器
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-3 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
@Controller
public class CytoscapePictureController {
	// public static final Log log = LogFactory.getLog(GeneralController.class);
	public static final Logger log = Logger
			.getLogger(CytoscapePictureController.class);
	public final String classPath = this.getClass().getResource("/").getPath();
	public final String jsPath = new File(classPath).getParentFile()
			.getParent() + "/js/";

	@RequestMapping(value = "cytoscapePic.do")
	public String cytoscapePic(HttpServletRequest request) {

		String[] periods = DnbUtils.getAllPeriods(classPath);
		String period = (String) request.getAttribute("period");
		if (null == period) {
			period = periods[0];
			// generate gdm_x.csv
			CommonUtils.geneateGdmCsv(classPath);
		}

		CytoscapeElement element = DnbUtils.getElementByPeriod(classPath,
				period);
		String elementStr = JSONArray.fromObject(element).get(0).toString();
		// log.info(elementStr);
		log.info("js path :" + jsPath);
		// generate JS file
//		DnbUtils.genCytoPicJsFile(jsPath,elementStr);

		request.setAttribute("cytoElement", elementStr);
		/*
		 * request.setAttribute("cytoElement",JSONArray
		 * .fromObject(createElement4Test()) .get(0).toString() );
		 */

		return "cytoscapePic";
	}


	/**
	 * @param nodes
	 * @param edges
	 */
	@SuppressWarnings("unused")
	private CytoscapeElement createElement4Test() {
		List<CytoscapeNode> nodes = new ArrayList<CytoscapeNode>();
		List<CytoscapeEdge> edges = new ArrayList<CytoscapeEdge>();
		for (int i = 0; i < 5; i++) {
			CytoscapeNode node = new CytoscapeNode();

			CytoscapeNodeData nodeData = new CytoscapeNodeData();
			nodeData.setId(String.valueOf(i));
			nodeData.setScore(Math.random());
//			nodeData.setGene_name("g" + String.valueOf(i));

			node.setData(nodeData);

			nodes.add(node);

			for (int j = 0; j < 5; j++) {
				if (i != j) {
					CytoscapeEdge edge = new CytoscapeEdge();
					CytoscapeEdgeData edgeData = new CytoscapeEdgeData();
					edgeData.setSource(String.valueOf(i));
					edgeData.setTarget(String.valueOf(j));
					edgeData.setId("e" + edgeData.getSource() + "-"
							+ edgeData.getTarget());
					edgeData.setWeight(Math.random());
					edge.setData(edgeData);
					edges.add(edge);
				}
			}
		}

		CytoscapeElement element = new CytoscapeElement();
		element.setNodes(nodes);
		element.setEdges(edges);
		element.setId("id" + Math.random());

		return element;
	}

	public static void main(String[] args) {
		// new CytoscapePictureController().cytoscapePic(null);
		System.out.println(Integer.class.cast(0x345));
	}
}

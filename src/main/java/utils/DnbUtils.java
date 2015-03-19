/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * DnbUtils.java
 * 2015-3-4
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.CiData;
import model.DnbData;
import model.cytoscape.CytoscapeEdge;
import model.cytoscape.CytoscapeEdgeData;
import model.cytoscape.CytoscapeElement;
import model.cytoscape.CytoscapeNode;
import model.cytoscape.CytoscapeNodeData;

import org.apache.log4j.Logger;

/**
 * 实现功能：operation of DNB relative files ,to get DNB infomation
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-4 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public final class DnbUtils {

	public static final Logger log = Logger.getLogger(DnbUtils.class);

	private DnbUtils() {
		super();
	}

	public static List<CytoscapeElement> getAllElements(String classPath) {

		List<CytoscapeElement> eles = new ArrayList<CytoscapeElement>();
		String[] periods = getAllPeriods(classPath);
		for (String period : periods) {
			eles.add(getElementByPeriod(classPath, period));
		}

		return eles;
	}

	public static CytoscapeElement getElementByPeriod(String classPath,
			String period) {

		CytoscapeElement ele = new CytoscapeElement();
		ele.setId("ele" + period);
		ele.setNodes(getAllNodesByPeriod(classPath, period));
		ele.setEdges(getAllEdgesByPeriod(classPath, period));

		return ele;
	}

	public static List<CytoscapeEdge> getAllEdgesByPeriod(String classPath,
			String period) {
		List<CytoscapeEdge> edges = new ArrayList<CytoscapeEdge>();
		HashMap<String, String> dnbMap = getDnbMapByPeriod(classPath, period);
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					classPath + "gdm_" + period + ".csv")));
			// skip the title
			br.readLine();
			String[] line;
			while (br.ready()) {
				line = br.readLine().split(",");

				CytoscapeEdge edge = new CytoscapeEdge();

				CytoscapeEdgeData data = new CytoscapeEdgeData();
				data.setSource(line[0]);
				data.setTarget(line[1]);
				data.setId(line[2]);
				data.setNormalized_max_weight(Double.valueOf(line[3]));
				data.setName(data.getId());

				// indicate DNB
				if ((null != dnbMap.get(data.getSource()))
						|| (null != dnbMap.get(data.getTarget()))) {
					data.setData_type("dnb");
					// data.setHighlight(1);
					/*
					 * data.getNetworks().remove(0);
					 * data.getNetworks().add("dnb");
					 */

					// edge.setSelected(true);
					edge.setData(data);
					edges.add(edge);
				}
			}
		} catch (IOException e) {
			log.error("get all edges error! period=" + period, e);
		}
		return edges;
	}

	public static List<CytoscapeNode> getAllNodesByPeriod(String classPath,
			String period) {
		List<CytoscapeNode> nodes = new ArrayList<CytoscapeNode>();
		HashMap<String, String> dnbMap = getDnbMapByPeriod(classPath, period);

		try {
			BufferedReader idBr = new BufferedReader(new FileReader(new File(
					classPath + "matrix_table_" + period + "_genes.txt")));
			BufferedReader sdBr = new BufferedReader(new FileReader(new File(
					classPath + "matrix_table_" + period + "_sd.txt")));

			// skip the title
			idBr.readLine();
			sdBr.readLine();

			while (idBr.ready() && sdBr.ready()) {
				CytoscapeNodeData data = new CytoscapeNodeData();

				data.setId(idBr.readLine());
				data.setGene_name(data.getId());
				data.setScore(Double.valueOf(sdBr.readLine()));
				if (dnbMap.get(data.getId()) != null) {
					data.setNode_type("dnb");
				}

				CytoscapeNode node = new CytoscapeNode();
				node.setData(data);
				// node.setSelected(true);

				nodes.add(node);
			}

		} catch (IOException e) {
			log.error("get all nodes error!period=" + period, e);
		}
		return nodes;
	}

	/**
	 * change dnb list to map ,so it can indicate dnb genes from all genes
	 * faster
	 * 
	 * @param classPath
	 * @param period
	 * @return
	 */
	private static HashMap<String, String> getDnbMapByPeriod(String classPath,
			String period) {
		List<String> dnbIds = getDnbGeneIds(classPath, period);

		Iterator<String> dnbIter = dnbIds.iterator();
		HashMap<String, String> dnbMap = new HashMap<String, String>();
		while (dnbIter.hasNext()) {
			dnbMap.put(dnbIter.next(), "1");
		}
		return dnbMap;
	}

	public static String[] getAllPeriods(String classPath) {
		return getAllCIs(classPath).getCategories();
	}

	public static List<DnbData> getDnbDatas(String classPath) {
		List<DnbData> dnbs = new ArrayList<DnbData>();

		String[] periods = getAllDnbPeriods(classPath);

		for (String period : periods) {
			DnbData dnb = new DnbData();
			dnb.setPeriod(period);
			dnb.setIds(getDnbGeneIds(classPath, period));
			dnbs.add(dnb);
		}
		log.info("get DNB data successfully !");
		return dnbs;
	}

	public static List<String> getDnbGeneIds(String classPath, String weekPeriod) {
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

	public static String[] getAllDnbPeriods(String classPath) {
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

	public static CiData getAllCIs(String classPath) {
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

	/**
	 * 
	 */
	public static void genCytoPicJsFile(String jsPath, String elementStr) {
		File jsFile = new File(jsPath + "custom/cytoscapePic.js");
		if (jsFile.exists()) {
			jsFile.delete();
		}
		BufferedWriter bw = null;
		try {
			jsFile.createNewFile();
			bw = new BufferedWriter(new FileWriter(jsFile));

//			bw.append("var drawCytoPic = function(){ \n")
			bw.append("$(function(){ // on dom ready\n\n")
//					.append("var ele = JSON.parse(")
//					.append(elementStr)
//					.append(");")
          .append("\tvar cy = cytoscape({\n")
          .append("\tcontainer: document.getElementById('cy'),\n")
          .append("\tstyle: cytoscape.stylesheet()\n")
          .append("\t\t.selector('node')\n")
          .append("\t\t.css({\n")
          .append("\t\t'font-size': 10,\n")
          .append("\t\t'content': 'data(gene_name)',\n")
          .append("\t\t'text-valign': 'center',\n")
          .append("\t\t'color': 'white',\n")
          .append("\t\t'text-outline-width': 2,\n")
          .append("\t\t'text-outline-color': '#888',\n")
          .append("\t\t'min-zoomed-font-size': 8,\n")
          .append("\t\t'width': 'mapData(score, 0, 1, 20, 50)',\n")
          .append("\t\t'height': 'mapData(score, 0, 1, 20, 50)'\n")
          .append("\t\t})\n")
          .append("\t\t.selector('node[node_type = \"notDnb\"]')\n")
          .append("\t\t.css({\n")
          .append("\t\t'background-color': '#666',\n")
          .append("\t\t'text-outline-color': '#666'\n")
          .append("\t\t})\n")
          .append("\t\t.selector('node[node_type = \"dnb\"]')\n")
          .append("\t\t.css({\n")
          .append("\t\t'background-color': '#666',\n")
          .append("\t\t'text-outline-color': '#666'\n")
          .append("\t\t})\n")
          .append("\t\t.selector('node:selected')\n")
          .append("\t\t.css({\n")
          .append("\t\t'background-color': '#000',\n")
          .append("\t\t'text-outline-color': '#000'\n")
          .append("\t\t})\n")
          .append("\t\t.selector('edge')\n")
          .append("\t\t.css({\n")
          .append("\t\t'curve-style': 'haystack',\n")
          .append("\t\t'opacity': 0.333,\n")
          .append("\t\t'width': 'mapData(normalized_max_weight, 0, 0.01, 1, 2)',\n")
          .append("\t\t})\n")
          .append("\t\t.selector('edge[data_type = \"notDnb\"]')\n")
          .append("\t\t.css({").append("'line-color': '#C32E2E'\n")
          .append("\t\t})\n")
          .append("\t\t.selector('edge[data_type = \"dnb\"]')\n")
          .append("\t\t.css({").append("'line-color': '#EAA2A3'\n")
          .append("\t\t})").append(".selector('edge:selected')\n")
          .append("\t\t.css({").append("opacity: 1").append("}),\n")
          .append("\telements:").append("cy3json.elements").append(",\n")
          .append("\tlayout: {\n")
          .append("\t\tname: 'concentric',\n")
          .append("\t\tconcentric: function(){\n")
          .append("\t\treturn this.data('score');\n")
          .append("\t},\n")
          .append("\tlevelWidth: function(nodes){\n")
          .append("\t\treturn 0.5;\n")
          .append("\t},\n")
          .append("\tpadding: 10\n")
          .append("\t}").append("});\n")
          .append("\n}); // on dom ready\n")
          .append("var cy3json = {\n")
          .append("\t\"elements\":").append(elementStr).append("\n")
          .append("};");
			
			bw.close();
			log.info("generate cytoscapePic.js successfully!");
		} catch (IOException e) {
			log.info("generate cytoscapePic.js failed!", e);
		}
	}
}

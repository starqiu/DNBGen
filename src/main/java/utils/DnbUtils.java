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
import model.cytoscape.EdgeData;
import model.cytoscape.EleObj;
import model.cytoscape.Element;
import model.cytoscape.NodeData;
import model.cytoscape.NodeEleObj;
import model.cytoscape.Position;

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

	@SuppressWarnings("unused")
	public static List<Element> getAllElements(String classPath) {

		List<Element> eles = new ArrayList<Element>();
		String[] periods = getAllPeriods(classPath);
		for (String period : periods) {
			// eles.add(getElementByPeriod(classPath, period));
		}

		return eles;
	}

	public static List<EleObj> getElementByPeriod(String classPath,
			String period) {

		// CytoscapeElement ele = new CytoscapeElement();
		// ele.setId("ele" + period);
		// ele.setNodes(getAllNodesByPeriod(classPath, period));
		// ele.setEdges(getAllEdgesByPeriod(classPath, period));

		// Element ele = new Element();
//		List<EleObj> ele = getAllNodesByPeriod(classPath, period);// add nodes
		List<EleObj> ele = getAllHighSdNodesByPeriod(classPath, period);// add nodes
		ele.addAll(getAllEdgesByPeriod(classPath, period));
		return ele;
	}

	public static List<EleObj> getAllEdgesByPeriod(String classPath,
			String period) {
		// List<CytoscapeEdge> edges = new ArrayList<CytoscapeEdge>();
		List<EleObj> edges = new ArrayList<EleObj>();
		// HashMap<String, String> dnbMap = getDnbMapByPeriod(classPath,
		// period);
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					classPath + "gdm_" + period + ".csv")));
			// skip the title
			br.readLine();
			String[] line;
			while (br.ready()) {
				line = br.readLine().split(",");

				EdgeData data = new EdgeData();
				data.setSource(line[0]);
				data.setTarget(line[1]);
				data.setId(line[2]);
				data.setWeight(Double.valueOf(line[3]));

				EleObj edge = new EleObj();
				edge.setData(data);
				edge.setGroup("edges");

				/*
				 * we use new data structure
				 * 
				 * CytoscapeEdge edge = new CytoscapeEdge();
				 * 
				 * CytoscapeEdgeData data = new CytoscapeEdgeData();
				 * data.setSource(line[0]); data.setTarget(line[1]);
				 * data.setId(line[2]); data.setWeight(Double.valueOf(line[3]));
				 */
				// data.setName(data.getId());

				// indicate DNB
				// if ((null != dnbMap.get(data.getSource()))
				// || (null != dnbMap.get(data.getTarget()))) {
				// // data.setData_type("dnb");
				// // data.setHighlight(1);
				// /*
				// * data.getNetworks().remove(0);
				// * data.getNetworks().add("dnb");
				// */
				//
				// // edge.setSelected(true);
				// }
				// edge.setData(data);
				edges.add(edge);
			}
		} catch (IOException e) {
			log.error("get all edges error! period=" + period, e);
		}
		return edges;
	}

	public static List<EleObj> getAllNodesByPeriod(String classPath,
			String period) {
		List<EleObj> nodes = new ArrayList<EleObj>();
		// HashMap<String, String> dnbMap = getDnbMapByPeriod(classPath,
		// period);

		try {
			BufferedReader idBr = new BufferedReader(new FileReader(new File(
					classPath + "matrix_table_" + period + "_genes.txt")));
			BufferedReader sdBr = new BufferedReader(new FileReader(new File(
					classPath + "matrix_table_" + period + "_sd.txt")));

			// skip the title
			idBr.readLine();
			sdBr.readLine();

			while (idBr.ready() && sdBr.ready()) {
				NodeData data = new NodeData();

				data.setId(idBr.readLine());
				// data.setGene_name(data.getId());
				 data.setScore(Double.valueOf(sdBr.readLine()));
				// if (dnbMap.get(data.getId()) != null) {
				// data.setNode_type("dnb");
				// }

				EleObj node = new EleObj();
				node.setData(data);
				// node.setPosition(new Position());
				// node.setSelected(true);

				nodes.add(node);
			}
		} catch (IOException e) {
			log.error("get all nodes error!period=" + period, e);
		}
		return nodes;
	}
	
	public static List<EleObj> getAllHighSdNodesByPeriod(String classPath,
			String period) {
		List<EleObj> nodes = new ArrayList<EleObj>();
		 HashMap<String, String> dnbMap = getDnbMapByPeriod(classPath,
		 period);
		
		//add DNB node
		EleObj dnbNode = new EleObj();
		NodeData dnbData = new NodeData();
		dnbData.setId("dnb");
		dnbData.setScore(500);
//		dnbData.setParent("");
		dnbNode.setData(dnbData);
		nodes.add(dnbNode);
		
		try {
			BufferedReader highSdGeneBr = new BufferedReader(new FileReader(new File(
					classPath + "matrix_table_" + period + "_high_sd_genes.txt")));
			
			String[] line;
			while (highSdGeneBr.ready()) {
				
				line = highSdGeneBr.readLine().split(",");
				
				NodeData data = new NodeData();
				
				data.setId(line[0]);
				// data.setGene_name(data.getId());
				data.setScore(Double.valueOf(line[1]));
				 if (dnbMap.get(data.getId()) != null) {
//				 data.setNode_type("dnb");
					 data.setParent("dnb");   
				 }
				EleObj node = new EleObj();
				node.setData(data);
				// node.setPosition(new Position());
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
	@SuppressWarnings("unused")
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

			jsFileTemple1(bw, elementStr);
//			jsFileTemple2(bw, elementStr);

			bw.close();
			log.info("generate cytoscapePic.js successfully!");
		} catch (IOException e) {
			log.info("generate cytoscapePic.js failed!", e);
		}
	}

	/**
	 * $(function(){ // on dom ready
	 * 
	 * var cy = cytoscape({ 
	 * container: document.getElementById('cy'), 
	 * style:
	 * 	cytoscape.stylesheet()
	 * 		 .selector('node') 
	 *  		.css({ 'font-size': 10,
	 * 			'content': 'data(id)', '
	 * 			text-valign': 'center',
	 * 			 'color': 'green',
	 *				 'text-outline-width': 2,
	 *				  'text-outline-color': '#888',
	 * 				'min-zoomed-font-size': 8, }) 
	 * 		.selector('node:selected')
	 *			  .css({
	 * 				'background-color': '#000', 
	 * 				'text-outline-color': '#000' })
	 *			 .selector('edge')
	 * 			 .css({ 'curve-style': 'haystack', 'opacity': 0.333, })
	 * 		.selector('edge:selected')
	 *  			.css({opacity: 1}), 
	 *  	elements:elements, 
	 * 	 layout:{ name: 'concentric', concentric: function(){ return 0.5; }, 
	 *		 levelWidth:function(nodes){ return 0.5; }, padding: 10 }});
	 * 
	 * }); // on dom ready var elements=[];
	 * 
	 * @param bw
	 * @param elementStr
	 * @throws IOException
	 */
	public static void jsFileTemple1(BufferedWriter bw, String elementStr)
			throws IOException {
		// bw.append("var drawCytoPic = function(){ \n")
		bw.append("$(function(){ // on dom ready\n\n")
				// .append("var ele = JSON.parse(")
				// .append(elementStr)
				// .append(");")
				.append("\tvar cy = cytoscape({\n")
				.append("\tcontainer: document.getElementById('cy'),\n")
				.append("\tstyle: cytoscape.stylesheet()\n")
				.append("\t\t.selector('node')\n")
				.append("\t\t.css({\n")
				.append("\t\t'font-size': 10,\n")
				.append("\t\t'content': 'data(id)',\n")
				.append("\t\t'text-valign': 'center',\n")
				.append("\t\t'color': 'white',\n")
				.append("\t\t'text-outline-width': 2,\n")
				.append("\t\t'text-outline-color': '#888',\n")
				.append("\t\t'min-zoomed-font-size': 8,\n")
				.append("\t\t'width': 'mapData(score, 0, 1, 20, 50)',\n")
				.append("\t\t'height': 'mapData(score, 0, 1, 20, 50)'\n")
				.append("\t\t})\n")
				// .append("\t\t.selector('node[node_type = \"notDnb\"]')\n")
				// .append("\t\t.css({\n")
				// .append("\t\t'background-color': '#666',\n")
				// .append("\t\t'text-outline-color': '#666'\n")
				// .append("\t\t})\n")
				// .append("\t\t.selector('node[node_type = \"dnb\"]')\n")
				// .append("\t\t.css({\n")
				// .append("\t\t'background-color': '#666',\n")
				// .append("\t\t'text-outline-color': '#666'\n")
				// .append("\t\t})\n")
				.append("\t\t.selector('node:selected')\n")
				.append("\t\t.css({\n")
				.append("\t\t'background-color': '#000',\n")
				.append("\t\t'text-outline-color': '#000'\n")
				.append("\t\t})\n")
				.append("\t\t.selector('edge')\n")
				.append("\t\t.css({\n")
				.append("\t\t'curve-style': 'haystack',\n")
				.append("\t\t'opacity': 0.333,\n")
				.append("\t\t'width': 'mapData(weight, 0, 0.01, 1, 2)',\n")
				.append("\t\t})\n")
				// .append("\t\t.selector('edge[data_type = \"notDnb\"]')\n")
				// .append("\t\t.css({").append("'line-color': '#C32E2E'\n")
				// .append("\t\t})\n")
				// .append("\t\t.selector('edge[data_type = \"dnb\"]')\n")
				// .append("\t\t.css({").append("'line-color': '#EAA2A3'\n")
				// .append("\t\t})")
				.append(".selector('edge:selected')\n").append("\t\t.css({")
				.append("opacity: 1").append("}),\n").append("\telements:")
				.append("elements").append(",\n").append("\tlayout: {\n")
				.append("\t\tname: 'concentric',\n")
				.append("\t\tconcentric: function(){\n")
				.append("\t\treturn this.data('score');\n").append("\t},\n")
				.append("\tlevelWidth: function(nodes){\n")
				.append("\t\treturn 0.5;\n").append("\t},\n")
				.append("\tpadding: 10\n").append("\t}").append("});\n")
				.append("\n}); // on dom ready\n")
				// .append("var cy3json = {\n")
				.append("var elements=").append(elementStr).append(";\n");
		// .append("};");
	}

	/**
	 * $(function(){ // on dom ready
	 * 
	 * var cy = cytoscape({ // these options hide parts of the graph during
	 * interaction //hideEdgesOnViewport: true, //hideLabelsOnViewport: true,
	 * 
	 * // this is an alternative that uses a bitmap during interaction
	 * textureOnViewport: true,
	 * 
	 * // interpolate on high density displays instead of increasing resolution
	 * pixelRatio: 1,
	 * 
	 * // a motion blur effect that increases perceived performance for little
	 * or no cost motionBlur: true,
	 * 
	 * container: document.getElementById('cy'),
	 * 
	 * style: cytoscape.stylesheet() .selector('node') .css({ 'width':
	 * 'mapData(weight, 0, 100, 10, 60)', 'height': 'mapData(weight, 0, 100, 10,
	 * 60)' }) .selector('edge') .css({ 'opacity': '0.666', 'width':
	 * 'mapData(weight, 0, 100, 1, 6)', 'curve-style': 'haystack' // fast edges!
	 * }) .selector(':selected') .css({ 'background-color': 'black', 'opacity':
	 * 1 }),
	 * 
	 * layout: { name: 'concentric', concentric: function(){ return
	 * this.data('weight'); }, levelWidth: function( nodes ){ return 10; },
	 * padding: 10 },
	 * 
	 * elements: [] });
	 * 
	 * }); // on dom ready
	 * 
	 * @param bw
	 * @param elementStr
	 * @throws IOException
	 */
	public static void jsFileTemple2(BufferedWriter bw, String elementStr)
		throws IOException {
	//			bw.append("var drawCytoPic = function(){ \n")
	bw.append("$(function(){ // on dom ready\n")
	.append("\t\n")
	.append("var cy = cytoscape({\n")
	.append("\t// these options hide parts of the graph during interaction\n")
	.append("\thideEdgesOnViewport: true,\n")
	.append("\t//hideLabelsOnViewport: true,\n")
	.append("\t\n")
	.append("\t// this is an alternative that uses a bitmap during interaction\n")
	.append("\ttextureOnViewport: true,\n")
	.append("\t\n")
	.append("\t// interpolate on high density displays instead of increasing resolution\n")
	.append("\tpixelRatio: 1,\n")
	.append("\t\n")
	.append("\t// a motion blur effect that increases perceived performance for little or no cost\n")
	.append("\tmotionBlur: true,\n")
	.append("\t\n")
	.append("\tcontainer: document.getElementById('cy'),\n")
	.append("\t\n")
	.append("\tstyle: cytoscape.stylesheet()\n")
	.append("\t\t.selector('node')\n")
	.append("\t\t\t.css({\n")
	.append("\t\t\t\t'font-size': 10,\n")
	.append("\t\t\t\t'text-valign': 'center',\n")
	.append("\t\t\t\t'content': 'data(id)',\n")
	.append("\t\t\t\t'color': 'white',\n")
	.append("\t\t\t\t'width': 'mapData(score, 0, 100, 10, 60)',\n")
	.append("\t\t\t\t'height': 'mapData(score, 0, 100, 10, 60)'\n")
	.append("\t\t\t})\n")
	.append("\t\t.selector('edge')\n")
	.append("\t\t\t.css({\n")
	.append("\t\t\t\t'opacity': '0.666',\n")
	.append("\t\t\t\t'width': 'mapData(weight, 0, 100, 1, 6)',\n")
	.append("\t\t\t\t'curve-style': 'haystack' // fast edges!\n")
	.append("\t\t\t})\n")
	.append("\t\t.selector(':selected')\n")
	.append("\t\t .css({\n")
	.append("\t\t\t 'background-color': 'black',\n")
	.append("\t\t\t 'opacity': 1\n")
	.append("\t\t }),\n")
	.append("\t\n")
	.append("\tlayout: {\n")
	.append("\t\tname: 'concentric',\n")
	.append("\t\tconcentric: function(){ return this.data('weight'); },\n")
	.append("\t\tlevelWidth: function( nodes ){ return 10; },\n")
	.append("\t\tpadding: 10\n")
	.append("\t},\n")
	.append("\t\t\n")
	.append("\telements:").append(elementStr).append(" \n")
	.append("});\n")
	.append("\t\n")
	.append("}); // on dom ready\n");
}
}

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CytoscapeEdgeData.java
 * 2015-3-3
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;


/**
 * 实现功能： Cytoscape Edge Data
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-3 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class CytoscapeEdgeData {
	private String id;
	private String source;
	private String target;
//	private String data_type = "notDnb";
//	private List<String> networks=new ArrayList<String>() ;
//	private String name="default";
//	private int highlight = 0;
	private double weight;

	public CytoscapeEdgeData() {
		super();
//		networks.add("notDnb");
	}

//	public String getData_type() {
//		return data_type;
//	}
//
//	public String getName() {
//		return name;
//	}

//	public int getHighlight() {
//		return highlight;
//	}

	public String getId() {
		return id;
	}

//	public List<String>  getNetworks() {
//		return networks;
//	}

	public String getSource() {
		return source;
	}

	public String getTarget() {
		return target;
	}

//	public void setData_type(String data_type) {
//		this.data_type = data_type;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

//	public void setHighlight(int highlight) {
//		this.highlight = highlight;
//	}

	public void setId(String id) {
		this.id = id;
	}

//	public void setNetworks(List<String>  networks) {
//		this.networks = networks;
//	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}

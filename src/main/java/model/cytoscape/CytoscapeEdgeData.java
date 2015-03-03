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
	private String data_type;
	private String networks;
	private String gene_name;
	private int highlight = 0;
	private double normalized_max_weight;

	public String getData_type() {
		return data_type;
	}

	public String getGene_name() {
		return gene_name;
	}

	public int getHighlight() {
		return highlight;
	}

	public String getId() {
		return id;
	}

	public String getNetworks() {
		return networks;
	}

	public String getSource() {
		return source;
	}

	public String getTarget() {
		return target;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}

	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNetworks(String networks) {
		this.networks = networks;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public double getNormalized_max_weight() {
		return normalized_max_weight;
	}

	public void setNormalized_max_weight(double normalized_max_weight) {
		this.normalized_max_weight = normalized_max_weight;
	}
}

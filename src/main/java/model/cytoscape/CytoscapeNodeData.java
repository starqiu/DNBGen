/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CytoscapeNodeData.java
 * 2015-3-3
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;

/**
 * 实现功能： Cytoscape Node Data
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-3 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class CytoscapeNodeData {
	private String id;
	private double score;
	private String gene_name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGene_name() {
		return gene_name;
	}

	public void setGene_name(String gene_name) {
		this.gene_name = gene_name;
	}
}

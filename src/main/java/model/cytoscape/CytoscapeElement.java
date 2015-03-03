/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CytoscapeElement.java
 * 2015-3-3
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;

import java.util.List;

/**
 * 实现功能： Cytoscape Element
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-3 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class CytoscapeElement {
	private List<CytoscapeNode> nodes;
	private List<CytoscapeEdge> edges;

	public List<CytoscapeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<CytoscapeNode> nodes) {
		this.nodes = nodes;
	}

	public List<CytoscapeEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<CytoscapeEdge> edges) {
		this.edges = edges;
	}
}

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CytoscapeEdge.java
 * 2015-3-3
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;

/**
 * 实现功能： Cytoscape Edge
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-3 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class CytoscapeEdge {
	private CytoscapeEdgeData data;
	private boolean selected = false;

	public CytoscapeEdgeData getData() {
		return data;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setData(CytoscapeEdgeData data) {
		this.data = data;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}

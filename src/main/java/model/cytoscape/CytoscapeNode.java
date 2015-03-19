/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * CytoscapeNode.java
 * 2015-3-3
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;

/**
 * 实现功能： Cytoscape Node
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-3 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class CytoscapeNode {
	private CytoscapeNodeData data;
//	private boolean selected = false;

	public CytoscapeNodeData getData() {
		return data;
	}

	public void setData(CytoscapeNodeData data) {
		this.data = data;
	}

//	public boolean isSelected() {
//		return selected;
//	}
//
//	public void setSelected(boolean selected) {
//		this.selected = selected;
//	}
}

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * EleObj.java
 * 2015-3-19
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;

/**
 * 实现功能： node and edge's base class
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-19 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class EleObj {
	private EleData data;
	private String group = "nodes"; // nodes or edges

	public EleData getData() {
		return data;
	}

	public void setData(EleData data) {
		this.data = data;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Element.java
 * 2015-3-19
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package model.cytoscape;

import java.util.List;

/**
 * 实现功能：Element ,including one or more element object
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015-3-19 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 * 
 */
public class Element {
	private List<EleObj> elements;

	public List<EleObj> getElements() {
		return elements;
	}

	public void setElements(List<EleObj> elements) {
		this.elements = elements;
	}

}

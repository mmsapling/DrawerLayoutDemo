package com.cxw.drawerlayoutdemo.volly.bean;

public class ReturnBean {

	public Object object;

	public int type;// 类型
	
	public int pageCount;//总页数

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}

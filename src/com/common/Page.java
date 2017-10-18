package com.common;

import java.util.List;

public class Page {
	private int total;
	private int pageNumber;
	private int pageIndex;
	private List elements;
	private int first;
	private int pageSize;
	
	public Page(int pageIndex, int total, int pageSize) {
		this.total = total;
		this.pageSize = pageSize;
		if (total == 0)
			return;
		pageNumber = total / pageSize;
		if (total % pageSize > 0)
			pageNumber++;
		if (pageIndex < 1)
			pageIndex = 1;
		if (pageIndex > pageNumber) {
			pageIndex = pageNumber;
		}
		this.pageIndex = pageIndex;
		this.first = (pageIndex - 1) * pageSize;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List getElements() {
		return elements;
	}
	public void setElements(List elements) {
		this.elements = elements;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}

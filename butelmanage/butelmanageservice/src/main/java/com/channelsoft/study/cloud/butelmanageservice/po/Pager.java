package com.channelsoft.study.cloud.butelmanageservice.po;

import java.io.Serializable;

public class Pager implements Serializable{
	
	
	//总条数
	private long total = 0L;
	//显示记录开始页数
	private long page = 1L;
	//每页显示条数
	private long count = 10L;
	//排序字段
	private String sortField;
	//升序还是降序
	private String sortOrder = "desc";
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	
}

package com.channelsoft.study.cloud.butelmanageservice.entity;

public class ButelDetail {
	
	private long total;
	private long used;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getUsed() {
		return used;
	}
	public void setUsed(long used) {
		this.used = used;
	}
	public long getNoused() {
		return total - used;
	}
	@Override
	public String toString() {
		return "ButelDetail [total=" + total + ", used=" + used + ", noused=" + getNoused() + "]";
	}
	
	
}

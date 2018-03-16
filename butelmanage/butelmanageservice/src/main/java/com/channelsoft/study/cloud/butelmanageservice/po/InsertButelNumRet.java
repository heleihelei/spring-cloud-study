package com.channelsoft.study.cloud.butelmanageservice.po;

public class InsertButelNumRet {
	
	private int success;
	private int total;
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public InsertButelNumRet(int success, int total) {
		super();
		this.success = success;
		this.total = total;
	}
	
	

}

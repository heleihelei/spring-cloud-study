package com.channelsoft.study.cloud.butelmanageservice.po;


public class AjaxPo<T> {
	
	private Integer code = 0;  //成功为0
 	private String msg;
	private T obj;
	private long total = 0;
	
	public AjaxPo(){}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	
}

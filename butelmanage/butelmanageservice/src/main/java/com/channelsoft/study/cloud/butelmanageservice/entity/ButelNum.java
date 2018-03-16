package com.channelsoft.study.cloud.butelmanageservice.entity;

import java.util.Date;

public class ButelNum {
	
	private String butelNum;
	private String uid;
	private String source;     //来源
	private int used;   //是否使用  0：没使用   1：使用
	private Date usedTime;  //被使用的时间
	private String appkey;   //appkey
	public String getButelNum() {
		return butelNum;
	}
	public void setButelNum(String butelNum) {
		this.butelNum = butelNum;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public Date getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	@Override
	public String toString() {
		return "ButelNum [butelNum=" + butelNum + ", uid=" + uid + ", source=" + source + ", used=" + used
				+ ", usedTime=" + usedTime + ", appkey=" + appkey + "]";
	}
	
}

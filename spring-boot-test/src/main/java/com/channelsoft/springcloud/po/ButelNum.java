package com.channelsoft.springcloud.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ButelNum {

	@Id
	@Column(name = "butel_num")
	private String butelNum;

	@Column(nullable = false)
	private String uid;
	private String source;     //来源
	private int used;   //是否使用  0：没使用   1：使用
	private Date usedTime;  //被使用的时间
	@Column(nullable = false)
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

	public ButelNum(String butelNum, String uid, String appkey) {
		this.butelNum = butelNum;
		this.uid = uid;
		this.appkey = appkey;
	}

	public ButelNum() {
	}
}

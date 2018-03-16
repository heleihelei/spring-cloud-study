package com.channelsoft.study.cloud.butelmanageservice.entity;

//来源
public class Source {

	private String source;
	private String sourceDesc;    //描述
	private  int canApplyNum;    //该来源可以申请的butel号码总量
	private int applyNum;        //该来源已经申请的butel数量
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceDesc() {
		return sourceDesc;
	}
	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	public int getCanApplyNum() {
		return canApplyNum;
	}
	public void setCanApplyNum(int canApplyNum) {
		this.canApplyNum = canApplyNum;
	}
	@Override
	public String toString() {
		return "Source [source=" + source + ", sourceDesc=" + sourceDesc + ", canApplyNum=" + canApplyNum
				+ ", applyNum=" + applyNum + "]";
	}
	
	
}

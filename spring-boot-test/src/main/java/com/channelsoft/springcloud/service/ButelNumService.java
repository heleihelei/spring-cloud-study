package com.channelsoft.springcloud.service;


import com.channelsoft.springcloud.po.ButelNum;

import java.util.List;

public interface ButelNumService {
	
	void insertButelNum(ButelNum po);
	
	List<ButelNum> list(ButelNum po);
	

}

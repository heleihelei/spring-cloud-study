package com.channelsoft.study.cloud.butelmanageservice.service;


import com.channelsoft.study.cloud.butelmanageservice.entity.ButelDetail;
import com.channelsoft.study.cloud.butelmanageservice.entity.ButelNum;
import com.channelsoft.study.cloud.butelmanageservice.exception.IllegalSourceServiceException;
import com.channelsoft.study.cloud.butelmanageservice.exception.LessAuthBatelNumServiceException;
import com.channelsoft.study.cloud.butelmanageservice.exception.NotEnoughButelServiceException;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;

import java.util.List;

public interface ButelNumService {
	
	void insertButelNum(ButelNumPo po);
	
	List<ButelNum> list(ButelNumPo po);
	
	long total(ButelNumPo po);
	
	ButelDetail getDetail();

	List<ButelNum> applyButels(ButelNumPo po) throws NotEnoughButelServiceException,
			IllegalSourceServiceException,
			LessAuthBatelNumServiceException;
	void unbindButel(ButelNumPo po)  throws NotEnoughButelServiceException, IllegalSourceServiceException,
	LessAuthBatelNumServiceException;

	public ButelNumPo query(ButelNumPo po);

}

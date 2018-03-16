package com.channelsoft.study.cloud.butelmanageservice.service;


import com.channelsoft.study.cloud.butelmanageservice.entity.Source;
import com.channelsoft.study.cloud.butelmanageservice.exception.IllegalSourceServiceException;
import com.channelsoft.study.cloud.butelmanageservice.exception.LessAuthBatelNumServiceException;
import com.channelsoft.study.cloud.butelmanageservice.exception.ServiceException;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;

import java.util.List;

public interface SourceService {
	
	List<Source> queryAll() throws ServiceException;

	void saveOrUpdate(Source source) throws ServiceException;

	void validateApply(ButelNumPo butelNumPo) throws IllegalSourceServiceException,LessAuthBatelNumServiceException;

	

}

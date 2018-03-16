package com.channelsoft.study.cloud.butelmanageservice.service.impl;

import com.channelsoft.study.cloud.butelmanageservice.dao.SourceDao;
import com.channelsoft.study.cloud.butelmanageservice.entity.Source;
import com.channelsoft.study.cloud.butelmanageservice.exception.IllegalSourceServiceException;
import com.channelsoft.study.cloud.butelmanageservice.exception.LessAuthBatelNumServiceException;
import com.channelsoft.study.cloud.butelmanageservice.exception.ServiceException;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;
import com.channelsoft.study.cloud.butelmanageservice.service.BaseService;
import com.channelsoft.study.cloud.butelmanageservice.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl extends BaseService implements SourceService {
	
	@Autowired
	private SourceDao sourceDao;

	
	public List<Source> queryAll() throws ServiceException {
		logger.debug("进入SourceServiceImpl.queryAll()...");
		List<Source> list;
		try {
			list = sourceDao.queryAll();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new ServiceException("查询数据库出错");
		}
		
		return list;
	}

	
	public void saveOrUpdate(Source source) throws ServiceException {
		logger.debug("进入SourceServiceImpl.saveOrUpdate()...参数为{}", source);
		Source s = sourceDao.getBy(source.getSource());
		int r = 0;
		if (s == null) {
			//插入
			r = sourceDao.insert(source);
		} else {
			r = sourceDao.update(source);
		}
		if (r == 0) {
			throw new ServiceException("更新来源失败");
		}
	}


	public void validateApply(ButelNumPo butelNumPo) throws IllegalSourceServiceException, LessAuthBatelNumServiceException {
	}


}

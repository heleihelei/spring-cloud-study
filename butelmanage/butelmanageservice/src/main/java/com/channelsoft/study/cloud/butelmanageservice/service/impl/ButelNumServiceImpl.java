package com.channelsoft.study.cloud.butelmanageservice.service.impl;

import com.channelsoft.study.cloud.butelmanageservice.dao.ButelNumDao;
import com.channelsoft.study.cloud.butelmanageservice.entity.ButelDetail;
import com.channelsoft.study.cloud.butelmanageservice.entity.ButelNum;
import com.channelsoft.study.cloud.butelmanageservice.exception.*;
import com.channelsoft.study.cloud.butelmanageservice.po.ButelNumPo;
import com.channelsoft.study.cloud.butelmanageservice.po.InsertButelNumRet;
import com.channelsoft.study.cloud.butelmanageservice.service.BaseService;
import com.channelsoft.study.cloud.butelmanageservice.service.ButelNumService;
import com.channelsoft.study.cloud.butelmanageservice.service.SourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ButelNumServiceImpl extends BaseService implements ButelNumService {
	
	@Autowired
	private ButelNumDao butelNumDao;


	@Autowired
	private SourceService sourceService;
	
	private static ReentrantLock lock = new ReentrantLock();
	
	//线程池线程个数
	private static final int N_THREADS = 100;

	private static final ExecutorService pool = Executors.newFixedThreadPool(N_THREADS);
	/**
	 * 多线程调用
	 */
	public void insertButelNum(ButelNumPo po) {
		logger.debug("进入ButelNumServiceImpl.insertButelNum()...");
		ButelNum butelNum = new ButelNum();
		BeanUtils.copyProperties(po,butelNum);
		insertOne(butelNum);
	}

	public ButelNumPo query(ButelNumPo po) {
		logger.debug("进入ButelNumServiceImpl.query()...");
		ButelNum butelNum = butelNumDao.queryByNum(po.getButelNum());
		ButelNumPo butelNumPo = new ButelNumPo();
		BeanUtils.copyProperties(butelNum, butelNumPo);
		return butelNumPo;
	}
	
	private void insertOne(ButelNum bn) throws RepeatedNumServiceException,ServiceException{
		//TODO 调用butel接口注册butel号
		bn.setButelNum(bn.getUid().substring(0, 20));
		bn.setUsed(0);
		int ret = 0;
		try {
			ret = butelNumDao.insertButelNum(bn);
		} catch (Exception e) {
			logger.error("插入数据库出错butel号码=" + bn, e);
			throw new ServiceException("插入数据库出错butel号码=" + bn,e);
		}
		if (ret == 0) {
			throw new RepeatedNumServiceException("butel号码=" + bn + "，插入数据库重复");
		}
		
	}

	/**
	 * 分页查询
	 */
	public List<ButelNum> list(ButelNumPo po) {
		logger.debug("进入ButelNumServiceImpl.list()...{}", po);
		ButelNum bn = new ButelNum();
		BeanUtils.copyProperties(po, bn);
		List<ButelNum> list;
		try {
			list = butelNumDao.query(bn, (po.getPage() - 1) * po.getCount(), po.getCount(), po.getSortField(), po.getSortOrder());
		} catch (Exception e) {
			logger.error("查询出错", e);
			throw new ServiceException("查询出错",e);
		}
		return list;
	}
	
	public long total(ButelNumPo po) {
		logger.debug("进入ButelNumServiceImpl.total()...{}", po);
		ButelNum bn = new ButelNum();
		BeanUtils.copyProperties(po, bn);
		long size;
		try {
			size = butelNumDao.total(bn);
		} catch (Exception e) {
			logger.error("查询出错", e);
			throw new ServiceException("查询出错",e);
		}
		return size;
	}

	@Override
	public ButelDetail getDetail() {
		logger.debug("进入ButelNumServiceImpl.getDetail()...");
		ButelDetail ret = null;
		try {
			ret = butelNumDao.getDetail();
		} catch (Exception e) {
			logger.error("查询出错", e);
			throw new ServiceException("查询出错",e);
		}
		return ret;
	}
	
	class ButelAddTask implements Callable<Integer> {
		
		private String appkey;

		public ButelAddTask(String appkey) {
			super();
			this.appkey = appkey;
		}
		
		public Integer call() throws Exception {
			//调用butel接口注册
			return 1;
		}
		
		//调用butel注册接口
		private String invokeButel(String appkey, String uid) {
			//调用接口注册设备分机
			return null;
		}
		
		/*private String invokeButel(String appkey, String uid) {
			//调用接口注册设备分机
			double rondom = Math.random();
			if (rondom < 0.5) {
				throw new ServiceException("调用httpClient出错。。。");
			} else {
				try {
					Thread.sleep((long) (Math.random() * 10000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return uid.substring(0, 20);
		}*/
	}

	public List<ButelNum> applyButels(ButelNumPo po) throws NotEnoughButelServiceException,
			IllegalSourceServiceException,
			LessAuthBatelNumServiceException {
		logger.info("进入ButelNumServiceImpl.applyButels()...{}",po);

		return null;
	}
	public void unbindButel (ButelNumPo po){
		logger.info("进入ButelNumServiceImpl.unbindingButel()...{}",po);

		logger.info("离开ButelNumServiceImpl.unbindingButel()...{}",po);
/*
		List<ButelNum> butels=applyButels(po);
		return butels.get(0);*/
	}
	private int butelVerify(ButelNumPo po)
	{

		return 0;
	}

	private boolean unRegisterButel(String appkey, String uid,String butelNum)
	{
		return false;

	}
}

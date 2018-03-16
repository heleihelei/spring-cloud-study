package com.channelsoft.study.cloud.butelmanageservice.dao;

import com.channelsoft.study.cloud.butelmanageservice.entity.ButelDetail;
import com.channelsoft.study.cloud.butelmanageservice.entity.ButelNum;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ButelNumDao {
	
	int insertButelNum(ButelNum butelNum);
	
	ButelNum queryByNum(String butelNum);
	
	List<ButelNum> queryAll();
	
	List<ButelNum> query(@Param("butelNum") ButelNum butelNum,
                         @Param("index") long index,
                         @Param("count") long count,
                         @Param("sortField") String sortField,
                         @Param("sortOrder") String sortOrder);
	
	long total(@Param("butelNum") ButelNum butelNum);
	
	ButelDetail getDetail();
	
	int updateWithIn(@Param("source") String source, @Param("time") Date time, @Param("butels") List<ButelNum> butels);
	
	List<ButelNum> queryUnused(int num);

}

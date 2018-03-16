package com.channelsoft.study.cloud.butelmanageservice.dao;


import com.channelsoft.study.cloud.butelmanageservice.entity.Source;

import java.util.List;

public interface SourceDao {
	
	List<Source> queryAll();

	Source query(String source);

	int insert(Source source);
	
	int update(Source source);
	
	Source getBy(String source);

}

package com.channelsoft.springcloud.service.impl;

import com.channelsoft.springcloud.po.ButelNum;
import com.channelsoft.springcloud.service.ButelNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * <dl>
 * <dt>ButelNumServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/14</dd>
 * </dl>
 *
 * @author cuihc
 */
@Service
public class ButelNumServiceImpl implements ButelNumService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertButelNum(ButelNum po) {
        jdbcTemplate.update("insert into butel_num(butel_num,uid,appkey) VALUES (?,?,?)", new Object[]{po.getButelNum(),po.getUid(),po.getAppkey()});
    }

    @Override
    public List<ButelNum> list(ButelNum po) {
        return jdbcTemplate.query("select * from butel_num", new RowMapper<ButelNum>() {
            @Override
            public ButelNum mapRow(ResultSet resultSet, int i) throws SQLException {
                ButelNum butelNum = new ButelNum();
                butelNum.setAppkey(resultSet.getString("appkey"));
                butelNum.setButelNum(resultSet.getString("butel_num"));
                butelNum.setUid(resultSet.getString("uid"));
                return butelNum;
            }
        });
    }
}

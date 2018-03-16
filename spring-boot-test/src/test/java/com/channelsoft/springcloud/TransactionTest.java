package com.channelsoft.springcloud;

import com.channelsoft.springcloud.po.ButelNum;
import com.channelsoft.springcloud.service.ButelNumRepository;
import com.channelsoft.springcloud.service.ButelNumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <dl>
 * <dt>TransactionTest</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018/3/14</dd>
 * </dl>
 *
 * @author cuihc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TransactionTest {

    @Autowired
    private ButelNumService butelNumService;
    @Autowired
    private ButelNumRepository butelNumRepository;

    @Test
    @Transactional
    public void test() {
        ButelNum butelNum1 = new ButelNum("111","111","111");
        ButelNum butelNum2 = new ButelNum("1111111111111111111111111111111111111111111111111111111","111","111");
        butelNumService.insertButelNum(butelNum1);
        butelNumRepository.save(butelNum2);
    }
}

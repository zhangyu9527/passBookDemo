package com.zhangyu.passbook.merchants.service;

import com.alibaba.fastjson.JSON;
import com.zhangyu.passbook.merchants.vo.CreateMerchantsRequest;
import com.zhangyu.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 商户服务测试类

 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {
    @Autowired
    private IMerchantsServ merchantsServ;
    @Test
    @Transactional//测试执行成功后会默认删除数据库中的测试数据(事务回滚)
    public void testCreateMerchantServ(){
        CreateMerchantsRequest request=new CreateMerchantsRequest();
        request.setName("章玉");
        request.setLogoUrl("www.bilibili.com");
        request.setBusinessLicenseUrl("www.bilibili.com");
        request.setPhone("1112121212");
        request.setAddress("杭州市");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    @Test
    public void testBuildMerchantsInfoById(){
       System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfById(3)));
    }
    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate=new PassTemplate();
        passTemplate.setId(3);
        passTemplate.setTitle("title:章玉");
        passTemplate.setSummary("简介:zhangyu");
        passTemplate.setDesc("详情:zhangyu");
        passTemplate.setLimit(100000L);//long类型
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));
        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}

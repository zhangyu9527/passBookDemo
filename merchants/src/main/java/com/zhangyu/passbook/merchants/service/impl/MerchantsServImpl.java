package com.zhangyu.passbook.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhangyu.passbook.merchants.constant.Constants;
import com.zhangyu.passbook.merchants.constant.ErrorCode;
import com.zhangyu.passbook.merchants.dao.MerchantsDao;
import com.zhangyu.passbook.merchants.entity.Merchants;
import com.zhangyu.passbook.merchants.service.IMerchantsServ;
import com.zhangyu.passbook.merchants.vo.CreateMerchantsRequest;
import com.zhangyu.passbook.merchants.vo.CreateMerchantsResponse;
import com.zhangyu.passbook.merchants.vo.PassTemplate;
import com.zhangyu.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商户服务接口实现
 */
@Slf4j
@Service
public class MerchantsServImpl  implements IMerchantsServ {
    private static  final Logger log = LoggerFactory.getLogger(MerchantsServImpl.class);
    //Merchants 数据库
    private final MerchantsDao merchantsDao;
    //kafka 客户端
    private final KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao,
                             KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    @Transactional//事务回滚
    public Response createMerchants(CreateMerchantsRequest request) {
        Response response=new Response();
        CreateMerchantsResponse merchantsResponse=new CreateMerchantsResponse();
        ErrorCode errorCode=request.validate(merchantsDao);
        if(errorCode!=ErrorCode.SUCCESS){
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else{
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }
        response.setData((merchantsResponse));
        return response;
    }

    @Override
    public Response buildMerchantsInfById(Integer id) {
        Response response=new Response();
        Merchants merchants=merchantsDao.findById(id);
        if(merchants==null){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        Response response=new Response();
        ErrorCode errorCode=template.validate(merchantsDao);
        if(errorCode!=ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else{
            String passTemplate= JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passTemplate
            );
            log.info("DropPassTemplates:{}" ,passTemplate);
        }
        return null;
    }


}

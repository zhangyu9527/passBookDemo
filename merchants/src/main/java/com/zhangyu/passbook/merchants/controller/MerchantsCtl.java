package com.zhangyu.passbook.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.zhangyu.passbook.merchants.entity.Merchants;
import com.zhangyu.passbook.merchants.service.IMerchantsServ;
import com.zhangyu.passbook.merchants.vo.CreateMerchantsRequest;
import com.zhangyu.passbook.merchants.vo.PassTemplate;
import com.zhangyu.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商户服务controller
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsCtl {
    //private  static final Logger log= LoggerFactory.getLogger(MerchantsCtlr.class);
    private  final IMerchantsServ merchantsServ;
    @Autowired
    public MerchantsCtl(IMerchantsServ merchantsServ){
        this.merchantsServ=merchantsServ;
    }
    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants:{}" , JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);

    }
    @ResponseBody
    @GetMapping("{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo:{}",id);
        return merchantsServ.buildMerchantsInfById(id);
    }
    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("DropPassTemplate:{}" ,passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}

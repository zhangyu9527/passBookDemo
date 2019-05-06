package com.zhangyu.passbook.merchants.service;

import com.zhangyu.passbook.merchants.vo.CreateMerchantsRequest;
import com.zhangyu.passbook.merchants.vo.PassTemplate;
import com.zhangyu.passbook.merchants.vo.Response;

/**
 * 队商户服务接口定义
 */
public interface IMerchantsServ {
    /**
     * 创建商户服务
     * @param request
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据id 构造商户信息
     * @param id
     * @return
     */
    Response buildMerchantsInfById(Integer id);

    /**
     * 投放优惠券
     * @return
     */
    Response dropPassTemplate(PassTemplate template);

}

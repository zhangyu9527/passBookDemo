//zhangyu de code
package com.zhangyu.passbook.passbook.service;

import com.zhangyu.passbook.passbook.vo.GainPassTemplateRequest;
import com.zhangyu.passbook.passbook.vo.Response;


//用户领取优惠券功能实现
public interface IGainPassTemplateService {
    //用户领取优惠券
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}

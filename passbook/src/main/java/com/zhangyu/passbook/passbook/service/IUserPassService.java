//zhangyu de code
package com.zhangyu.passbook.passbook.service;

import com.zhangyu.passbook.passbook.vo.Pass;
import com.zhangyu.passbook.passbook.vo.Response;

//获取用户个人优惠券信息
public interface IUserPassService {
    //获取用户个人优惠券信息,
    Response getUserPassInfo(Long userId) throws Exception;
    //获取用户已经消费的优惠券
    Response getUserUsedPassInfo(Long userId) throws Exception;
    //获取用户所有的优惠券
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * 用户使用优惠券
     */
    Response userUsePass(Pass pass);
}

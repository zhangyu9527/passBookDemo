//zhangyu de code
package com.zhangyu.passbook.passbook.service;

import com.zhangyu.passbook.passbook.vo.Response;

//获取库存完整信息 只返回用户没有领取的
public interface IInventoryService {
    //获取库存信息
    Response getInventoryInfo(Long userId) throws Exception;


}

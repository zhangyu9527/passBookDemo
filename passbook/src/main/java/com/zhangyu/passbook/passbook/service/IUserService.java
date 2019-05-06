package com.zhangyu.passbook.passbook.service;

import com.zhangyu.passbook.passbook.vo.Response;
import com.zhangyu.passbook.passbook.vo.User;

//用户服务 创建User 服务
public interface IUserService {
    //创建用户
    Response createUser(User user) throws Exception;
}

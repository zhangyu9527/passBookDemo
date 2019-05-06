package com.zhangyu.passbook.passbook.service;

import com.zhangyu.passbook.passbook.vo.Feedback;
import com.zhangyu.passbook.passbook.vo.Response;

//评论功能
public interface IFeedbackService {
    //创建评论
    Response createFeedback(Feedback feedback);
    //获取用户评论
    Response getFeedback(Long userId);

}

package com.zhangyu.passbook.passbook.utils;

import com.zhangyu.passbook.passbook.vo.Feedback;
import com.zhangyu.passbook.passbook.vo.GainPassTemplateRequest;
import com.zhangyu.passbook.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * RowKey 生成器工具类
 */
@Slf4j
public class RowKeyGenUtil {
    /**
     * 根据提供的PassTemplate 对象生成RowKey
     */
    public static String genPassTemplateRowKey(PassTemplate passTemplate){
        String passInfo=String.valueOf(passTemplate.getId())+"_"+passTemplate.getTitle();
        String rowKey= DigestUtils.md5Hex(passInfo);//使用MD5将rowKey分散.使的分布式Hbase数据不会集中在一起
        log.info("GenPassTemplateRowKey:{},{}",passInfo,rowKey);
        return rowKey;
    }
    /**
     *     根据提供的领取优惠券请求生成RowKey , 只可以在领取优惠券的时候使用
     * Pass RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     */
    public static String genPassRowKey(GainPassTemplateRequest request){
        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                +(Long.MAX_VALUE-System.currentTimeMillis())
                +genPassTemplateRowKey(request.getPassTemplate());
    }
    /**
     * 根据Feedback构造Rowkey
     * @param feedback
     * @return
     */
    public static String genFeedbackRowKey(Feedback feedback){
        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString()+
                (Long.MAX_VALUE-System.currentTimeMillis());

    }

}

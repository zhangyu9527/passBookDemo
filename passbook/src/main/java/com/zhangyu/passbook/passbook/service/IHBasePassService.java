package com.zhangyu.passbook.passbook.service;

import com.zhangyu.passbook.passbook.vo.PassTemplate;

/**
 * Pass HBase 服务
 */
public interface IHBasePassService {
    /**
     * 将PassTemplate 写入HBase
     * @param passTemplate
     * @return
     */
    boolean dropPassTemplateToBase(PassTemplate passTemplate);
}

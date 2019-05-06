//zhangyu de code
package com.zhangyu.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户领取优惠券的请求对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {
    private Long userId;
    private PassTemplate passTemplate;

}

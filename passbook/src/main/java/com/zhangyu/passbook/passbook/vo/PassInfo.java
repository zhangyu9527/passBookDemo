//zhangyu de code
package com.zhangyu.passbook.passbook.vo;

import com.zhangyu.passbook.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户领取的优惠券信息
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassInfo {
    private Pass pass;

    private PassTemplate passTemplate;

    private Merchants merchants;
}

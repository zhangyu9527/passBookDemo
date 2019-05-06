//zhangyu de code
package com.zhangyu.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//库存请求响应
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private Long userid;

    private List<PassTemplateInfo> passTemplateInfos;
}

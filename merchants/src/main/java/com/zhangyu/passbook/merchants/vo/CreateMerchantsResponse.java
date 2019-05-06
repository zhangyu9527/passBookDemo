package com.zhangyu.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {
        private Integer id;//商户id 创建失败则为-1

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
}

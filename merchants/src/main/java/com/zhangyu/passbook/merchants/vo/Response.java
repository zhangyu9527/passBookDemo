package com.zhangyu.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    //错误码 正确返回0
    private Integer errorCode=0;
    //错误信息, 正确返回空字符串
    private String errorMsg="";

    private Object data;

    public Response(Object data) {
        this.data = data;
    }
//    public Response(){
//
//    }
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

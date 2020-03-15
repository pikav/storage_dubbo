package com.storage.api.response;

import com.storage.api.enums.ResponseStatus;

import java.io.Serializable;

/***
 * 分布式商城系统-仓储系统： 通用响应类，返回rpc调用结果
 * @author pikav
 * @date 2020-3-7
 */
public class BaseResponse<T> implements Serializable {

    // 状态码：0 成功， 1 失败
    private Integer code;
    // 结果信息
    private String msg;
    // 接收数据
    private T data;

    public BaseResponse(ResponseStatus responseStatus) {
        this.code = responseStatus.getCode();
        this.msg = responseStatus.getMsg();
    }

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}

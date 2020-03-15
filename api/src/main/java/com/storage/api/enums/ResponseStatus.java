package com.storage.api.enums;

/***
 * @description: 分布式商城系统-仓储系统： 返回信息选项
 * @author pikav
 * @date 2020-3-7
 */
public enum ResponseStatus {

    Success(0,"成功"),
    Fail(-1,"失败"),
    InvalidParams(200,"无效的参数"),
    ItemNotExixt(201,"不存在");

    private Integer code;
    private  String msg;

    ResponseStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

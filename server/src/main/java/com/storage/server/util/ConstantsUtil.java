package com.storage.server.util;

/***
 * @description: 分布式商城系统-仓储系统： 常量工具类
 * @author pikav
 * @date 2020-3-8
 */
public class ConstantsUtil {

    public static final String SUCCESS = "成功";

    public static final String FAIL = "失败";

    /**
     * @description: 创建一个36位的ID号
     * @return
     * @author: pikav
     */
    public static String getID(){
        return java.util.UUID.randomUUID().toString();
    }

}

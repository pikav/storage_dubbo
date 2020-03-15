package com.storage.server.util;

import java.util.List;

/***
 * @description: 分布式商城系统-仓储系统： 数据有效性校验
 * @author pikav
 * @date 2020-3-8
 */
public class ValidateUtil {

    /**
     * @description: isNullOrEmpty(这里用一句话描述这个方法的作用)
     * @param objs
     * @return boolean
     * @author: pikav
     */
    public static boolean isNullOrEmpty(Object... objs){
        List temp = null;

        for(Object obj : objs) {
            if(obj == null || "".equals(obj) || "null".equals(obj)) return true;

            if(obj instanceof String && "".equals(((String)obj).trim())){
                return false;
            }

            if(obj instanceof List){
                temp = (List) obj;
                if(temp.isEmpty() || temp.size() == 0 || (temp.size() > 0 && temp.get(0) == null)){
                    return  true;
                }
            }
        }
        return false;
    }

}

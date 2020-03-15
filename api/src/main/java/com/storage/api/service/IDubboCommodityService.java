package com.storage.api.service;

import com.storage.api.response.BaseResponse;

/***
 * 分布式商城系统-仓储系统： 仓储商品服务
 * @author pikav
 * @date 2020-3-7
 */
public interface IDubboCommodityService {

    // 查询商品： 分页,模糊查询
    BaseResponse commodityPageListBySearch(String pageNo, String pageSize, String search);

}

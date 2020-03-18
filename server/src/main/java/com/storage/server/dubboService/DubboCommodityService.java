package com.storage.server.dubboService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.storage.api.enums.ResponseStatus;
import com.storage.api.response.BaseResponse;
import com.storage.api.service.IDubboCommodityService;
import com.storage.model.mapper.CommodityMapper;
import com.storage.server.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/***
 * @description: 分布式商城系统-仓储系统： 仓储商品服务实现类
 * @author pikav
 * @date 2020-3-7
 */
@Service
@Path("commodity")
public class DubboCommodityService implements IDubboCommodityService {

    private static final Logger log = LoggerFactory.getLogger(DubboCommodityService.class);

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * @description: 查询商品：分页，模糊查询
     * @param pageNo
     * @param pageSize
     * @param search
     * @return
     * @author: pikav
     */
    @Path("/list")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public BaseResponse commodityPageListBySearch(
            @QueryParam(value = "pageNo") String pageNo,
            @QueryParam(value = "pageSize") String pageSize,
            @QueryParam(value = "search") String search) {

        Integer pageNo_int, pageSize_int;
        if(ValidateUtil.isNullOrEmpty(pageNo,pageSize)){
            pageNo_int = 1;
            pageSize_int = 6;
        } else {
            pageNo_int = Integer.parseInt(pageNo);
            pageSize_int = Integer.parseInt(pageSize);
        }
        BaseResponse baseRespons = new BaseResponse(ResponseStatus.Success);
        try {
            PageHelper.startPage(pageNo_int,pageSize_int);
            PageInfo pageInfo = new PageInfo(commodityMapper.selectAllBySearch(pageNo_int,pageSize_int,search));
            baseRespons.setData(pageInfo);
        } catch (Exception e) {
            baseRespons = new BaseResponse(ResponseStatus.Fail);
            log.info("查询商品列表失败",e.fillInStackTrace());
            e.printStackTrace();
        }
        return baseRespons;
    }

}

package com.storage.server.dubboService;

import com.alibaba.dubbo.config.annotation.Service;
import com.storage.api.enums.ResponseStatus;
import com.storage.api.response.BaseResponse;
import com.storage.api.service.IDubboTestService;

import javax.ws.rs.Path;

@Service
@Path("test")
public class DubboTestService implements IDubboTestService {

    @Path("/test")
    public BaseResponse dubboTest(String msg) {
        BaseResponse baseResponse = new BaseResponse(ResponseStatus.Success);
        return baseResponse;
    }

}

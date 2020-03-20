package com.storage.api.service;

import com.storage.api.response.BaseResponse;

public interface IDubboTestService {

    BaseResponse dubboTest(String msg);

}

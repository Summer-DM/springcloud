package com.summer.springcloud.springcloudcloud.callback;

import com.alibaba.fastjson.JSONObject;
import com.summer.springcloud.springcloudcloud.ScUserService;
import com.summer.springcloud.springcloudcommon.commonResult.Result;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 04:42
 **/

@Component
public class ScUserServiceCallback implements FallbackFactory<ScUserService> {
    @Override
    public ScUserService create (Throwable throwable) {
        return new ScUserService() {

            @Override
            public Result<JSONObject> getScUserPageData(String name, String pageNum, String pageSize) {
                Result result = new Result(throwable);
                return result;
            }

            @Override
            public Result addScUser(String name, String password) {
                Result result = new Result(throwable);
                return result;
            }
        };
    }
}

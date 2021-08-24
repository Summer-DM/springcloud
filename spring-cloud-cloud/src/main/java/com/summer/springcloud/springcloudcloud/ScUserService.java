package com.summer.springcloud.springcloudcloud;

import com.alibaba.fastjson.JSONObject;
import com.summer.springcloud.springcloudcloud.callback.ScUserServiceCallback;
import com.summer.springcloud.springcloudcommon.commonResult.Result;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 04:45
 **/

@FeignClient(value = "spring-cloud-user", fallbackFactory = ScUserServiceCallback.class)
public interface ScUserService {
    /**
     * 获取用户--分页
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result<JSONObject> getScUserPageData(String name,String pageNum, String pageSize);

    /**
     * 添加用户
     *
     * @param name
     * @param password
     * @return
     */
    Result addScUser( String name,String password);

}

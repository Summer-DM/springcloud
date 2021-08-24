package com.summer.springcloud.springcloudweb.service;

import com.summer.springcloud.springcloudcommon.commonResult.Result;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 05:54
 **/
public interface WebService {

    Result login(String name, String password);

    Result register(String name, String password);
}

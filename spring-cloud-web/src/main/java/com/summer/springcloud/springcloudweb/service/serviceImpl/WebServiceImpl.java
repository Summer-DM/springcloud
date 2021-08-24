package com.summer.springcloud.springcloudweb.service.serviceImpl;

import com.summer.springcloud.springcloudcommon.commonResult.Result;
import com.summer.springcloud.springcloudweb.mapper.WebMapper;
import com.summer.springcloud.springcloudweb.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 05:56
 **/
@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private WebMapper webMapper;

    @Override
    public Result login(String name, String password) {
        webMapper.login(name,password);
        return null;
    }

    @Override
    public Result register(String name, String password) {
        webMapper.register(name,password);
        return null;
    }
}

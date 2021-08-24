package com.summer.springcloud.springcloudweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.summer.springcloud.springcloudcommon.commonResult.Result;
import com.summer.springcloud.springcloudweb.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/12 下午 03:26
 **/
@RestController
public class WebController {

    @Autowired
    private WebService webService;
    /**
     * 测试页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/test")
    private String test(ModelMap map) {
        map.put("title", "index界面");
        map.put("message","hello");
        return "test";
    }
    /**
     * 登录界面
     * @param map
     * @return
     */
    @RequestMapping(value = "/open/login")
    public String login(ModelMap map) {
        map.put("title", "登录");
        map.put("path", "path");
        map.put("message","");
        return "login";
    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST, RequestMethod.GET})
    public Result<JSONObject> login(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String password) {
        Result result = webService.login(name,password);
        return result;
    }

    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/register",method = {RequestMethod.POST, RequestMethod.GET})
    public Result<JSONObject> register(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String password) {
        Result result = webService.register(name,password);
        return result;
    }
}

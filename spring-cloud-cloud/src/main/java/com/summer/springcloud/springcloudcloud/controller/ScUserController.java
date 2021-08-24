package com.summer.springcloud.springcloudcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.summer.springcloud.springcloudcloud.ScUserService;
import com.summer.springcloud.springcloudcommon.commonResult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 04:57
 **/
@RequestMapping("/scUser1")
@Controller
public class ScUserController {

    @Autowired
    private ScUserService userService;

    /**
     * 获取用户--分页
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getScUserPageData",method = {RequestMethod.POST, RequestMethod.GET})
    public Result<JSONObject> getScUserPageData(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String pageNum,
                                                @RequestParam(required = false) String pageSize) {
        Result result = userService.getScUserPageData(name,pageNum,pageSize);
        return result;
    }

    @RequestMapping(value = "/addScUser")
    public Result addScUser(@RequestParam(value = "name", required = false) String name,
                     @RequestParam(value = "password", required = false) String password){
        Result result = userService.addScUser(name,password);
        return result;
    }

}

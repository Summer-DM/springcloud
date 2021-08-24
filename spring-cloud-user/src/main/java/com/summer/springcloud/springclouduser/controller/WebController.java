package com.summer.springcloud.springclouduser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/12 上午 09:32
 **/
@Controller
@CrossOrigin
public class WebController {
    /**
     * test json
     * @param map
     * @return
     */
    @RequestMapping(value = "/test")
    private String test(ModelMap map) {
        map.put("title", "index界面");
        map.put("message","hello");
        return "test";
    }


}

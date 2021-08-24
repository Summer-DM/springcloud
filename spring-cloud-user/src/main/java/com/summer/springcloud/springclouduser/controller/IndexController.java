package com.summer.springcloud.springclouduser.controller;

import com.summer.springcloud.springclouduser.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/12 上午 09:32
 **/
@Controller
@CrossOrigin
public class IndexController {
    /**
     * 首页
     * @param map
     * @return
     */
    @RequestMapping(value = "/index")
    private String index(ModelMap map, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        map.addAttribute("user", user);
        //测试自定义错误返回页面
        //int i = 1/0;
        return "index";
    }

}

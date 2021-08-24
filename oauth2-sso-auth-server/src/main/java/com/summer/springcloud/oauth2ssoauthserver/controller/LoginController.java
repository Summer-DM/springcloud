package com.summer.springcloud.oauth2ssoauthserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Summer_DM
 * @Summary TODO  登录页、首页
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}

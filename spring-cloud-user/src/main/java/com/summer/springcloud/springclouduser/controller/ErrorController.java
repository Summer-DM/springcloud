package com.summer.springcloud.springclouduser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author Summer_DM
 * @Summary TODO  自定义全局错误视图ErrorController继承BasicErrorController并添加@Controller注解，把ErrorController注册到mvc容器中）
 * TODO 全局异常分为俩种，
 *          一种是自定义异常和错误，本类就是自定义错误返回；
 *          一种是自定义全局捕获异常，使用@ControllerAdvice注解+@ExceptionHandler(Exception.class)
 * @Version 1.0
 * @Date 2021/8/19 下午 03:27
 **/
@Controller
public class ErrorController extends BasicErrorController {
    //添加构造方法，因为在创建BasicErrorController实例需要传递参数，使用@Autowired注入所需参数
    @Autowired
    public ErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties , List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }
    //重定义网页请求时处理，直接浏览器访问
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML));
        model.put("Message", "出错啦！");
        ModelAndView mav = new ModelAndView("errorPage", model, status);
        return mav;
    }
    //重定义接口请求时处理，postman
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML));
        body.put("Message", "出错啦！");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }
}

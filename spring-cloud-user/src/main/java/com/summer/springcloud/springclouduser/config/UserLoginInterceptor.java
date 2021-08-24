package com.summer.springcloud.springclouduser.config;

import com.summer.springcloud.springclouduser.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Summer_DM
 * @Summary TODO 登录拦截器
 * @Version 1.0
 * @Date 2021/8/19 下午 04:56
 **/
public class UserLoginInterceptor implements HandlerInterceptor {
    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     * 如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
     * 如果设置为true时，请求将会继续执行后面的操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了拦截器的preHandle方法");
        try {
            HttpSession session = request.getSession();
            //统一拦截（查询当前session是否存在user）(这里user会在每次登录成功后，写入session)
            //User user = (User) session.getAttribute("user");
            //if (user != null) {
                //TODO 这里可以写拦截的逻辑
                return true;
            //}
            //response.sendRedirect(request.getContextPath() + "login");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /***
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了拦截器的postHandle方法");
    }

    /***
     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行了拦截器的afterCompletion方法");
    }
}

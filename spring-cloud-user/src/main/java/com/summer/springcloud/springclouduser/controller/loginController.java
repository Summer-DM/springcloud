package com.summer.springcloud.springclouduser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.springcloud.springcloudcommon.commonResult.ErrorEnum;
import com.summer.springcloud.springcloudcommon.commonResult.Result;
import com.summer.springcloud.springclouduser.entity.ScUser;
import com.summer.springcloud.springclouduser.mapper.ScUserMapper;
import com.summer.springcloud.springclouduser.service.ScUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/19 下午 04:45
 **/
@Controller
public class loginController {
    private static final Logger log= LoggerFactory.getLogger(loginController.class);

    @Value("${server.port}")
    private String port;
    @Autowired
    private ScUserService userService;

    @Autowired
    private ScUserMapper userMapper;

    @RequestMapping(value = {"/loginIndex"}, method = RequestMethod.GET)
    public String loginIndex() {
        return "login";
    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Result login(@RequestParam(required = false) String name,
                        @RequestParam(required = false) String password,
                        ModelMap model, HttpServletRequest request) {
        Result result = new Result();
        try {
            if(name==null||"".equals(name)){
                result.setType(String.valueOf(ErrorEnum.UserNameNull.getCode()));
                result.setMessage(ErrorEnum.UserNameNull.getDescription());
            }else if(password==null||"".equals(password)){
                result.setType(String.valueOf(ErrorEnum.PasswordNull.getCode()));
                result.setMessage(ErrorEnum.PasswordNull.getDescription());
            }else{
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("name",name);
                wrapper.eq("password", DigestUtils.md5Hex(password));
                ScUser user = userMapper.selectOne(wrapper);
                if(user!=null){
                    result.setType(String.valueOf(ErrorEnum.LoginSuccess.getCode()));
                    result.setMessage(ErrorEnum.LoginSuccess.getDescription());
                    //在正确登录之后，就将user保存到session中，再次访问页面的时候，登录拦截器就可以找到这个user对象，就不需要再次拦截到登录界面了.
                    model.addAttribute("user", user);
                    request.getSession().setAttribute("user", user);
                }else{
                    result.setType(String.valueOf(ErrorEnum.ErrUserNameORPassword.getCode()));
                    result.setMessage(ErrorEnum.ErrUserNameORPassword.getDescription());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setType(String.valueOf(ErrorEnum.OperationErr.getCode()));
            result.setMessage(ErrorEnum.OperationErr.getDescription());
        }
        return result;
    }
}

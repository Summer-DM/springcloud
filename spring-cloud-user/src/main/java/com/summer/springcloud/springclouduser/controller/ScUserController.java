package com.summer.springcloud.springclouduser.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.summer.springcloud.springcloudcommon.commonResult.ErrorEnum;
import com.summer.springcloud.springcloudcommon.commonResult.Result;
import com.summer.springcloud.springcloudcommon.utils.dateUtils.DateUtils;
import com.summer.springcloud.springcloudcommon.utils.paramUtils.ParamUtils;
import com.summer.springcloud.springclouduser.entity.ScUser;
import com.summer.springcloud.springclouduser.mapper.ScUserMapper;
import com.summer.springcloud.springclouduser.service.ScUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  用户处理类
 * @author Summer_DM
 * @since 2021-08-16
 */
@RestController
@RequestMapping("/scUser")
public class ScUserController {

    private static final Logger log= LoggerFactory.getLogger(ScUserController.class);

    @Value("${server.port}")
    private String port;
    @Autowired
    private ScUserService userService;

    @Autowired
    private ScUserMapper userMapper;

    /**
     * 添加用户
     * @param request
     * @param response
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "addScUser",method = {RequestMethod.POST, RequestMethod.GET})
    public Result addScUser(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        Result result = new Result();
        ScUser user = new ScUser();
        String name = ParamUtils.getString(request,"name","");
        String password = ParamUtils.getString(request,"password","");
        String birthday = ParamUtils.getString(request,"birthday","");
        String sex = ParamUtils.getString(request,"sex","");
        String age = ParamUtils.getString(request,"age","");
        String address = ParamUtils.getString(request,"address","");
        try {
            if(name==null||"".equals(name)){
                result.setType(String.valueOf(ErrorEnum.UserNameNull.getCode()));
                result.setMessage(ErrorEnum.UserNameNull.getDescription());
            }else if(password==null||"".equals(password)){
                result.setType(String.valueOf(ErrorEnum.PasswordNull.getCode()));
                result.setMessage(ErrorEnum.PasswordNull.getDescription());
            }else{
                QueryWrapper<ScUser> wrapper = new QueryWrapper();
                wrapper.eq("name",name);
                if(userMapper.selectOne(wrapper)!=null){
                    result.setType(String.valueOf(ErrorEnum.ExistUser.getCode()));
                    result.setMessage(ErrorEnum.ExistUser.getDescription());
                }else{
                    user.setName(name);
                    user.setPassword(DigestUtils.md5Hex(password));
                    user.setAddress(address);
                    user.setAge(age);
                    user.setBirthday(DateUtils.parse(birthday,"yyyy-MM-dd"));
                    user.setSex(sex);
                    Boolean flag = userService.insert(user);
                    if(flag){
                        result.setType(String.valueOf(ErrorEnum.SuccessfulResponse.getCode()));
                        result.setMessage(ErrorEnum.SuccessfulResponse.getDescription());
                    }else{
                        result.setType(String.valueOf(ErrorEnum.FailedResponse.getCode()));
                        result.setMessage(ErrorEnum.FailedResponse.getDescription());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setType(String.valueOf(ErrorEnum.OperationErr.getCode()));
            result.setMessage(ErrorEnum.OperationErr.getDescription());
        }
        return result;
    }

    /**
     * 获取用户--分页
     * @param name  传入参数
     * @param pageNum   页数
     * @param pageSize   条数
     * @return
     * QueryWrapper的用法：
     * wrapper.eq(" id ", " 151 ");//id =151
     * wrapper.eq("name","151");//查询名称为151的数据
     * wrapper.isNotNull("name");//名称不为空
     * wrapper.isNull("name");//名称为空
     * wrapper.ge("id","151");//查询id大于等于151，id>=151
     * wrapper.gt("id","151");//查询id小于等于151，id<>>=151
     * wrapper.between("id","100","150");//查询id为100到150之间的数据
     * wrapper.like("name","151");//查询name里含有151的数据，相等于%151%
     * wrapper.notLike("name","151");//查询name里不含有151的数据
     * wrapper.likeLeft("name","100");//查询名称开头为100的数据，相等于100%
     * wrapper.likeRight("name","100");//查询名称结尾为100的数据，相等于%100
     * wrapper.orderByDesc("id");//降序
     * wrapper.orderByAsc("id");//升序
     * wrapper.inSql("id","select id from user where sid=20"); //一个SQL语句写的子查询
     */
    @RequestMapping(value = "getScUserPageData",method = {RequestMethod.POST, RequestMethod.GET})
    public Result<JSONObject> getScUserPageData(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String pageNum,
                                                @RequestParam(required = false) String pageSize) {
        Result result = new Result();
        try {
            if(pageNum==null||"".equals(pageNum)) {
                pageNum = "1";
            }
            if(pageSize==null||"".equals(pageSize)) {
                pageSize = "10";
            }
            Page pages=new Page(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
            QueryWrapper<ScUser> w= new QueryWrapper();
            if(name!=null||!"".equals(name)) {
                w.like("name",name);
            }
            Page page = userMapper.selectPage(pages, w);
            pages.setRecords( page.getRecords());
            if(pages.getTotal()>0){
                result.setType("success");
                result.setMessage("有数据");
            }else{
                result.setType("fail");
                result.setMessage("无数据");
            }
            result.setData(pages);
        }catch (Exception e){
            e.printStackTrace();
            result.setType("fail");
            result.setMessage("获取用户数据发生异常");
        }
        return result;
    }
}


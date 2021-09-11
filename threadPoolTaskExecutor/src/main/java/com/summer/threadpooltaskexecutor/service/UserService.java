package com.summer.threadpooltaskexecutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.threadpooltaskexecutor.model.Customer;
import com.summer.threadpooltaskexecutor.model.ScUser;

/**
 * @Author Summer_DM
 * @Summary TODO  user接口
 * @Version 1.0
 * @Date 2021/9/6 上午 09:19
 **/
public interface UserService extends IService<ScUser> {

    ScUser getUsers(String name);

}

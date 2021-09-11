package com.summer.threadpooltaskexecutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.threadpooltaskexecutor.mapper.UserMapper;
import com.summer.threadpooltaskexecutor.model.Customer;
import com.summer.threadpooltaskexecutor.model.ScUser;
import com.summer.threadpooltaskexecutor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author Summer_DM
 * @Summary TODO  user实现逻辑
 * @Version 1.0
 * @Date 2021/9/6 上午 09:19
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, ScUser> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    //@Async("asyncServiceExecutor")
    public ScUser getUsers(String id) {
        QueryWrapper<ScUser> wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        ScUser scUser = userMapper.selectById(id);
        return scUser;
    }
}

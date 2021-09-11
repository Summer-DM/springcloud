package com.summer.threadpooltaskexecutor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.summer.threadpooltaskexecutor.model.Customer;
import com.summer.threadpooltaskexecutor.model.ScUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Summer_DM
 * @Summary TODO  user数据层
 * @Version 1.0
 * @Date 2021/9/6 上午 09:22
 **/
@Mapper
public interface UserMapper extends BaseMapper<ScUser> {

}

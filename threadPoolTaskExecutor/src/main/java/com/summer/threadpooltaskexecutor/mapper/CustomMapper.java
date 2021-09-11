package com.summer.threadpooltaskexecutor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.summer.threadpooltaskexecutor.model.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Summer_DM
 * @Summary TODO  客户数据接口
 * @Version 1.0
 * @Date 2021/9/3 下午 02:45
 **/
@Mapper
public interface CustomMapper extends BaseMapper<Customer> {
    @Override
    int insert(Customer entity);
}

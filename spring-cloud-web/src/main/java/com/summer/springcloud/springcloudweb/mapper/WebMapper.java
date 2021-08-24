package com.summer.springcloud.springcloudweb.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 06:00
 **/
@Mapper
public interface WebMapper {

    void login(String name, String password);

    void register(String name, String password);
}

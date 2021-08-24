package com.summer.springcloud.springcloudcommon.commonResult;

/**
 * @Author Summer_DM
 * @Summary TODO  定义枚举解耦，用来统一描述返回错误
 * @Version 1.0
 * @Date 2021/8/16 下午 05:11
 **/
public interface BaseErrorInfoInterface {
    //获取code
    public Integer getCode();
    //获取描述
    public String getDescription();
}

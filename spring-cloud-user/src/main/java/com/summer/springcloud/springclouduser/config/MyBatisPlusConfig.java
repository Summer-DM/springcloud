package com.summer.springcloud.springclouduser.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Summer_DM
 * @Summary TODO  Mybatis-Plus 配置
 * @Version 1.0
 * @Date 2021/8/18 下午 02:38
 **/
@Configuration    //表明是一个配置类
public class MyBatisPlusConfig {
    /**
     * Mybatis-Plus 配置分页插件（不如不配置，则查出来的数据total为0）
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }
}

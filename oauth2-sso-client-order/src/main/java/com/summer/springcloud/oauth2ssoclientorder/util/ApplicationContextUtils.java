package com.summer.springcloud.oauth2ssoclientorder.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ChengJianSheng
 * @date 2019-02-17
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 服务启动就会先走这里
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}

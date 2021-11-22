package com.summer.springcloud.springcloudweb.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author Summer_DM
 * @Summary TODO  kafka消息
 * @Version 1.0
 * @Date 2021/11/22 下午 02:48
 **/
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}

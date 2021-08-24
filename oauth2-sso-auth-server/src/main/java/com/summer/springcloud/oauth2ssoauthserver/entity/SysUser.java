package com.summer.springcloud.oauth2ssoauthserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Summer_DM
 * @Summary TODO  数据库的一个用户表
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Data
@Entity
@Table(schema = "permission", name = "sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 5872438942257394882L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Integer status = 0;

    @Column(name = "create_user")
    private String createUser;


    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;
}

package com.summer.springcloud.oauth2ssoauthserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Summer_DM
 * @Summary TODO  数据库的一个角色表
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Data
@Entity
@Table(schema = "permission", name = "sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = -7136537864183138269L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_description")
    private String roleDescription;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;
}

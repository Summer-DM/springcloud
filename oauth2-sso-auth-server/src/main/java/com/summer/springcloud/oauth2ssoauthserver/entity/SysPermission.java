package com.summer.springcloud.oauth2ssoauthserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * @Author Summer_DM
 * @Summary TODO  数据库的一个权限表
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Data
@Entity
@Table(schema = "permission", name = "sys_permission")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 4285835478693487481L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "type")
    private Integer type;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "uri")
    private String uri;

    @Column(name = "seq")
    private Integer seq = 1;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;

}

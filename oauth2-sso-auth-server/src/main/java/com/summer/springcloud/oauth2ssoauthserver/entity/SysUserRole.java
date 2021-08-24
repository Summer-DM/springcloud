package com.summer.springcloud.oauth2ssoauthserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Data
@Entity
@Table(schema = "permission", name = "sys_user_role")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -1810195806444298544L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;
}

package com.summer.springcloud.oauth2ssoauthserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Summer_DM
 * @Summary TODO  数据库的一个角色权限表
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Data
@Entity
@Table(schema = "permission", name = "sys_role_permission")
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 7402412601579098788L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;
}

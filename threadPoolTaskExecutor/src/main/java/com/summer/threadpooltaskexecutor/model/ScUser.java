package com.summer.threadpooltaskexecutor.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 对应数据库表SC_USER
 * </p>
 *
 * @author Summer_DM
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户出生年月
     */
    private Date birthday;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户年龄
     */
    private String age;

    /**
     * 用户家庭住址
     */
    private String address;


    @TableField(fill = FieldFill.INSERT)
    private Date  createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date  updateTime;

}

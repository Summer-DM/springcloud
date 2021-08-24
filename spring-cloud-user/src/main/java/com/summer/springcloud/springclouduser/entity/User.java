package com.summer.springcloud.springclouduser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Summer_DM
 * @Summary TODO  用户登录实体
 * @Version 1.0
 * @Date 2021/8/19 下午 04:50
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     * 在我们网表中插入数据的时候，我们本身没有收到设置id的生成策略，但是我们插入没有id的数据时，发现最后数据库表中还是生成了id，说明mybatis-plus帮我们做了这一点，他的生成策略是雪花算法
     *  IdType {
     *     AUTO(0),//自增，注意如果这里设置了自增，数据库也一定要设置，否则会报错
     *     NONE(1),//未设置主键
     *     INPUT(2),//手动输入
     *     ID_WORKER(3),//默认的全局唯一id
     *     UUID(4),//全局唯一id，uuid
     *     ID_WORKER_STR(5);//ID_WORKER的字符串表示法
     */
    //@TableId(type = IdType.AUTO)(如果我们想要自定义id生成策略的话，可以在实体类中添加注解)
    private String id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

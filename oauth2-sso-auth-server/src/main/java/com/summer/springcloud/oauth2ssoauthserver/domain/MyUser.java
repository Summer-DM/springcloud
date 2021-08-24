package com.summer.springcloud.oauth2ssoauthserver.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author Summer_DM
 * @Summary TODO  大部分时候直接用User即可不必扩展
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class MyUser extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer departmentId;   //  举个例子，部门ID

    private String mobile;  //  举个例子，假设我们想增加一个字段，这里我们增加一个mobile表示手机号

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}

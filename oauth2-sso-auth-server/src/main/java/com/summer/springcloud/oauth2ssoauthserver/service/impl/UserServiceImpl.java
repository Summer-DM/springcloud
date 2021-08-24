package com.summer.springcloud.oauth2ssoauthserver.service.impl;

import com.summer.springcloud.oauth2ssoauthserver.entity.SysUser;
import com.summer.springcloud.oauth2ssoauthserver.repository.SysUserRepository;
import com.summer.springcloud.oauth2ssoauthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * 登录认证入口
     * @param username
     * @return
     */
    @Override
    public SysUser getByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}

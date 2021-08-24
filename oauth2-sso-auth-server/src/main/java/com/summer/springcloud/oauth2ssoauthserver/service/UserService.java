package com.summer.springcloud.oauth2ssoauthserver.service;

import com.summer.springcloud.oauth2ssoauthserver.entity.SysUser;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
public interface UserService {

    SysUser getByUsername(String username);
}

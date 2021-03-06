package com.summer.springcloud.oauth2ssoauthserver.service;

import com.summer.springcloud.oauth2ssoauthserver.entity.SysPermission;

import java.util.List;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

}

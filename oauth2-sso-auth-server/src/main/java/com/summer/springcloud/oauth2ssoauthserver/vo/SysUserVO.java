package com.summer.springcloud.oauth2ssoauthserver.vo;

import com.summer.springcloud.oauth2ssoauthserver.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Data
public class SysUserVO extends SysUser {

    /**
     * 权限列表
     */
    private List<String> authorityList;

}

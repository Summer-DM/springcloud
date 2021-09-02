package com.summer.springcloud.oauth2ssoauthserver.service.impl;

import com.summer.springcloud.oauth2ssoauthserver.entity.SysPermission;
import com.summer.springcloud.oauth2ssoauthserver.entity.SysRolePermission;
import com.summer.springcloud.oauth2ssoauthserver.entity.SysUserRole;
import com.summer.springcloud.oauth2ssoauthserver.repository.SysPermissionRepository;
import com.summer.springcloud.oauth2ssoauthserver.repository.SysRolePermissionRepository;
import com.summer.springcloud.oauth2ssoauthserver.repository.SysUserRoleRepository;
import com.summer.springcloud.oauth2ssoauthserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    /**
     * 偷懒少写两个Service
     */
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;
    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        //通过userId从Sys_User_Role表中获取相同userId的所有用户角色
        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        //排序
        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        //通过上面获取的同一个userId的所有用户角色，从Sys_Role_Permission表中获取所有role_id落在roleIdList中的角色权限
        List<SysRolePermission> rolePermissionList = sysRolePermissionRepository.findByRoleIds(roleIdList);
        if (CollectionUtils.isEmpty(rolePermissionList)) {
            return null;
        }
        //排序
        List<Integer> permissionIdList = rolePermissionList.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        //通过上面获取的所有角色id，从Sys_Permission表中获取id落在permissionIdList中的所有数据，给上一层使用
        List<SysPermission> sysPermissionList = sysPermissionRepository.findByIds(permissionIdList);
        if (CollectionUtils.isEmpty(sysPermissionList)) {
            return null;
        }
        return sysPermissionList;
    }
}

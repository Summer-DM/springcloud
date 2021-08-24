package com.summer.springcloud.springclouduser.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.springcloud.springclouduser.entity.ScUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Summer_DM
 * @since 2021-08-16
 */
public interface ScUserService extends IService<ScUser>{

    Boolean insert(ScUser user);

    //ScUser selectOne(QueryWrapper wrapper);

    //List selectPage(Page pages, QueryWrapper<ScUser> w);
}

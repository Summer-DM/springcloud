package com.summer.com.summer.springcloud.service.serviceImpl;

import com.summer.com.summer.springcloud.entity.ScUser;
import com.summer.com.summer.springcloud.mapper.ScUserMapper;
import com.summer.com.summer.springcloud.service.ScUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Summer_DM
 * @since 2021-08-16
 */
@Service
public class ScUserServiceImpl extends ServiceImpl<ScUserMapper, ScUser> implements ScUserService {

}

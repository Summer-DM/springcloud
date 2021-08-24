package com.summer.springcloud.springclouduser.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.springcloud.springclouduser.entity.ScUser;
import com.summer.springcloud.springclouduser.mapper.ScUserMapper;
import com.summer.springcloud.springclouduser.service.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Summer_DM
 * @since 2021-08-16
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ScUserServiceImpl extends ServiceImpl<ScUserMapper, ScUser> implements ScUserService {

    @Autowired
    private ScUserMapper userMapper;


    @Override
    public Boolean insert(ScUser user) {
        Boolean flag = false;
        int insert = userMapper.insert(user);
        if (insert==1){
            flag=true;
        }
        return flag;
    }

    //@Override
    //public ScUser selectOne(QueryWrapper wrapper) {
    //    ScUser scUser = userMapper.selectOne(wrapper);
    //    return scUser;
    //}

    //@Override
    //public List selectPage(Page pages, QueryWrapper<ScUser> w) {
    //    List list = new ArrayList();
    //    Page page = userMapper.selectPage(pages, w);
    //    list.add(page);
    //    return list;
    //}


}

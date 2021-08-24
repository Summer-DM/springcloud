package com.summer.springcloud.springclouduser.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.summer.springcloud.springclouduser.entity.ScUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Summer_DM
 * @since 2021-08-16
 */
@Mapper
public interface ScUserMapper extends BaseMapper<ScUser> {
    //@Override
    //ScUser selectOne(Wrapper<ScUser> queryWrapper);

    @Override
    int insert(ScUser user);



    //@Override
    //<P extends IPage<ScUser>> P selectPage(P page, Wrapper<ScUser> queryWrapper);
}

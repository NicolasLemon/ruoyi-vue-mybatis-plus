package com.lemon.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lemon.demo.domain.DiyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.annotation.MapperEnhancement;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 自定义Demo用户表 Mapper 接口
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/16
 */
@Mapper
public interface DiyUserMapper extends BaseMapper<DiyUser> {
    /**
     * 查询所有用户
     */
    @Override
    // @Result中：select 要对应到需要映射的那个Mapper上具体的某一个方法
    @Results({
            @Result(column = "user_area_id", property = "userArea",
                    one = @One(select = "com.lemon.demo.mapper.DiyUserAreaMapper.selectById"))
    })
    @MapperEnhancement
    // 用了 @Results 映射后得自己重写一遍最基本的sql，不然会报错
    @Select("select * from diy_user;")
    List<DiyUser> selectList(Wrapper<DiyUser> queryWrapper);

    /**
     * 通过用户id查询用户
     */
    @Override
    @Results({
            @Result(column = "user_area_id", property = "userArea",
                    one = @One(select = "com.lemon.demo.mapper.DiyUserAreaMapper.selectById"))
    })
    @MapperEnhancement
    @Select("select * from diy_user where user_id=#{id};")
    DiyUser selectById(Serializable id);
}

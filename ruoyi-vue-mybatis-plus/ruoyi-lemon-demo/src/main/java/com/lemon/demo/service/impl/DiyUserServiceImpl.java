package com.lemon.demo.service.impl;

import com.lemon.demo.domain.DiyUser;
import com.lemon.demo.mapper.DiyUserMapper;
import com.lemon.demo.service.DiyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义Demo用户表 服务实现类
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/16
 */
@Service
public class DiyUserServiceImpl extends ServiceImpl<DiyUserMapper, DiyUser> implements DiyUserService {

}

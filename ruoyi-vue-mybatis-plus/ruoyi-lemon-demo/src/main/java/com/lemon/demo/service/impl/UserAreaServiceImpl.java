package com.lemon.demo.service.impl;

import com.lemon.demo.domain.UserArea;
import com.lemon.demo.mapper.UserAreaMapper;
import com.lemon.demo.service.UserAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义Demo用户区域表 服务实现类
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/16
 */
@Service
public class UserAreaServiceImpl extends ServiceImpl<UserAreaMapper, UserArea> implements UserAreaService {

}

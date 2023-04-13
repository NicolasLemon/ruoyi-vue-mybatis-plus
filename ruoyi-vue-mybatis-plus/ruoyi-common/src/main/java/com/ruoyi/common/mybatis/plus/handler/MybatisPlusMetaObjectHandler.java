package com.ruoyi.common.mybatis.plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ruoyi.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatis-Plus 自动填充字段 处理器
 *
 * @author Nicolas·Lemon
 * @since 2022/05/13
 */
@Slf4j
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        /// 插入一条记录时的自动填充
        log.info("start insert fill ....");
        String thisLoginUsername = SecurityUtils.getUsername();
        // 创建者
        this.setFieldValByName("createBy", thisLoginUsername, metaObject);
        // 创建时间 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        // 更新者
        this.setFieldValByName("updateBy", thisLoginUsername, metaObject);
        // 更新时间 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新一条记录时的自动填充
        log.info("start update fill ....");
        String thisLoginUsername = SecurityUtils.getUsername();
        // 更新者
        this.setFieldValByName("updateBy", thisLoginUsername, metaObject);
        // 更新时间 起始版本 3.3.3(推荐)
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}
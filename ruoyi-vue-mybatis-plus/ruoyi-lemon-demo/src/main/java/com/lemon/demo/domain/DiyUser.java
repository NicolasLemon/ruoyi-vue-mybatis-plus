package com.lemon.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 自定义Demo用户表
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("diy_user")
public class DiyUser extends BaseEntity {

    /**
     * 用户ID（主键）
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户区域表外键
     */
    private Long userAreaId;

    /**
     * 用户区域实体
     */
    @TableField(exist = false)
    private DiyUserArea userArea;

}

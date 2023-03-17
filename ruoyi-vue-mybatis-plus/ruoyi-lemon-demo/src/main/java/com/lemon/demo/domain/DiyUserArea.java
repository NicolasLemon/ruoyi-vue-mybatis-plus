package com.lemon.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 自定义Demo用户区域表
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("diy_user_area")
public class DiyUserArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域ID（主键）
     */
    @TableId(value = "area_id", type = IdType.AUTO)
    private Long areaId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 区域简介（数据库中没该字段），aop增强处理用
     */
    @TableField(exist = false)
    private String areaIntroduction;

}

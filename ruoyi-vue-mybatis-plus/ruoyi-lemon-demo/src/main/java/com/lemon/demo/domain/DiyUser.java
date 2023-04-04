package com.lemon.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    /*
        *********************
         以下是演示生成pdf所需
        *********************
     */

    /**
     * 用户爱好
     */
    @TableField(exist = false)
    private String hobby;

    /**
     * 用户性别
     */
    @TableField(exist = false)
    private String sex;

    /**
     * 用户年龄
     */
    @TableField(exist = false)
    private Integer age;

    public DiyUser(String userName, DiyUserArea userArea, String hobby, String sex, Integer age) {
        this.userName = userName;
        this.userArea = userArea;
        this.hobby = hobby;
        this.sex = sex;
        this.age = age;
    }
}

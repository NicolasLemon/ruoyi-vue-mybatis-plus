package com.lemon.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/15
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("diy_demo_user")
public class DiyDemoUser extends BaseEntity {

    private Integer id;


}

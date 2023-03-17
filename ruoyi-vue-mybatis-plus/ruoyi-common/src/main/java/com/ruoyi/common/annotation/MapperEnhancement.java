package com.ruoyi.common.annotation;

import java.lang.annotation.*;

/**
 * Mapper增强注解
 * 只当切入点
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/3/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapperEnhancement {
}

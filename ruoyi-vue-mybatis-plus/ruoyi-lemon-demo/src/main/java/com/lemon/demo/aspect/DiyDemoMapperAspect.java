package com.lemon.demo.aspect;

import com.lemon.demo.domain.DiyUserArea;
import com.lemon.demo.enums.DiyUserAreaEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * AOP切面增强
 * 对自定义Demo中Mapper的查询结果做增强处理
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/3/16
 */
@Aspect
@Component
@Slf4j
@SuppressWarnings("rawtypes")
public class DiyDemoMapperAspect {

    /**
     * 切点：在Mapper方法上使用注解 @MapperEnhancement
     */
    @Pointcut("@annotation(com.ruoyi.common.annotation.MapperEnhancement)")
    public void mapperPointcut() {
    }

    /**
     * DiyUserMapper环绕增强
     * 双重条件锁定：
     * 1、在Mapper方法上使用@MapperEnhancement注解
     * 2、注解只有在DiyUserMapper中才切入此方法
     */
    @Around("mapperPointcut() && execution(* com.lemon.demo.mapper.DiyUserMapper.*(..))")
    public Object aroundDiyUserMapper(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取切入的方法名称
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method signatureMethod = signature.getMethod();
        log.info("开启 " + signatureMethod + " 方法环绕型增强");
        // 下一步是正常处理，获取返回的结果
        Object result = joinPoint.proceed();
        // 判断结果是List集合还是Object对象
        if (result instanceof List) {
            // 增强用户区域实体对象，赋值区域简介
            for (Object object : (List) result) {
                makeDiyUserAreaIntroduction(object);
            }
            return result;
        }
        // 增强用户区域实体对象，赋值区域简介
        makeDiyUserAreaIntroduction(result);
        return result;
    }

    /**
     * 增强用户区域实体对象，赋值区域简介
     * 因为是通过反射机制来处理的，所以并不需要将处理后的结果再返回
     *
     * @param object Object对象
     * @throws NoSuchFieldException   没有该字段异常
     * @throws IllegalAccessException 非法权限异常
     */
    private void makeDiyUserAreaIntroduction(Object object) throws NoSuchFieldException, IllegalAccessException {
        // 获取所需要的字段
        Field field = object.getClass().getDeclaredField("userArea");
        // 设置字段权限，不然无法读取private属性的字段的值
        field.setAccessible(true);
        // 将字段转换成需要的实体对象
        DiyUserArea userArea = (DiyUserArea) field.get(object);
        // 循环区域枚举类，赋值对用的区域简介
        DiyUserAreaEnum[] values = DiyUserAreaEnum.values();
        for (DiyUserAreaEnum value : values) {
            if (!value.getAreaName().equals(userArea.getAreaName())) {
                continue;
            }
            // 赋予匹配的的区域简介
            userArea.setAreaIntroduction(value.getAreaIntroduction());
            break;
        }
    }
}

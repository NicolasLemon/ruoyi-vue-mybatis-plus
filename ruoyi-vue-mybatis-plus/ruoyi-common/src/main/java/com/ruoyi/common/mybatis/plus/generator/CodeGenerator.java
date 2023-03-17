package com.ruoyi.common.mybatis.plus.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MyBatis-Plus 代码生成器
 *
 * @author Nicolas·Lemon
 * @since 2022/05/09
 */
public class CodeGenerator {

    public static void main(String[] args) {
        /// 设置生成文件的输出目录
        final String parentPath = "D:";
        // java文件输出目录
        final String javaOutputDir = parentPath + "\\MybatisPlusCodeGenerator\\java";
        // mapperXml文件输出目录
        final String xmlOutputDir = parentPath + "\\MybatisPlusCodeGenerator\\resources\\mapper";

        // 需要逆向生成的数据库的表名
        final String[] includeTables = {
                "diy_user"
        };

        // 自动填充充字段
        List<IFill> tableFills = new ArrayList<>();
        // 创建者
        tableFills.add(new Column("create_by", FieldFill.INSERT));
        // 创建时间
        tableFills.add(new Column("create_time", FieldFill.INSERT));
        // 更新者
        tableFills.add(new Column("update_by", FieldFill.INSERT_UPDATE));
        // 更新时间
        tableFills.add(new Column("update_time", FieldFill.INSERT_UPDATE));

        // 快速生成模板
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ry_vue?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8"
                        , "root", "root")
                // 全局配置
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("Nicolas·Lemon")
                            // 注释日期
                            .commentDate("yyyy/MM/dd")
                            /// 开启 swagger 模式
                            // .enableSwagger()
                            // 指定输出目录
                            .outputDir(javaOutputDir)
                            // 覆盖已有文件
                            .fileOverride()
                            // 禁止打开输出目录
                            .disableOpenDir();
                })
                // 包配置
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.lemon")
                            /// 设置父包模块名
                            .moduleName("demo")
                            // 指定实体包名
                            .entity("domain")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, xmlOutputDir));
                })
                // 策略配置
                .strategyConfig(builder -> {
                    // 设置需要生成的表名（包含）
                    builder.addInclude(includeTables)
                            // 设置过滤表前缀
                            .addTablePrefix("t_", "c_")
                            // Controller策略配置
                            .controllerBuilder()
                            // 开启生成@RestController控制器
                            .enableRestStyle()
                            // Entity策略配置
                            .entityBuilder()
                            // 开启链式模型
                            .enableChainModel()
                            // 禁用生成 serialVersionUID
                            .disableSerialVersionUID()
                            // 设置父类
                            .superClass(BaseEntity.class)
                            // 添加父类公共字段
                            .addSuperEntityColumns("create_by", "create_time", "update_by", "update_time", "remark")
                            // 开启 lombok 模型
                            .enableLombok()
                            // 表字段填充
                            .addTableFills(tableFills)
                            // 逻辑删除字段名(数据库)
                            .logicDeleteColumnName("del_flag")
                            // 逻辑删除属性名(实体)
                            .logicDeletePropertyName("delFlag")
                            // Service策略配置
                            .serviceBuilder()
                            // 去掉Service的I前缀
                            .formatServiceFileName("%sService")
                            // Mapper策略配置
                            .mapperBuilder()
                            // 开启 @Mapper 注解
                            .enableMapperAnnotation()
                            // 开启通用查询映射结果
                            .enableBaseResultMap()
                            // 开启通用查询结果列
                            .enableBaseColumnList();

                })
                // 使用Velocity引擎模板
                .templateEngine(new VelocityTemplateEngine())
                // 执行配置
                .execute();

    }
}

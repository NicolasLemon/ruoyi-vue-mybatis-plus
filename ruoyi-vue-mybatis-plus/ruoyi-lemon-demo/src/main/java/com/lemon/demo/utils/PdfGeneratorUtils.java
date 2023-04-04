package com.lemon.demo.utils;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import com.lemon.demo.domain.DiyUser;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * PDF生成工具类
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/4/4
 */
@Slf4j
public class PdfGeneratorUtils {
    // 定义表格表头数组
    private static final String[] TITLES = {"地区", "爱好", "姓名", "性别", "年龄"};
    // 定义表格列宽数组
    private static final float[] WIDTHS = {2f, 2f, 2f, 1f, 1f};

    /**
     * 生成用户表中的表格PDF
     * 表格一共有五列，其中
     * 1、表格第一列是区域名称；
     * 2、表格第二列是用户爱好；
     * 3、表格第三列是用户名称；
     * 4、表格第四列是用户性别
     * 5、表格第五列是用户年龄
     * 表格需求：
     * 1、表格第一列中分区域统计；
     * 2、表格第二列中合并相同区域中的相同爱好。
     *
     * @param userList 用户列表
     * @param pdfPath  生成pdf的地址
     */
    public static void generateUserPdf(List<DiyUser> userList, String pdfPath) throws IOException {
        // 先排序用户区域，再在用户区域排序的基础上排序爱好
        userList.sort(Comparator.comparing(user -> ((DiyUser) user).getUserArea().getAreaId())
                .thenComparing(user -> ((DiyUser) user).getHobby()));

        // 创建一个PdfWriter对象，用于写入PDF文件
        PdfWriter writer = new PdfWriter(pdfPath);
        // 创建一个PdfDocument对象，用于操作PDF文件
        PdfDocument pdf = new PdfDocument(writer);
        // 创建一个Document对象，用于添加内容到PDF文件
        Document document = new Document(pdf);

        // 创建一个Table对象，用于创建表格
        Table table = new Table(UnitValue.createPercentArray(WIDTHS))
                // 设置表格宽度为100%
                .useAllAvailableWidth();

        // 创建一个PdfFont对象，用于设置中文字体
        PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
        // 添加描述文字
        Text text = new Text("用户爱好统计表").setFont(font);
        document.add(new Paragraph(text).setTextAlignment(TextAlignment.CENTER));

        // 添加表格表头，设置表头相应样式
        for (String title : TITLES) {
            table.addHeaderCell(new Cell().add(new Paragraph(title))
                            .setFont(font)
                            .setFontColor(new DeviceRgb(144, 147, 153))
                            .setBackgroundColor(new DeviceRgb(243, 255, 255))
                            .setTextAlignment(TextAlignment.CENTER))
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
        }

        // 分 用户区域 填写表格内容
        for (int i = 0; i < userList.size(); i++) {
            // 子用户列表：该List中，只包含相同区域的子用户
            List<DiyUser> subUserList = new ArrayList<>();
            // 获取当前用户
            DiyUser user = userList.get(i);
            // 从当前区域的用户循环到下一个区域的用户
            for (int j = i; j < userList.size(); j++) {
                // 获取当前子用户
                DiyUser subUser = userList.get(j);
                // 当子用户的区域与当前主用户的区域不一致时，跳出循环
                if (!subUser.getUserArea().getAreaId().equals(user.getUserArea().getAreaId())) {
                    break;
                }
                // 将子用户添加到子用户列表中
                subUserList.add(subUser);
            }
            // 生成同一区域的子用户的表格内容
            createTableCellByUserArea(subUserList, table, font);
            // 将索引更新到下一个区域的用户的索引（注意：上述for循环中，循环结束后是i++，因此当前得要-1）
            i = i + subUserList.size() - 1;
        }

        // 将表格添加到文档中
        document.add(table);
        // 关闭Document和PdfWriter对象
        document.close();
        writer.close();

        log.info("PDF文件生成成功，请在 {} 中查看！", pdfPath);
    }

    /**
     * 分 用户区域 添加表格单元格（含动态合并相同爱好的单元格）
     *
     * @param userList 同一区域的子用户列表
     * @param table    表格对象
     * @param font     字体
     */
    private static void createTableCellByUserArea(List<DiyUser> userList, Table table, PdfFont font) {
        for (int i = 0; i < userList.size(); i++) {
            // 获取当前用户
            DiyUser user = userList.get(i);
            // 获取上一个用户
            DiyUser prevUser = i > 0 ? userList.get(i - 1) : null;

            // 合并添加 用户区域 单元格
            if (ObjectUtils.isEmpty(prevUser)) {
                // 因为传进来的userList都是同一区域的子用户，所以userList.size()就是要合并的区域数，故只需要在处理第一个用户时合并单元格就行
                table.addCell(new Cell(userList.size(), 1)
                        .add(new Paragraph(user.getUserArea().getAreaName()))
                        .setFont(font)
                        .setFontColor(new DeviceRgb(96, 98, 102))
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE));
            }

            // 合并添加 用户爱好 单元格
            if (ObjectUtils.isEmpty(prevUser) || !user.getHobby().equals(prevUser.getHobby())) {
                /// 如果是第一个用户或者与上一个用户的爱好不同
                // 计算要合并的行数
                int rowspan = 1;
                for (int j = i + 1; j < userList.size(); j++) {
                    // 如果与后面的用户的爱好不相同，就跳出循环
                    if (!user.getHobby().equals(userList.get(j).getHobby())) {
                        break;
                    }
                    rowspan++;
                }
                // 添加合并后的单元格
                table.addCell(new Cell(rowspan, 1)
                        .add(new Paragraph(user.getHobby()))
                        .setFont(font)
                        .setFontColor(new DeviceRgb(96, 98, 102))
                        .setTextAlignment(TextAlignment.CENTER)
                        .setVerticalAlignment(VerticalAlignment.MIDDLE));
            }

            // 添加 用户姓名 单元格
            table.addCell(new Cell()
                            .add(new Paragraph(user.getUserName()))
                            .setFont(font)
                            .setFontColor(new DeviceRgb(96, 98, 102))
                            .setTextAlignment(TextAlignment.CENTER))
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);

            // 添加 用户性别 单元格
            table.addCell(new Cell()
                            .add(new Paragraph(user.getSex()))
                            .setFont(font)
                            .setFontColor(new DeviceRgb(96, 98, 102))
                            .setTextAlignment(TextAlignment.CENTER))
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);

            // 添加 用户年龄 单元格
            table.addCell(new Cell()
                            .add(new Paragraph(String.valueOf(user.getAge())))
                            .setFont(font)
                            .setFontColor(new DeviceRgb(96, 98, 102))
                            .setTextAlignment(TextAlignment.CENTER))
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
        }
    }

}

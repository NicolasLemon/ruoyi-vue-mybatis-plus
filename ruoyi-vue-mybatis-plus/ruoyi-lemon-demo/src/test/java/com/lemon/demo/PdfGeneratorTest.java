package com.lemon.demo;

import com.lemon.demo.domain.DiyUser;
import com.lemon.demo.domain.DiyUserArea;
import com.lemon.demo.utils.PdfGeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * PDF生成测试类
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/4/4
 */
@Slf4j
public class PdfGeneratorTest {

    @Test
    public void myTest() {
        try {
            // 调用工具类，生成PDF
            PdfGeneratorUtils.generateUserPdf(getDiyUserList(), "D:\\DiyUserHobbies.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟获取自定义用户列表
     *
     * @return DiyUser用户列表集合
     */
    public List<DiyUser> getDiyUserList() {
        List<DiyUser> userList = new ArrayList<>();
        userList.add(new DiyUser("柠檬", new DiyUserArea(1L, "湖北"), "跑步", "男", 27));
        userList.add(new DiyUser("赵六", new DiyUserArea(1L, "湖北"), "篮球", "男", 35));
        userList.add(new DiyUser("张三", new DiyUserArea(2L, "湖南"), "跑步", "男", 21));
        userList.add(new DiyUser("郑十", new DiyUserArea(1L, "湖北"), "电影", "男", 22));
        userList.add(new DiyUser("李四", new DiyUserArea(1L, "湖北"), "跑步", "女", 23));
        userList.add(new DiyUser("陈二", new DiyUserArea(2L, "湖南"), "跑步", "女", 18));
        userList.add(new DiyUser("王五", new DiyUserArea(1L, "湖北"), "篮球", "男", 26));
        userList.add(new DiyUser("刘一", new DiyUserArea(2L, "湖南"), "动漫", "男", 30));
        userList.add(new DiyUser("周八", new DiyUserArea(1L, "湖北"), "电影", "男", 19));
        userList.add(new DiyUser("孙七", new DiyUserArea(1L, "湖北"), "跑步", "男", 28));
        userList.add(new DiyUser("吴九", new DiyUserArea(1L, "湖北"), "跑步", "男", 25));
        return userList;
    }
}

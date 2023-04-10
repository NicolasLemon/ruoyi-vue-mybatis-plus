package com.lemon.demo;

import com.lemon.demo.domain.User;
import com.lemon.demo.domain.UserArea;
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
    public List<User> getDiyUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("柠檬", new UserArea(1L, "湖北"), "跑步", "男", 27));
        userList.add(new User("赵六", new UserArea(1L, "湖北"), "篮球", "男", 35));
        userList.add(new User("张三", new UserArea(2L, "湖南"), "跑步", "男", 21));
        userList.add(new User("郑十", new UserArea(1L, "湖北"), "电影", "男", 22));
        userList.add(new User("李四", new UserArea(1L, "湖北"), "跑步", "女", 23));
        userList.add(new User("陈二", new UserArea(2L, "湖南"), "跑步", "女", 18));
        userList.add(new User("王五", new UserArea(1L, "湖北"), "篮球", "男", 26));
        userList.add(new User("刘一", new UserArea(2L, "湖南"), "动漫", "男", 30));
        userList.add(new User("周八", new UserArea(1L, "湖北"), "电影", "男", 19));
        userList.add(new User("孙七", new UserArea(1L, "湖北"), "跑步", "男", 28));
        userList.add(new User("吴九", new UserArea(1L, "湖北"), "跑步", "男", 25));
        return userList;
    }
}

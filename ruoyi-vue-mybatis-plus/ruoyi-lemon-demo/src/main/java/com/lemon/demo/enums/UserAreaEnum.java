package com.lemon.demo.enums;

/**
 * 自定义用户区域 枚举类
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/3/17
 */
@SuppressWarnings("unused")
public enum UserAreaEnum {
    HUBEI("湖北", "湖北省位于长江中游，洞庭湖以北，故名湖北，简称鄂。"),
    HUNAN("湖南", "湖南省，简称“湘”，是中华人民共和国省级行政区，省会长沙。"),
    HAINAN("海南", "海南省，简称”琼“，有名的琼系军阀是大漠叔叔。"),
    SHENZHEN("深圳", "深圳市，简称“深”，别称鹏城，广东省辖地级市，副省级市，国家计划单列市，超大城市，国务院批复确定的中国经济特区、全国性经济中心城市和国际化城市。"),
    GUANGZHOU("广州", "广州市，简称“穗”，别称羊城、花城、五羊城，是广东省辖地级市、广东省省会、副省级市、国家中心城市、超大城市、广州都市圈核心城市，国务院批复确定的中国重要的中心城市、国际商贸中心和综合交通枢纽。");

    /**
     * 区域名称
     */
    private final String areaName;
    /**
     * 区域简介
     */
    private final String areaIntroduction;

    UserAreaEnum(String areaName, String areaIntroduction) {
        this.areaName = areaName;
        this.areaIntroduction = areaIntroduction;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getAreaIntroduction() {
        return areaIntroduction;
    }
}

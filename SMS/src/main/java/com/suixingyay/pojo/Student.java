package com.suixingyay.pojo;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 班级
     */
    private String studentClass;
    /**
     * 老师
     */
    private String teacher;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 入学年份
     */
    private String year;
    /**
     * 状态
     */
    private String state;

}

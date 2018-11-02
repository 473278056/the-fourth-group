package com.suixingpay.client;

import com.suixingpay.pojo.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextClient implements PrivateClient{
    @Override
    public Student getStudentById(Integer id) {
        log.error("不存在ID为："+id+"的学生");
        return null;
    }
}

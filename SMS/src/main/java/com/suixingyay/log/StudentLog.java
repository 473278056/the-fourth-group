package com.suixingyay.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class StudentLog {

    /**
     * 开启查询的日志记录
     */
    @Pointcut("execution(* com.suixingyay.mapper.StudentMapper.query*(..))")
    public void queryAS() {}

    @Before("queryAS()")
    public void beforeQueryAS() {
        log.info("开始:准备查询学生------------------------","begin");
    }

    @After("queryAS()")
    public void afterQueryAS(){
        log.info("结束:学生查询完毕------------------------","end");
    }

    @AfterThrowing("queryAS()")
    public void afterThrowQueryAS(){
        log.info("异常:查询失败---------------------------","failure");
    }


    /**
     * 开启更新日志的记录
     */
    @Pointcut("execution(* com.suixingyay.mapper.StudentMapper.update*(..))")
    public void updateS() {}

    @Before("updateS()")
    public void beforeUpdateS() {
        log.info("开始:准备更新学生--------------------","begin");
    }

    @After("updateS()")
    public void afterUpdateS(){
        log.info("结束:学生更新完毕--------------------","end");
    }

    @AfterThrowing("updateS()")
    public void afterThrowUpdateS(){
        log.info("异常:更新失败--------------------","failure");
    }

    /**
     * 开启删除日志的记录
     */
    @Pointcut("execution(* com.suixingyay.mapper.StudentMapper.del*(..))")
    public void delS() {}

    @Before("delS()")
    public void beforeDelS() {
        log.info("开始:准备删除学生--------------------","");
    }

    @After("delS()")
    public void afterDelS(){
        log.info("结束:学生删除完毕----------------------","");
    }

    @AfterThrowing("delS()")
    public void afterThrowDelS(){
        log.info("异常:删除失败----------------------------","");
    }

}

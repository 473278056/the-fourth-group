package com.suixingpay.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixingpay.mapper.StudentMapper;
import com.suixingpay.pojo.Student;
import com.suixingpay.util.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询所有的student
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult queryAllStudent(Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<Student> studentList = this.studentMapper.queryAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 根据ID 查询学生信息
     * @param id
     * @return
     */
    public Student queryStudentByid(Integer id){
        return this.studentMapper.queryStudentByid(id);
    }

    /**
     * 根据ID 修改用户的姓名，年龄
     * @param student
     * @return
     */
    public boolean updateStudentById(Student student){
        return this.studentMapper.updateStudentById(student) == 1;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    public boolean delStudentById(Integer id){
        return this.studentMapper.delStudentById(id) == 1;
    }

    /**
     * 添加用户
     * @param student
     * @return
     */
    public boolean addStudent(Student student){
        student.setCreateDate(new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(new Date()));
        student.setState("01");
        studentMapper.insertStudent(student);
        return true;
    }
}

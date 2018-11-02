package com.suixingyay.mapper;

import com.suixingyay.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> queryAllStudent();

    Student queryStudentByid(@Param("id") Integer id);

    //List<Student> queryUserByName(@Param("name") String name);

    int updateStudentById(Student student);

    int delStudentById(@Param("id") Integer id);

    int insertStudent(Student student);
}

package com.suixingpay.controller;


import com.suixingpay.pojo.Student;
import com.suixingpay.service.StudentService;
import com.suixingpay.util.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页查询所有的student
     * @param page
     * @param rows
     * @return
     */
    @GetMapping
    public ResponseEntity<EasyUIResult> queryStudentList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "30") Integer rows) {
        try {
            return ResponseEntity.ok(this.studentService.queryAllStudent(page, rows));
        } catch (Exception e) {
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据用户的id进行查询
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public ResponseEntity<Student> queryStudentById(@PathVariable("id") Integer id){
        try {
            Student student = this.studentService.queryStudentByid(id);
            if (student == null){
                //找不到返回404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //成功返回200
            return ResponseEntity.ok().body(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //错误，返回500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据ID更新用户
     * @param student
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateStudnent(Student student){
        try {
            boolean result = this.studentService.updateStudentById(student);
            if (!result){
                //添加失败，响应
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            //添加成功，相应201
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //添加失败，相应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id){
        if (id.longValue() == 0){
            // 没有传递参数，响应状态码400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        boolean result = this.studentService.delStudentById(id);
        try {
            if (result){
                // 删除成功，响应204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //删除失败，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 添加用户
     * @param
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addStudent(Student student){
        try {
            this.studentService.addStudent(student);
            //成功返回200
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //错误，返回500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

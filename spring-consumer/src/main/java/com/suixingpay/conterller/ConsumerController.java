package com.suixingpay.conterller;

import com.suixingpay.client.PrivateClient;
import com.suixingpay.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private PrivateClient privateClient;

    @GetMapping(value = "{id}")
    public Student getStudentById(@PathVariable("id") Integer id){
        return privateClient.getStudentById(id);
    }
}

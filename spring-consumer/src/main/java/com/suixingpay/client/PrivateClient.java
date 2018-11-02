package com.suixingpay.client;

import com.suixingpay.pojo.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="cloud-SMS-provider",fallback = TextClient.class,configuration = FallbackConfiguration.class)
@RequestMapping("/student")
public interface PrivateClient {

    @GetMapping(value = "{id}")
    Student getStudentById(@PathVariable("id") Integer id);
}
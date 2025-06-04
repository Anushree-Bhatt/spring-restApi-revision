package com.practice.springboot.my_rest_api.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldResource {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello_message(){
        return "Hello everyone! Welcome To Spring-boot World!";
    }
}

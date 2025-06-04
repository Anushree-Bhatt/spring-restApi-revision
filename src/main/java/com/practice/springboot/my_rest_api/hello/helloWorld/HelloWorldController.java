package com.practice.springboot.my_rest_api.hello.helloWorld;

import com.practice.springboot.my_rest_api.hello.pojo.Hello;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
//    @ResponseBody
    public String hello_message(){
        return "Hello everyone! Welcome To Spring-boot World!";
    }

    @RequestMapping("/hello-world")
    public Hello hello_bean_message() {
        return new Hello("Hey! Welcome welcome welcome.... To my Spring-Boot World!!");
    }

    @RequestMapping("/hello/{name}/todos/{id}")
    public String play_with_path_param(@PathVariable  String name, @PathVariable Integer id){
        return "Hi "+name+"! Continue learning with course no:"+id;
    }



}

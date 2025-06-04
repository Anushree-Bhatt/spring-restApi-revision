package com.practice.springboot.my_rest_api.pojo;

public class Hello {
    private String message;

    public Hello(){

    }

    public Hello(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

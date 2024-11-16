package com.mywebapp.todo.web_app_todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspHelloController {
    @RequestMapping("hello-jsp")
    public String getHelloJsp(){
        return "sayHello";
    }
}

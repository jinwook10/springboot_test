package com.example.controller;

import com.example.handler.ForbiddenException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/internalerror")
    public void internalerror(){
        throw new RuntimeException("500 Internal Eroor !!");
    }

    @GetMapping("/forbidden")
    public void forbidden() {
        throw new ForbiddenException("403 에러다!! !!");
    }
}

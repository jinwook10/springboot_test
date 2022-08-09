package com.example.controller;

import com.example.handler.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/internalerror")
    public void internalerror(){
        throw new RuntimeException("500 Internal Eroor !!");
    }

    @GetMapping("/forbidden")
    public void forbidden() {
        throw new ForbiddenException("403 에러다!! !!");
    }
    @GetMapping("/null")
    public void nullpoint() {
        throw new NullPointerException("nullpoint");
    }

    @RequestMapping("/error")
    @ResponseBody
    public String error (HttpServletRequest request) {

        // 에러 코드를 획득한다.
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // 에러 코드에 대한 상태 정보
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));

        if (status != null) {
            // HttpStatus와 비교해 페이지 분기를 나누기 위한 변수
            int statusCode = Integer.valueOf(status.toString());

            // 로그로 상태값을 기록 및 출력
            System.out.println("httpStatus : " + statusCode);

        }
        return "error controller";
    }
}

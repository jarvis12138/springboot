package com.example.springboot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "报错");
        System.out.println("error 报错");
        return map;
    }
}

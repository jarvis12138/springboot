package com.example.springboot.common;

import org.springframework.beans.TypeMismatchException;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * BindException是对Get请求中使用@Validated或者@Valid验证的参数对象异常处理，MethodArgumentNotValidException是对Post请求中使用@Validated或者@Valid验证的参数对象异常处理，ConstraintViolationException是对Get和Post请求中使用validator内置的参数对象异常处理
     */
    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> exceptionHandler(BindException e) {
//        获取所有
        Map<String, Object> map = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

//        获取第一个
//        Map<String, Object> map = new HashMap<>();
//        FieldError fieldError = e.getBindingResult().getFieldError();
//
//        Field field = ReflectionUtils.findField(FieldError.class, "source");
//        field.setAccessible(true);
//        Object source = ReflectionUtils.getField(field, fieldError);
//        if (source instanceof TypeMismatchException) {
//            System.out.println("中文错误提示: TypeMismatchException");
//            TypeMismatchException typeMismatchException = (TypeMismatchException) source;
//            source = typeMismatchException.getPropertyChangeEvent().getSource();
//            if (typeMismatchException.getCause() instanceof NumberFormatException) {
//                System.out.println("中文错误提示: NumberFormatException");
//            }
//        }
//
//        map.put("error", fieldError.getDefaultMessage());

        return map;
    }

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "报错");
        System.out.println("error 报错");
        return map;
    }
}

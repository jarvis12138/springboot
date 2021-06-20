package com.example.springboot.interceptors;

import com.example.springboot.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // resource 静态资源不拦截
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        String token = request.getHeader("token");
        Map<String, Object> map = new HashMap<>();

        if (JWTUtils.verifyJWT(token)) {
            return true;
        } else {
            map.put("code", 400);
            map.put("msg", "未登录");
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
            return false;
        }
    }
}

package com.example.springboot.web;

import com.example.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class index {

    @PostMapping(value = "p/{id}")
    public @ResponseBody
    Object test(@PathVariable int id, @RequestParam String page, @RequestBody Map<String, Object> map) {
        User user = User.builder().name("zhangsan").age(22).build();
        System.out.println(user);
        return "id: " + id + ",page: " + page + ",name: " + map.get("name");
    }
}

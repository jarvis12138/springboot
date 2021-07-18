package com.example.springboot.controller;

import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") int id) {
        String sql = "select * from User where id=?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> userList() {
        String sql = "select * from User";
        List<User> maps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return maps;
    }

//    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
//    public List<Map<String, Object>> userList() {
//        String sql = "select * from User";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        return maps;
//    }

//    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
//    public void addUser() {
//        String sql = "insert into User (id, name ,age) values (2,'zhangsan', 10)";
//        jdbcTemplate.update(sql);
//    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addUser(@Validated({User.Update.class, Default.class}) User user) {
        return user.toString();
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public void updateUser(@PathVariable("id") Integer id) {
        String sql = "update User set name=?, age=?where id=" + id;
        Object[] objects = new Object[2];
        objects[0] = "lisi";
        objects[1] = 19;
        jdbcTemplate.update(sql, objects);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public void deleteUser(@PathVariable("id") Integer id) {
        String sql = "delete from User where id=?";
        jdbcTemplate.update(sql, id);
    }
}

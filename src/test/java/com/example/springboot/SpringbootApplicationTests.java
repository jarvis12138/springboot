package com.example.springboot;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springboot.mapper.ProductCategoryMapper;
import com.example.springboot.model.ProductCategory;
import com.example.springboot.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass()); // 查看一下默认数据源

        // 获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("cId", 5);
        map.put("name", "5");
        productCategoryMapper.insertByMap(map);
        System.out.println();
    }

    @Test
    void findByCategoryId() throws Exception {
        ProductCategory result = productCategoryMapper.findByCategoryId(3);
        System.out.println(result);
    }

    @Test
    void findByCategoryName() throws Exception {
        List<ProductCategory> result = productCategoryMapper.findByCategoryName("mazi");
        System.out.println(result);
    }

    @Test
    void updateByCategoryId() throws Exception {
        productCategoryMapper.updateByCategoryId("mazi", 4);
        System.out.println();
    }

    @Test
    void selectByCategoryId() throws Exception {
        ProductCategory productCategory = productCategoryMapper.selectByCategoryId(4);
        System.out.println(productCategory);
    }

    @Test
    void createJWT() throws Exception {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();

        builder.withClaim("name", "zhagnsna");
        builder.withClaim("id", "123");

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("SIGN"));

        System.out.println(token);
        DecodedJWT verify = JWT.require(Algorithm.HMAC256("SIGN")).build().verify(token);
        System.out.println(verify.getClaim("name").asString());
    }

}

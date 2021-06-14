package com.example.springboot.mapper;

import com.example.springboot.model.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ProductCategoryMapper {

    @Insert("insert into s_product_category (c_id, name) values (#{cId, jdbcType=INTEGER}, #{name, jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    @Select("select * from s_product_category where c_id=#{cId}")
    @Results({
            @Result(column = "c_id", property = "cId"),
            @Result(column = "name", property = "name")
    })
    ProductCategory findByCategoryId(Integer cId);

    @Select("select * from s_product_category where name=#{name}")
    @Results({
            @Result(column = "c_id", property = "cId"),
            @Result(column = "name", property = "name")
    })
    List<ProductCategory> findByCategoryName(String name);

    @Update("update s_product_category set name=#{name} where c_id=#{cId}")
    int updateByCategoryId(@Param("name") String name, @Param("cId") Integer cId);

    ProductCategory selectByCategoryId(Integer cId);

}

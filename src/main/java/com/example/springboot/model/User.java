package com.example.springboot.model;

import com.example.springboot.validator.MultipleOfThree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public interface Add {
    }

    public interface Update {
    }

    @NotNull(message = "id不能为空", groups = {Update.class})
    @Null(message = "id只能为空", groups = {Add.class})
    private String name;
    @Range(max = 200, min = 0, message = "年龄范围错误")
    @MultipleOfThree
    private int age;
}

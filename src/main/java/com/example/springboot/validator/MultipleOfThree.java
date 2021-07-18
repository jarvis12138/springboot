package com.example.springboot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {MultipleOfThreeForInteget.class}
)
public @interface MultipleOfThree {
    String message() default "必须是三的倍数";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

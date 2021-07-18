package com.example.springboot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipleOfThreeForInteget implements ConstraintValidator<MultipleOfThree, Integer> {
    @Override
    public void initialize(MultipleOfThree constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) return true;
        else return integer % 3 == 0;
    }
}

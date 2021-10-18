package com.zjt.springboot.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age,Integer> {
    private Age age;
    private Integer max;

    @Override
    public void initialize(Age age){
        this.age = age;
        this.max = age.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value < max;
    }
}

package com.zjt.springboot.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = {AgeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Age {
    String message() default "年龄是非法的，不能超过{max}岁";
    int max() default 100;
    Class<?>[] groups = new Class[0];
    Class<? extends Payload>[] payload() default {};
}

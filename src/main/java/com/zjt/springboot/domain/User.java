package com.zjt.springboot.domain;

import com.zjt.springboot.Validator.Age;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class User {

    public interface Update{}
    public interface Add{}


    // 这就是一个典型的group分组
    // 更新操作的时候，要求userId必须不为空
    // 新增操作的时候，要求userId必须为空
    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private Long id;
    @Age
    private String name;
    @Range(min=1, max=120)
    private Integer age;
}

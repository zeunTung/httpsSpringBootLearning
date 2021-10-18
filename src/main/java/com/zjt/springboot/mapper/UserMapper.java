package com.zjt.springboot.mapper;

import com.zjt.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> listUsers();
 
    @Select("SELECT * FROM user WHERE id = #{userId}")
    User getUserById(@Param("userId") Long userId);
 
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    void saveUser(User user);
 
    @Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")
    void updateUser(User user);
 
    @Delete("DELETE FROM user WHERE id=#{userId}")
    void removeUser(@Param("userId") Long userId);
}

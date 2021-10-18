package com.zjt.springboot.dao;

import com.zjt.springboot.domain.User;
import java.util.List;

public interface UserDao {
    List<User> listUsers();
 
    User getUserById(Long userId);

    void saveUser(User user);
 
    void updateUser(User user);
 
    void removeUser(Long userId);
}
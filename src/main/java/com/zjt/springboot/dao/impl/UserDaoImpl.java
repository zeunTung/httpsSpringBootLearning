package com.zjt.springboot.dao.impl;

import com.zjt.springboot.dao.UserDao;
import com.zjt.springboot.domain.User;
import com.zjt.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
   }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
   }
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
   }

   @Override
   public void updateUser(User user) {
        userMapper.updateUser(user);
   }

   @Override
   public void removeUser(Long userId) {
        userMapper.removeUser(userId);
   }
}

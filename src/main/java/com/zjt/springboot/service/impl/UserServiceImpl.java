package com.zjt.springboot.service.impl;

import com.zjt.springboot.dao.UserDao;
import com.zjt.springboot.domain.User;
import com.zjt.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author John
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUser(Long userId) {
        userDao.removeUser(userId);
    }
}



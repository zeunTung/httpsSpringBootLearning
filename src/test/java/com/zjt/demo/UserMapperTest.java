package com.zjt.demo;

import com.zjt.springboot.domain.User;
import com.zjt.springboot.mapper.UserMapper;
import com.zjt.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UserMapperTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    
    @Test
    // 这个@Sql注解，就会在我们执行测试之前，先执行sql语句，初始化数据
    @Sql({"employee.sql"})
    public void testSaveUser() {
//        User user = new User();
//        user.setName("李四");
//        user.setAge(30);
//
//        Long userId = userService.saveUser(user);
//        user.setId(userId);
//        assertTrue(userId > 0);
//
//        // 接着需要从数据库中查询数据来比较
//        User resultUser = userMapper.getUserById(1l);
//        assertEquals(user, resultUser);
    }
}

package com.zjt.demo;

import com.zjt.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith的意思，是不要使用默认方式进行单元测试，而是使用指定的类来提供单元测试
// 所有的spring测试都是找SpringRunner.class
//@RunWith(SpringRunner.class)
//// 这个是spring boot提供的，会一直找到一个Application类，只要包含了@SpringBootApplication的就算，然后会先启动这个类，来给单元测试提供环境
//@SpringBootTest
class DemoApplicationTests {

    // 这里就可以从启动的spring上下文中，将UserService注入到这里来，供我们进行测试
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

}

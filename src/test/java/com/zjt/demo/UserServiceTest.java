package com.zjt.demo;

import com.zjt.springboot.domain.User;
import com.zjt.springboot.mapper.UserMapper;
import com.zjt.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.lt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

// @RunWith的意思，是不要使用默认方式进行单元测试，而是使用指定的类来提供单元测试
// 所有的spring测试都是找SpringRunner.class
@RunWith(SpringRunner.class)
// 这个是spring boot提供的，会一直找到一个Application类，只要包含了@SpringBootApplication的就算，然后会先启动这个类，来给单元测试提供环境
@SpringBootTest(classes = UserServiceTest.class)
@Transactional
@Rollback(true)
public class UserServiceTest {
    // 这里就可以从启动的spring上下文中，将UserService注入到这里来，供我们进行测试
    @Autowired
    private UserService userService;

    // 这里是基于Mockito框架模拟出来了一个UserMapper
    // 可能我们到这里为止，只想要测试UserService，而UserService依赖了UserMapper，那么我们就需要自己模拟一个UserMapper出来
    // 这里定义的@MockBean，会模拟生成一个UserMapperr，放入spring容器中去，然后被UserService给引用到
    @MockBean
    private UserMapper userMapper;

    @Test
    public void testService(){
        long userId = 3l;

        User user = new User();
        user.setId(1l);
        user.setName("武德瞓");
        user.setAge(33);

        // 这行代码是对employeeMapper的findById方法进行模拟
        // 无论给这个方法传入什么参数
        // 都会返回一个Employee对象，这个是我们预先定义好的employee对象
        given(this.userMapper.getUserById(anyLong())).willReturn(user);

        User resultUser = userService.getUserById(userId);

        assertEquals(user,resultUser);
    }

    @Test
    public void test() {
        long userId = 3l;
        // 模拟出来一个实现了EmployeeService接口的对象
        User user = mock(User.class);
        // 这个对象的findById()方法无论传入什么参数，都是返回预定义的一个对象
        when(userService.getUserById((anyLong()))).thenReturn(user);
        // 尝试调用
        User resultUser = userService.getUserById(userId);
        // 比较结果
        assertEquals(user, resultUser);

        UserService userService = mock(UserService.class);
        when(userService.getUserById(lt(userId))).thenThrow(new IllegalArgumentException("userId不能小于0"));
        User resultUser1 = userService.getUserById(-1l);
    }
}

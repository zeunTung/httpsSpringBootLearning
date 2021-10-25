package com.zjt.demo;

import com.zjt.springboot.domain.User;
import com.zjt.springboot.service.UserService;
import com.zjt.springboot.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.RequestEntity.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    // 这个是专门用来测试mvc的类，可以模拟发起http请求
    @Autowired
    private MockMvc mockMvc;

    // 这里是模拟以一个service组件
    @MockBean
    private UserService userService;

    @Test
    public void testMvc() throws Exception{
        long userId = 3l;

        // 这里是模拟service组件的行为
        User user = new User();
        user.setId(1l);
        user.setName("武德瞓");
        user.setAge(33);

        // 这行代码是对employeeMapper的findById方法进行模拟
        // 无论给这个方法传入什么参数
        // 都会返回一个Employee对象，这个是我们预先定义好的employee对象
        given(this.userService.getUserById(anyLong())).willReturn(user);

        // 这里是模拟发起一个http请求
        mockMvc.perform((RequestBuilder) get("/user/{id}", userId))
         .andExpect(model().attribute("id", 1))
         .andExpect(model().attribute("name", "张三"))
         .andExpect(model().attribute("age", 20));
   }
}

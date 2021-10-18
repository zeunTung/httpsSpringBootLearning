package com.zjt.springboot.web;

import com.zjt.springboot.domain.User;
import com.zjt.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 这里直接在类级别给一个/user的映射，就是代表用户管理的请求都会到这里来
@RequestMapping(value="/api/v1.0/user")
public class UserController { 
 
    @Autowired
    private UserService userService;

    // GET请求代表着是查询数据
//    @RequestMapping(value="/", method= RequestMethod.GET)
    @GetMapping("/")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    // GET请求+{id}代表的是查询某个用户
//    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
//        System.out.println(userStatus);
        return userService.getUserById(userId);
    }

    // POST请求代表着是新增数据
    // 这里就声明了要激活Add group对应的校验注解
    // 那么就会校验user的userId不能为空
//    @RequestMapping(value="/", method=RequestMethod.POST)
    @PostMapping("/")
    public String saveUser(@Validated({User.Add.class}) User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            FieldError fieldError = (FieldError) allErrors.get(0);
            String message = fieldError.getObjectName() + ","+ fieldError.getField() + ","+ fieldError.getDefaultMessage();
            return "error:"+message;
        }

        userService.saveUser(user);
        return "success";
    }

    // PUT请求代表的是更新
//    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Long userId, User user) {
        user.setId(userId);
        userService.updateUser(user);
        return "success";
    }

    // DELETE请求代表的是删除
//    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    @DeleteMapping("/userId")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
        return "success";
    }
}

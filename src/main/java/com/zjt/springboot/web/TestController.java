package com.zjt.springboot.web;

import com.zjt.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/test")
public class TestController  {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/user/{id}")
    @ResponseBody
    public User testGetUserById(@PathVariable("id") Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String uri = "http://localhost:8080/api/v1.0/user/{id}";
        User user = restTemplate.getForObject(uri, User.class, id);
        return user;
    }
}

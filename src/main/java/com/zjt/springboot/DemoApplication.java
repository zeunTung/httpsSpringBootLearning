package com.zjt.springboot;

import com.zjt.springboot.Listener.MyApplicationStartedEventListener;
import com.zjt.springboot.configuration.DruidDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
// 使用@Import就可以将其他的配置管理类导入进来
@Import(DruidDBConfig.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.run(args);
//        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "hello!"+name;
    }
}

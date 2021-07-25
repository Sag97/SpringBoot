package com.aiguo.boot.controller;


import com.aiguo.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody//返回的是字符串，而不是跳转页面
//@Controller
@Slf4j
@RestController
public class helloController {
    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01(@RequestParam("name") String name) {
        log.info("请求进来了");
        return "hello,springboot2" + "你好 " + name;
    }
}

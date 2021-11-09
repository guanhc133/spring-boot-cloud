package org.itguan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EurekaProviderController {

    @GetMapping("/hello")
    public String sayHello() throws InterruptedException {
        //模拟超时hystrix降级
        Thread.sleep(6000);
        return "hello";
    }
}

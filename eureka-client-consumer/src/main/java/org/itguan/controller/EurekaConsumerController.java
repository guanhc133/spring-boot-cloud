package org.itguan.controller;

import lombok.extern.slf4j.Slf4j;
import org.itguan.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EurekaConsumerController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/hello")
    public String sayHello() {
        return feignService.sayHello("name");
    }
}

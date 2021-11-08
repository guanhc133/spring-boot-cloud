package org.itguan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EurekaProviderController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable(value = "name") String name) {
        return "hello" + name;
    }
}

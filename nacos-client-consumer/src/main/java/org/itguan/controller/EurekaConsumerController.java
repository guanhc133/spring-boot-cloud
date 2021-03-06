package org.itguan.controller;

import lombok.extern.slf4j.Slf4j;
import org.itguan.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EurekaConsumerController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("/like")
    public String till() {
        return userServiceFeign.getUserBasics();
    }
}

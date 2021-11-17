package org.itguan.service;

import org.itguan.OAuth2FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-client-provider", configuration = OAuth2FeignConfig.class)
public interface UserServiceFeign {

    @GetMapping("/till")
    String getUserBasics();
}
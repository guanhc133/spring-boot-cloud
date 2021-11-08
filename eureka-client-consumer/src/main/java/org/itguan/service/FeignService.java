package org.itguan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka-client-provider")
public interface FeignService {

    @GetMapping("hello/{name}")
    String sayHello(@PathVariable(value = "name") String name);

}

package org.itguan.service;

import org.itguan.fallback.FeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 启用feign 并开启服务降级hystrix
 */
//@FeignClient(value = "eureka-client-provider",fallback = FeignServiceFallback.class)
public interface FeignService {

//    @GetMapping("/hello")
//    String sayHello();

//    @Service
//    default String fallback() {
//        return "异常！";
//    }

}

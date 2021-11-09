package org.itguan.fallback;

import org.itguan.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public String sayHello() {
        return "系统异常";
    }
}

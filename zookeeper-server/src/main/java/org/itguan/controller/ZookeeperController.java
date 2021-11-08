package org.itguan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ZookeeperController {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/foo")
    //动态修改配置文件的值。
    public String from() {
        return this.foo;
    }
}

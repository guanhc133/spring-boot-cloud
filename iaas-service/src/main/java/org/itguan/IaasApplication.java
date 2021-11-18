package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableFeignClients
//开启@PreAuthorize注解
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class IaasApplication {
    public static void main(String[] args) {
        SpringApplication.run(IaasApplication.class, args);
    }
}

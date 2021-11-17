package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableResourceServer
@EnableFeignClients
public class EurekaClientConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumerApplication.class, args);
    }
}

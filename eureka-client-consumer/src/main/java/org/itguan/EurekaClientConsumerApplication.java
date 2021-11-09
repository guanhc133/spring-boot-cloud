package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务消费方
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaClientConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumerApplication.class, args);
    }
}

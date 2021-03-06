package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableResourceServer
@EnableFeignClients
public class NacosClientConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosClientConsumerApplication.class, args);
    }
}

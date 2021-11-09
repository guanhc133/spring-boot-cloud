package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供方
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderApplication.class, args);
    }
}

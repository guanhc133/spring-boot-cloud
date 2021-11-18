package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableResourceServer
public class NacosClientProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosClientProviderApplication.class, args);
    }
}

package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableResourceServer
public class EurekaClientProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderApplication.class, args);
    }
}

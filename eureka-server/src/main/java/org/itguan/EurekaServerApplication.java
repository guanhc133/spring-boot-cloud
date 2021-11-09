package org.itguan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka作为注册中心
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}

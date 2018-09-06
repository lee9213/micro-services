package com.lee9213.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-30 21:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientApplication.class, args);
    }
}

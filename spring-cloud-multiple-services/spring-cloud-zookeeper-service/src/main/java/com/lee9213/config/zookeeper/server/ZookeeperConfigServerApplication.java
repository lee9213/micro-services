package com.lee9213.config.zookeeper.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-09-06 0:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperConfigServerApplication.class, args);
    }
}
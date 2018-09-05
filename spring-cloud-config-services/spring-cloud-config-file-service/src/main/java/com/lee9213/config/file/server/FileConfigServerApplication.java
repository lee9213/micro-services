package com.lee9213.config.file.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-01 21:54
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class FileConfigServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FileConfigServerApplication.class).run(args);
    }
}

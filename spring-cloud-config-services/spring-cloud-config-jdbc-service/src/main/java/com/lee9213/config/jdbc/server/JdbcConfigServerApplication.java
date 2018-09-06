package com.lee9213.config.jdbc.server;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-01 21:54
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class JdbcConfigServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JdbcConfigServerApplication.class).run(args);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}

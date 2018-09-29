package com.lee9213.gmall.sso;


import com.lee9213.gmall.sso.message.producer.MessageProducerSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 11:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lee9213.gmall.sso.service")
@EnableHystrix
@EnableBinding(MessageProducerSource.class)
public class SsoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SsoApplication.class)
                .run(args);
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.lee9213.gmall.user;


import com.lee9213.gmall.user.message.consumer.MessageConsumerSink;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 11:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableBinding(MessageConsumerSink.class)
public class UserApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class).run(args);
    }


    @StreamListener(MessageConsumerSink.INPUT)
    public void onMessage(Object message){
        System.out.println("注冊用戶成功,ID："+new String((byte[])message));
    }
}

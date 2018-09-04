package com.lee9213.spring.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-09-04 14:25
 */
@SpringBootApplication
@EnableAdminServer
public class SpringBootAdminApplication {


    public static void main(String[] args) {
        // 第一种启动方式
        SpringApplication.run(SpringBootAdminApplication.class, args);


        // 第二种启动方式
//        SpringApplication springApplication = new SpringApplication(SpringBootAdminApplication.class);
//        Map<String, Object> properties = new LinkedHashMap<>();
//        properties.put("server.port", 0);
//        springApplication.setDefaultProperties(properties);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        ConfigurableApplicationContext context = springApplication.run(args);
//
//        System.out.println(context.getClass().getName());

        // 第三种启动方式
//        new SpringApplicationBuilder(SpringBootAdminApplication.class).properties("server.port=0").run(args);


//        ClassPathXmlApplicationContext
//        AnnotationConfigApplicationContext
    }
}

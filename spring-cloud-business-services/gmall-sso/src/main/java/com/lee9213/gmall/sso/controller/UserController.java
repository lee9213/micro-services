package com.lee9213.gmall.sso.controller;

import com.lee9213.gmall.sso.enums.ResponseEnum;
import com.lee9213.gmall.sso.message.producer.MessageProducerSource;
import com.lee9213.gmall.sso.service.IUserCoreService;
import com.lee9213.gmall.sso.support.ResponseData;
import com.lee9213.gmall.user.dto.UserLoginRequest;
import com.lee9213.gmall.user.dto.UserLoginResponse;
import com.lee9213.gmall.user.dto.UserRegisterRequest;
import com.lee9213.gmall.user.dto.UserRegisterResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 13:59
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private IUserCoreService userCoreService;

    @Autowired
    private MessageProducerSource messageProducerSource;

    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "doLoginFallback")
    public ResponseData doLogin(String userName, String password) {
        ResponseData data = new ResponseData();
        UserLoginRequest request = new UserLoginRequest();
        request.setUserName(userName);
        request.setPassword(password);

        UserLoginResponse login = userCoreService.login(request);
        data.setCode(login.getCode());
        data.setMsg(login.getMsg());
        data.setData("http://localhost:8080/pages/register.html");

//        ServletHolder.getResponse().addHeader("Set-Cookie",
//                "access_token=" + login.getToken() + ";Path=/;HttpOnly");
        return data;
    }

    public ResponseData doLoginFallback(String userName, String password) {
        return new ResponseData();
    }

    @PostMapping("/register")
    @HystrixCommand(fallbackMethod = "registerFallback")
    public ResponseData register(String userName, String password, String mobile) {
        ResponseData data = new ResponseData();

        UserRegisterRequest request = new UserRegisterRequest();
        request.setMobile(mobile);
        request.setUsername(userName);
        request.setPassword(password);
        try {
            UserRegisterResponse response = userCoreService.register(request);
            //异步化解耦
            messageProducerSource.luckyDrawChanceTopicOutput().send(new GenericMessage(response.getUid()));

            data.setMsg(response.getMsg());
            data.setCode(response.getCode());
        } catch (Exception e) {
            data.setMsg(ResponseEnum.FAILED.getMsg());
            data.setCode(ResponseEnum.FAILED.getCode());
        }
        return data;
    }

    public ResponseData registerFallback(String userName, String password, String mobile) {
        return new ResponseData();
    }
}

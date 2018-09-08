package com.lee9213.gmall.sso.service;


import com.lee9213.gmall.user.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 8:41
 */
@FeignClient(value = "gmall-user-provider")
public interface IUserCoreService {

    /**
     * 用户登陆
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    UserLoginResponse login(@RequestBody UserLoginRequest request);


    /**
     * 校验token
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/validToken")
    CheckAuthResponse validToken(@RequestBody CheckAuthRequest request);

    /**
     * 注册
     * @param userRegisterRequest
     * @return
     */
    @PostMapping(value = "/register")
    UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest);

}

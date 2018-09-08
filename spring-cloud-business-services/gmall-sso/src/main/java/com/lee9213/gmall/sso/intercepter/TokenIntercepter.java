package com.lee9213.gmall.sso.intercepter;

import com.lee9213.gmall.sso.controller.BaseController;
import com.lee9213.gmall.sso.service.IUserCoreService;
import com.lee9213.gmall.sso.utils.CookieUtil;
import com.lee9213.gmall.user.dto.CheckAuthRequest;
import com.lee9213.gmall.user.dto.CheckAuthResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 17:38
 */
public class TokenIntercepter extends HandlerInterceptorAdapter {
    private final String ACCESS_TOKEN = "access_token";

    @Autowired
    private IUserCoreService userCoreService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Object bean = handlerMethod.getBean();

        if (!(bean instanceof BaseController)) {
            throw new RuntimeException("must extend basecontroller");
        }
        String token = CookieUtil.getCookieValue(request, ACCESS_TOKEN);
        boolean isAjax = CookieUtil.isAjax(request);
        if (StringUtils.isEmpty(token)) {
            if (isAjax) {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write("{\"code\":\"-1\",\"msg\":\"error\"}");
                return false;
            }
//            response.sendRedirect(WebConstant.GPMALL_SSO_ACCESS_URL);
            return false;
        }
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
        checkAuthRequest.setToken(token);
        CheckAuthResponse checkAuthResponse = userCoreService.validToken(checkAuthRequest);
        if ("000000".equals(checkAuthResponse.getCode())) {
            BaseController baseController = (BaseController) bean;
            baseController.setUid(checkAuthResponse.getUid());
            return super.preHandle(request, response, handler);
        }
        if (isAjax) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("{\"code\":\"" + checkAuthResponse.getCode() + "\"" +
                    ",\"msg\":\"" + checkAuthResponse.getMsg() + "\"}");
            return false;
        }
//        response.sendRedirect(WebConstant.GPMALL_SSO_ACCESS_URL);


        return false;
    }
}

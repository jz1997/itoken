package com.jzheng.itoken.web.admin.service;

import com.jzheng.itoken.web.admin.service.fallback.AdminServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 客户端
 * @author jzheng
 * @date 2019/8/30
 */
@FeignClient(value = "itoken-service-admin", fallback = AdminServiceFallbackImpl.class)
@Service
public interface AdminService {

    /**
     * 登录请求
     *  请求地址  : login
     *  请求方式  : GET
     * @param loginCode 登录账号
     * @param password  登录密码
     * @return 登录页面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam("loginCode") String loginCode,
                        @RequestParam("password") String password);
}

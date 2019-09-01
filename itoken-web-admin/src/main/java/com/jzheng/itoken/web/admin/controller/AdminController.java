package com.jzheng.itoken.web.admin.controller;

import com.jzheng.itoken.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Web 服务控制器
 * @author jzheng
 * @date 2019/8/30
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转登录页面
     * @return index 页面
     */
    @RequestMapping(value = { "", "login" }, method = RequestMethod.GET)
    public String login() {
        String login = adminService.login("", "");
        System.out.println(login);
        return "index";
    }
}

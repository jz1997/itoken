package com.jzheng.itoken.service.admin.controller;

import com.jzheng.itoken.common.dto.BaseResult;
import com.jzheng.itoken.service.admin.domain.TbSysUser;
import com.jzheng.itoken.service.admin.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zipkin2.Call;

import java.util.List;

/**
 * 管理员 rest 风格控制器
 * @author jzheng
 * @date 2019/8/30
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param loginCode 登录账户
     * @param password  登录密码
     * @return BaseResult
     */
    @RequestMapping(value = "login")
    public BaseResult login(String loginCode, String password) {

        BaseResult baseResult = checkLogin(loginCode, password);

        // 检查失败
        if (null != baseResult) {
            return baseResult;
        }

        TbSysUser loginUser = adminService.login(loginCode, password);

        // 登录成功
        if (null != loginUser) {
            return BaseResult.ok(loginUser);
        }

        // 登录失败
        else {
            return BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("", "登录失败")
            ));
        }
    }

    /**
     * 检测登录账户和密码
     * @param loginCode 登录账户
     * @param password  密码
     * @return baseResult
     */
    private BaseResult checkLogin(String loginCode, String password) {
        BaseResult baseResult = null;

        if (StringUtils.isBlank(loginCode) || StringUtils.isBlank(password)) {
            baseResult = BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("登录账号", "登录账号不能为空"),
                    new BaseResult.Error("登录密码", "登录密码不能为空")
            ));
        }

        return baseResult;
    }
}

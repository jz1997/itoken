package com.jzheng.itoken.service.admin.test.service;

import com.jzheng.itoken.service.admin.ServiceAdminApplication;
import com.jzheng.itoken.service.admin.domain.TbSysUser;
import com.jzheng.itoken.service.admin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 测试 TbSysUserMapper
 * @author jzheng
 * @date 2019/8/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)

public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    /**
     * 测试 AdminService 中的 login 方法
     */
    @Test
    public void login() {
        TbSysUser tbSysUser
                = adminService.login("jzheng@qq.com", "123456");
        Assert.assertNotNull(tbSysUser);
    }


    /**
     * 测试 AdminService 中的 register 方法
     */
    @Test
    public void register() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setLoginCode("jzheng@qq.com");
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setUserName("jzheng");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbSysUser.setUserType("管理员");
        tbSysUser.setMgrType("2");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("123");
        tbSysUser.setCorpName("123");
        adminService.register(tbSysUser);
    }
}

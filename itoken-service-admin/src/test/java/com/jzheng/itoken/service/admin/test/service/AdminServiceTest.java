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

import java.util.Date;
import java.util.UUID;

/**
 * 测试 TbSysUserMapper
 * @author jzheng
 * @date 2019/8/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@Transactional
@Rollback
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    /**
     * 测试 AdminService 中的 login 方法
     */
    @Test
    public void login() {
        TbSysUser tbSysUser
                = adminService.login("jzheng", "123456");
        Assert.assertNotNull(tbSysUser);
    }


    /**
     * 测试 AdminService 中的 register 方法
     */
    @Test
    public void register() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setLoginCode("jzheng");
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setUserName("jzheng");
        tbSysUser.setPassword("123456");
        tbSysUser.setUserType("管理员");
        tbSysUser.setMgrType("2");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy("jzheng");
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy("jzheng");
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("123");
        tbSysUser.setCorpName("123");
        adminService.register(tbSysUser);
    }
}

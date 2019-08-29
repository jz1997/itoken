package com.jzheng.itoken.service.admin.test.service;

import com.jzheng.itoken.service.admin.ServiceAdminApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
    @Test
    public void login() {

    }

    @Test
    public void register() {

    }
}

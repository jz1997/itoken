package com.jzheng.itoken.service.admin.mapper.test;

import com.jzheng.itoken.service.admin.ServiceAdminApplication;
import com.jzheng.itoken.service.admin.domain.TbSysUser;
import com.jzheng.itoken.service.admin.mapper.TbSysUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
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
public class TbSysUserMapperTest {
    @Autowired
    private TbSysUserMapper mapper;
    @Test
    public void SelectTest() {
        TbSysUser tbSysUser = mapper.selectByPrimaryKey("12345");
        Assert.assertNull(tbSysUser);
    }
}

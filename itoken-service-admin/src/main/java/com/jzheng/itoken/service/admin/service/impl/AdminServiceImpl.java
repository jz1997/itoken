package com.jzheng.itoken.service.admin.service.impl;

import com.jzheng.itoken.service.admin.domain.TbSysUser;
import com.jzheng.itoken.service.admin.mapper.TbSysUserMapper;
import com.jzheng.itoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jzheng
 * @date 2019/8/29
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    /**
     * 注册用户
     * @param tbSysUser 需要注册的实体
     */
    @Override
    public void register(TbSysUser tbSysUser) {
        tbSysUserMapper.insert(tbSysUser);
    }

    /**
     * 用户登录
     * @param loginCode 登录账号
     * @param plantPassword 明文登录密码
     * @return 登录用户
     */
    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        return null;
    }
}

package com.jzheng.itoken.service.admin.service.impl;

import com.jzheng.itoken.service.admin.domain.TbSysUser;
import com.jzheng.itoken.service.admin.mapper.TbSysUserMapper;
import com.jzheng.itoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

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
        // md5 进行密码加密
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));
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
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode", loginCode);

        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);

        // 密码加密 进行比对
        String hexPassword = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
        
        // 登录成功
        if (hexPassword.equals(tbSysUser.getPassword())) {
            return tbSysUser;
        }

        // 登录失败
        return null;
    }
}

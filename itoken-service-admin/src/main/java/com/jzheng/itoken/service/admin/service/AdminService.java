package com.jzheng.itoken.service.admin.service;

import com.jzheng.itoken.service.admin.domain.TbSysUser;

/**
 * 管理员服务接口
 * @author jzheng
 * @date 2019/8/29
 */
public interface AdminService {
    /**
     * 注册用户
     * @param tbSysUser 需要注册的实体
     */
    void register(TbSysUser tbSysUser);

    /**
     * 用户登录
     * @param loginCode 登录账号
     * @param plantPassword 明文登录密码
     * @return 登录用户
     */
    TbSysUser login(String loginCode, String plantPassword);
}

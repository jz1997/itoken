package com.jzheng.itoken.service.admin.mapper;

import com.jzheng.itoken.service.admin.domain.TbSysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

/**
 * 系统用户 mapper 层
 * @author jzheng
 * @date 2019/8/29
 */
@Repository
public interface TbSysUserMapper extends MyMapper<TbSysUser> {
}
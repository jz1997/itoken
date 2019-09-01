package com.jzheng.itoken.web.admin.service.fallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;
import com.jzheng.itoken.common.constants.HttpStatusConstants;
import com.jzheng.itoken.common.dto.BaseResult;
import com.jzheng.itoken.common.utils.MapperUtils;
import com.jzheng.itoken.web.admin.service.AdminService;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * AdminService 的熔断器 处理函数
 * @author jzheng
 * @date 2019/8/30
 */
@Component
public class AdminServiceFallbackImpl implements AdminService {
    /**
     * login 相应失败 进行熔断，返回相应信息
     * @param loginCode 登录账号
     * @param password  登录密码
     * @return 错误的信息
     */
    @Override
    public String login(String loginCode, String password) {
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.Bad_Gateway.getStatus()),
                        HttpStatusConstants.Bad_Gateway.getContent()))
        );

        try {
            return MapperUtils.object2Json(baseResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}

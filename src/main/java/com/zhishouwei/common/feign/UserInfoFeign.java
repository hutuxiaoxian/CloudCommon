package com.zhishouwei.common.feign;

import com.zhishouwei.common.model.AuthUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: 用户信息
 * @author： zhus
 * @version: 1.0
 * @date: 2020/6/10 18:45
 */
@FeignClient(value = "bj-basicdata")
public interface UserInfoFeign {

    /**
     * 根据用户名查询用户信息
     *
     * @param userInfoModel 参数
     * @return ResultForm
     */
    @RequestMapping(value = "/user/queryOneByUserName", method = RequestMethod.POST)
    AuthUser queryOneByUserName(AuthUser userInfoModel);
}

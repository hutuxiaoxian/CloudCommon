package com.zhishouwei.common.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.List;

@Data
public class AuthUser extends SecurityProperties.User {


    private Long userId;
    private String username;
    private String password;
    private List<String> roleList;
    private String identifyCode;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public static AuthUser getInstances(OAuth2Authentication principal) {
        return (AuthUser) JSON.parseObject(JSON.toJSONString(principal.getUserAuthentication().getDetails()), AuthUser.class);
    }
}

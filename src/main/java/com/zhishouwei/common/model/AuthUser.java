package com.zhishouwei.common.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("ALL")
@Data
public class AuthUser extends User {

    private static final Long serialVersionUID = 801L;
    private String userId;
    private String username;
    private String password;
    private String[] roles;
    private String[] resources;
    private String identifyCode;
    private String mobile;
    private String openId;
    private String email;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public AuthUser() {
        super("hutu", "hutupassword", new ArrayList<>());
    }

    public static AuthUser getInstances(OAuth2Authentication principal) {
        return (AuthUser) JSON.parseObject(JSON.toJSONString(principal.getUserAuthentication().getDetails()), AuthUser.class);
    }
    public static AuthUser getInstance() {
        OAuth2Authentication principal = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        return getInstances(principal);
    }
    public static String getToken() {
        OAuth2Authentication principal = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Authentication userAuthentication = principal.getUserAuthentication();
        Map<String, Object> details = (Map<String, Object>) userAuthentication.getDetails();
        Map<String, Object> token = (Map<String, Object>) details.get("details");
        return token.get("tokenValue").toString();
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String[] getResources() {
        return resources;
    }

    public void setResources(String[] resources) {
        this.resources = resources;
    }
}

package com.zhishouwei.common.utils;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EnableResourceServer
@EnableFeignClients
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public @interface EnableCloudServer {
}



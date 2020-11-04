package com.zhishouwei.common.utils;

import com.zhishouwei.common.config.MybatisPlusConfig;
import com.zhishouwei.common.config.OAuthResourceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({OAuthResourceConfig.class, MybatisPlusConfig.class})
@EnableResourceServer
@EnableFeignClients
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)

public @interface EnableCloudServer {
}
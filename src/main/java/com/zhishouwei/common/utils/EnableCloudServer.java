package com.zhishouwei.common.utils;

import com.zhishouwei.common.config.OAuthResourceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({OAuthResourceConfig.class})
@EnableFeignClients
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public @interface EnableCloudServer {
}



package com.zhishouwei.common.utils;

import com.zhishouwei.common.config.NodeConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({NodeConfiguration.class})
@EnableFeignClients
@SpringBootApplication
public @interface EnableCloudServer {
}



package com.zhishouwei.common;

import com.zhishouwei.common.model.mybatis.BaseGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

//    @Bean
//    void getBaseGenerator() {
//        new BaseGenerator().getBaseGenerator();
//    }
}

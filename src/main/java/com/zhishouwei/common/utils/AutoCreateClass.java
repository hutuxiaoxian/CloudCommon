package com.zhishouwei.common.utils;

import com.zhishouwei.common.model.mybatis.BaseGenerator;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 通过表结构自动生成Controller,Service,ServiceImpl,Mapper,Entity
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({BaseGenerator.class})
public @interface AutoCreateClass {
}

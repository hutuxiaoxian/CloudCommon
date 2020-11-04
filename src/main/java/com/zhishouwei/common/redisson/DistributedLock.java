package com.zhishouwei.common.redisson;

import java.lang.annotation.*;

/**
 * 基于注解的分布式式锁<br>
 *
 * @className: DistributedLock
 * @package: com.bjblackhole.common
 * @author: 曾维录
 * @date: 2020/7/7 13:04
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributedLock {
    /**
     * 锁的名称
     */
    String value() default "redisson";

    /**
     * 锁的有效时间
     */
    int leaseTime() default  1 ;
}


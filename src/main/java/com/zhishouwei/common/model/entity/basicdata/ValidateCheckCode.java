package com.zhishouwei.common.model.entity.basicdata;

import lombok.Data;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/7/13 11:09
 */
@Data
public class ValidateCheckCode {

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码
     */
    private String checkCode;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 值
     */
    private String value;

}

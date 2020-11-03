package com.zhishouwei.common.config;

/**
 * 正则表达式
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/7/17 15:26
 */
public class RegularConstants {

    /**
     * 手机号正确性校验正则
     */
    public static final String MOBILE_RULE = "^[1][3,4,5,6,7,8,9][0-9]{9}$";

    /**
     * 手机号显示正则
     */
    public static final String MOBILE_VIEW_RULE = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手身份证号显示正则
     */
    public static final String ID_CARD_VIEW_RULE = "(\\d{4})\\d{10}(\\w{4})";

    /**
     * 显示模板正则
     */
    public static final String VIEW_RULE_MODEL = "$1****$2";

    /**
     * 邮箱正则
     */
    public static final String EMAIL_RULE = "^[0-9a-z]+\\w*@([0-9a-z]+\\.)+[0-9a-z]+$";

    /**
     * 密码规则
     */
    public static final String PASS_WORD_RULE = "^(?![A-Za-z0-9]+$)"
            + "(?![a-z0-9`~!@#$%^&*()_=+[{]};:\"\"''\\\\|,<.>/?-]+$)"
            + "(?![A-Za-z`~!@#$%^&*()_=+[{]};:\"\"''\\\\|,<.>/?-]+$)"
            + "(?![A-Z0-9`~!@#$%^&*()_=+[{]};:\"\"''\\\\|,<.>/?-]+$)"
            + "[a-zA-Z0-9`~!@#$%^&*()_=+[{]};:\"\"''\\\\|,<.>/?-]{8,20}$";
}

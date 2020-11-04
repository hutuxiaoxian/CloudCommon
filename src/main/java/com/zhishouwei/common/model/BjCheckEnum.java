package com.zhishouwei.common.model;

/**
 * 套餐校验Enum
 */
public enum BjCheckEnum {

    CHECK_PROJECT_MODEL_NUM("4",  "校验是否有足够项目模型数"),
    CHECK_PROJECT_MODEL_CONVERT_NUM("3", "校验是否有足够项目模型转换数量"),
    CHECK_EMPLOYEE_COUNT("2", "校验是否有足够员工数"),
    CHECK_RESOURCE_SIZE("1", "校验是否有足够空间"),
    OPERAT_CHECK_RECOVER("4", "校验通过，恢复资源"),
    OPERAT_CHECK_FREEZE("3", "校验通过，冻结资源"),
    OPERAT_CHECK_DEDUCT("2", "校验通过，扣除资源"),
    OPERAT_CHECK_ONLY("1", "只做校验");


    private String code;
    private String message;

    /**
     * \
     *
     * @param code    code
     * @param message message
     */
    BjCheckEnum(String code,  String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * get
     *
     * @return code code
     */
    public String getCode() {
        return code;
    }

    /**
     * get
     *
     * @return message message
     */
    public String getMessage() {
        return message;
    }

    /**
     * set
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * set
     *
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

package com.zhishouwei.common.model;

public enum ResultEnum {
    error(400),
    success(200),
    warn(100),
    none(300);

    private Integer result;

    private ResultEnum(Integer value) {
        this.result = value;
    }

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}

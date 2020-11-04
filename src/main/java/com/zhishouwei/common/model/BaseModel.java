package com.zhishouwei.common.model;

import lombok.Data;

/**
 * model 父类
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/5 16:36
 */
@Data
public class BaseModel {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 页面大小
     */
    private Integer size;

    /**
     * id
     */
    private String id;

    /**
     * 获取偏移量
     *
     * @return Integer
     */
    public Integer getOffset() {
        if (page != null) {
            return (page - 1) * size;
        }
        return null;
    }
}

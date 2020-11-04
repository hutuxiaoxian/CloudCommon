package com.zhishouwei.common.model;

import lombok.Data;

/**
 * 消息 保存 请求参数
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/5 11:58
 */
@Data
public class ModelFileFeignModel {

    /**
     * 项目id
     */
    private String projectId;

    /**
     * 操作类型 1：启动    2：终止
     */
    private String type;

}

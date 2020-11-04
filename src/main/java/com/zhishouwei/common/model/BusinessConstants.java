package com.zhishouwei.common.model;

import java.io.Serializable;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/6/10 11:30
 */
public class BusinessConstants implements Serializable {

    /**
     * 状态默认值
     */
    public static final Integer STATUS_DEFAULT = 0;

    /**
     * 默认类型
     */
    public static final Integer DEFAULT_TYPE = 1;

    /**
     * 默认类型 -1
     */
    public static final Integer DEFAULT_NEGATIVE = -1;

    /**
     * 我参与的
     */
    public static final Integer MY_PART_IN = 2;

    /**
     * 通知提示 回复
     */
    public static final String CREATE = "创建";

    /**
     * 通知提示 回复
     */
    public static final String REPLY = "回复";

    /**
     * 通知提示 上传
     */
    public static final String UPLOAD = "上传";

    /**
     * 通知提示 删除
     */
    public static final String DELETE = "删除";

    /**
     * 通知提示 加入
     */
    public static final String JOIN = "加入";

    /**
     * 通知提示 退出
     */
    public static final String EXIT = "退出";

    /**
     * 评论默认设置3条
     */
    public static final int BBS_LIST_DEFAULT_SIZE = 3;


}

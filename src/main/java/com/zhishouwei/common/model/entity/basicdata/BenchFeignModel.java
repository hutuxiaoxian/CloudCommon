package com.zhishouwei.common.model.entity.basicdata;

import com.zhishouwei.common.model.entity.business.LatestAlteration;
import com.zhishouwei.common.model.entity.business.SystemMessage;
import com.zhishouwei.common.model.entity.business.WaitingProcess;
import lombok.Data;

/**
 * 消息 保存 请求参数
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/5 11:58
 */
@Data
public class BenchFeignModel {

    /**
     * 用户id 或 包含用户id的对象 JsonString
     */
    private String userList;

    /**
     * 最新动态实体
     */
    private LatestAlteration latestAlteration;

    /**
     * 待办事项
     */
    private WaitingProcess waitingProcess;

    /**
     * 系统消息
     */
    private SystemMessage systemMessage;
}

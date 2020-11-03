package com.zhishouwei.common.mq;

import com.zhishouwei.common.utils.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/6/16 17:46
 */
@Slf4j
@Component
public class MqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送模型处理的 消息
     *
     * @param object 参数
     */
    public void sendSms(Object object) {
        log.info("发送模型处理的 消息 sendSms:{}", object);
        rabbitTemplate.convertAndSend(MqConstant.SMS_EXCHANGE, MqConstant.SMS_QUEUE, object);
    }

    /**
     * 发送模型处理的 消息
     *
     * @param object 参数
     */
    public void sendCheckFile(Object object) {
        log.info("发送模型处理的 消息 sendCheckFile:{}", object);
        rabbitTemplate.convertAndSend(MqConstant.CHECK_FILE_EXCHANGE, MqConstant.CHECK_FILE_QUEUE, object);
    }

    /**
     * 发送终止模型转换 消息
     *
     * @param object 参数
     */
    public void sendStopConvertingProject(Object object) {
        log.info("发送终止模型转换 消息 sendStopConvertingProject:{}", object);
        rabbitTemplate.convertAndSend(MqConstant.STOP_CONVERTING_PROJECT_EXCHANGE,
                MqConstant.STOP_CONVERTING_PROJECT_QUEUE, object);
    }

    /**
     * 发送查询工程转换进度 消息
     *
     * @param object 参数
     */
    public void sendGetProjectConvertingProgress(Object object) {
        log.info("发送查询工程转换进度 消息 sendStopConvertingProject:{}", object);
        rabbitTemplate.convertAndSend(MqConstant.GET_PROJECT_CONVERTING_PROGRESS_EXCHANGE,
                MqConstant.GET_PROJECT_CONVERTING_PROGRESS_QUEUE, object);
    }

    /**
     * 发送恢复项目文件资源 消息
     * @param object 参数
     */
    public void sendRecoverFileResources(Object object) {
        log.info("发送恢复项目文件资源 消息 sendRecoverFileResources:{}", object);
        rabbitTemplate.convertAndSend(MqConstant.RECOVER_FILE_RESOURCES_EXCHANGE,
                MqConstant.RECOVER_FILE_RESOURCES_QUEUE, object);
    }
}

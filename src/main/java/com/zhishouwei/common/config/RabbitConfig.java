package com.zhishouwei.common.config;

import com.zhishouwei.common.utils.MqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit 配置
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/16 17:45
 */

@Configuration
public class RabbitConfig {

    /**
     * 初始化短信交换机
     *
     * @return smsExchange
     */
    @Bean
    public DirectExchange smsExchange() {
        return new DirectExchange(MqConstant.SMS_EXCHANGE, true, false);
    }

    /**
     * 初始化短信的队列
     *
     * @return smsQueue
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(MqConstant.SMS_QUEUE, true, false, false);
    }

    /**
     * 短信的队列和交换机绑定
     *
     * @return smsBinding
     */
    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(smsQueue()).to(smsExchange()).with(MqConstant.SMS_QUEUE);
    }

    /**
     * 初始化检查文件交换机
     *
     * @return smsExchange
     */
    @Bean
    public DirectExchange checkFileExchange() {
        return new DirectExchange(MqConstant.CHECK_FILE_EXCHANGE, true, false);
    }

    /**
     * 初始化检查文件队列
     *
     * @return smsQueue
     */
    @Bean
    public Queue checkFileQueue() {
        return new Queue(MqConstant.CHECK_FILE_QUEUE, true, false, false);
    }

    /**
     * 检查文件的队列和交换机绑定
     *
     * @return smsBinding
     */
    @Bean
    public Binding checkFileBinding() {
        return BindingBuilder.bind(checkFileQueue()).to(checkFileExchange()).with(MqConstant.CHECK_FILE_QUEUE);
    }

    /**
     * 初始化终止模型转换交换机
     *
     * @return smsExchange
     */
    @Bean
    public DirectExchange stopConvertingProjectExchange() {
        return new DirectExchange(MqConstant.STOP_CONVERTING_PROJECT_EXCHANGE, true, false);
    }

    /**
     * 初始化终止模型转换队列
     *
     * @return smsQueue
     */
    @Bean
    public Queue stopConvertingProjectQueue() {
        return new Queue(MqConstant.STOP_CONVERTING_PROJECT_QUEUE, true, false, false);
    }

    /**
     * 终止模型转换的队列和交换机绑定
     *
     * @return smsBinding
     */
    @Bean
    public Binding stopConvertingProjectBinding() {
        return BindingBuilder.bind(stopConvertingProjectQueue()).to(stopConvertingProjectExchange()).with(MqConstant.STOP_CONVERTING_PROJECT_QUEUE);
    }

    /**
     * 初始化查询工程转换进度交换机
     *
     * @return smsExchange
     */
    @Bean
    public DirectExchange getProjectConvertingProgressExchange() {
        return new DirectExchange(MqConstant.GET_PROJECT_CONVERTING_PROGRESS_EXCHANGE, true, false);
    }

    /**
     * 初始化查询工程转换进度队列
     *
     * @return smsQueue
     */
    @Bean
    public Queue getProjectConvertingProgressQueue() {
        return new Queue(MqConstant.GET_PROJECT_CONVERTING_PROGRESS_QUEUE, true, false, false);
    }

    /**
     * 查询工程转换进度的队列和交换机绑定
     *
     * @return smsBinding
     */
    @Bean
    public Binding getProjectConvertingProgressBinding() {
        return BindingBuilder.bind(getProjectConvertingProgressQueue()).to(getProjectConvertingProgressExchange())
                .with(MqConstant.GET_PROJECT_CONVERTING_PROGRESS_QUEUE);
    }

    /**
     * 初始化恢复项目文件资源交换机
     *
     * @return smsExchange
     */
    @Bean
    public DirectExchange recoverFileResourcesExchange() {
        return new DirectExchange(MqConstant.RECOVER_FILE_RESOURCES_EXCHANGE, true, false);
    }

    /**
     * 初始化恢复项目文件资源队列
     *
     * @return smsQueue
     */
    @Bean
    public Queue recoverFileResourcesQueue() {
        return new Queue(MqConstant.RECOVER_FILE_RESOURCES_QUEUE, true, false, false);
    }

    /**
     * 恢复项目文件资源队列和交换机绑定
     *
     * @return smsBinding
     */
    @Bean
    public Binding recoverFileResourcesBinding() {
        return BindingBuilder.bind(recoverFileResourcesQueue()).to(recoverFileResourcesExchange())
                .with(MqConstant.RECOVER_FILE_RESOURCES_QUEUE);
    }

}

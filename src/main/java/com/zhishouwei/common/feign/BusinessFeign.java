package com.zhishouwei.common.feign;

import com.zhishouwei.common.model.ModelFileFeignModel;
import com.zhishouwei.common.model.entity.basicdata.BenchFeignModel;
import com.zhishouwei.common.model.entity.business.SystemMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 工作台 最新动态 模块 feign
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/3 17:37
 */
@FeignClient(value = "bj-business")
public interface BusinessFeign {

    /**
     * 添加 最新动态
     *
     * @param benchFeignModel 参数
     * @return boolean
     */
    @RequestMapping(value = "/bench/addLatest", method = RequestMethod.POST)
    boolean addLatest(@RequestBody BenchFeignModel benchFeignModel);

    /**
     * 添加  代办事项
     *
     * @param benchFeignModel 参数
     * @return boolean
     */
    @RequestMapping(value = "/bench/addWaiting", method = RequestMethod.POST)
    boolean addWaiting(@RequestBody BenchFeignModel benchFeignModel);

    /**
     * 添加  系统消息
     *
     * @param systemMessage 参数
     * @return boolean
     */
    @RequestMapping(value = "/bench/addSystemMes", method = RequestMethod.POST)
    boolean addSystemMes(@RequestBody SystemMessage systemMessage);

    /**
     * 终止项目接口（内部调用）
     *
     * @param modelFileFeignModel 对象  1 代表启动   2 代表 终止
     * @return boolean
     */
    @RequestMapping(value = {"/modelFile/stopConvertingProject"}, method = {RequestMethod.POST})
    boolean stopConvertingProject(@RequestBody ModelFileFeignModel modelFileFeignModel);
}

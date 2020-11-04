package com.zhishouwei.common.feign;

import com.zhishouwei.common.model.entity.basicdata.FilePojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description:操作云盘
 * @author： zhuss
 * @version: 1.0
 * @date: 2020/8/1 21:40
 */
@FeignClient(value = "bj-pan")
public interface PanFeign {

    /**
     * 根据项目id查找该资料文件大小
     *
     * @param filePojo 参数
     * @return ResultForm
     */
    @RequestMapping(value = "/file/getAllSizeByProjectId", method = RequestMethod.POST)
    Long getAllSizeByProjectId(@RequestBody FilePojo filePojo);

    /**
     * 初始化标签(内部调用)
     *
     * @param projectId 参数
     * @return Boolean
     */
    @RequestMapping(value = "/tag/initTag", method = RequestMethod.GET)
    Boolean initTag(@RequestParam(value = "projectId") String projectId);
}

package com.zhishouwei.common.feign;

import com.zhishouwei.common.model.ResultForm;
import com.zhishouwei.common.model.entity.basicdata.FileModel;
import com.zhishouwei.common.model.entity.basicdata.FileRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 删除fastDFS fileId feign
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/3 17:37
 */
@FeignClient(value = "bj-files")
public interface FilesFeign {

    /**
     * 根据fileId删除文件
     *
     * @param fileRequestModel 文件请求模型
     * @return ResultForm
     */
    @RequestMapping(value = "/files/delByFileId", method = RequestMethod.POST)
    ResultForm delByFileId(@RequestBody FileRequestModel fileRequestModel);

    /**
     * 上传文件(内部调用)
     *
     * @param file 文件
     * @return FileModel
     */
    @RequestMapping(value = "/files/uploadFegin", method = RequestMethod.POST)
    FileModel uploadFegin(@RequestParam("file") MultipartFile file);

    /**
     * 根据fileId删除文件(内部调用)
     *
     * @param fileId 文件id
     * @return ResultForm
     */
    @RequestMapping(value = "/files/delByFileIdFegin", method = RequestMethod.GET)
    Boolean delByFileIdFegin(@RequestParam("fileId") String fileId);

}

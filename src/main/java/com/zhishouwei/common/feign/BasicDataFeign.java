package com.zhishouwei.common.feign;

import com.zhishouwei.common.model.ResultForm;
import com.zhishouwei.common.model.entity.basicdata.FileScopeModel;
import com.zhishouwei.common.model.entity.basicdata.ValidateCheckCode;
import org.apache.http.entity.FileEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * basicdata feign
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/7/13 10:54
 */
@FeignClient(value = "bj-basicdata")
public interface BasicDataFeign {

    /**
     * 校验短信验证码 接口
     *
     * @param checkCode 手机号 验证码
     * @return true or false
     */
    @RequestMapping(value = "/user/validateCheckCode", method = RequestMethod.POST)
    ResultForm validateCheckCode(@RequestBody ValidateCheckCode checkCode);

    /**
     * 内部调用 (得到用户该项目的所有权限)
     *
     * @param projectId 项目id
     * @param companyId 公司id
     * @return FileScopeModel
     */
    @RequestMapping(value = {"/sysRole/getMyFileScope"}, method = {RequestMethod.POST})
    FileScopeModel getMyFileScope(@RequestParam(value = "projectId") String projectId,
                                  @RequestParam(value = "companyId") String companyId);

    /**
     * 内部调用(修改使用套餐情况,区分word,excel,pdf,dwg文件数量和其他)
     *
     * @param fileEntity 参数
     * @param type       类型
     * @return ResultForm
     */
    @RequestMapping(value = {"/companyServiceUsage/updateCompanyServiceUsage"}, method = {RequestMethod.POST})
    ResultForm updateCompanyServiceUsage(@RequestBody FileEntity fileEntity,
                                         @RequestParam(value = "type") String type);

    /**
     * 根据唯一约束查找项目内容(内部)
     *
     * @param projectId 对象id
     * @return ResultForm
     */
    @RequestMapping(value = {"/project/findContentByIdFeign"}, method = {RequestMethod.POST})
    ResultForm findContentByIdFeign(@RequestParam(value = "projectId") String projectId);
}

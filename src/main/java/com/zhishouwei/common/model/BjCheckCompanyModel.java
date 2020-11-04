package com.zhishouwei.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈功能概述〉<br>
 *
 * @className: BjCheckCompanyModel
 * @package: com.bjblackhole.common.models
 * @author: TR
 * @date: 2020/6/29 16:32
 */
@Data
public class BjCheckCompanyModel implements Serializable {

    private static final long serialVersionUID = -2306336444529405554L;

    /**
     * 操作类型
     * CHECK_RESOURCE_SIZE("1", "校验是否有足够空间"),
     * OPERAT_CHECK_FREEZE("3", "校验通过，冻结资源"),
     * OPERAT_CHECK_DEDUCT("2", "校验通过，扣除资源"),
     */
    private String operatType;
    /**
     * 校验类型 1：校验资源大小；2：校验员工数；3：校验模型转换数量；4：校验模型数
     */
    private String checkType;
    /**
     * 公司id
     */
    private String companyId;
    /**
     * 资源大小或者文件大小
     */
    private Long resourceSize = 0L;
    /**
     * 员工数
     */
    private Integer employeeCount;

    /**
     * 项目模型转换数量
     */
    private Integer projectModelConvertNum;
    /**
     * 项目模型数
     */
    private Integer projectModelNum;

}

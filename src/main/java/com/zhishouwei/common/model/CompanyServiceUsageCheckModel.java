package com.zhishouwei.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈功能概述〉<br>
 *
 * @className: CompanyServiceUsageCheckModel
 * @package: com.bjblackhole.common.models
 * @author: TR
 * @date: 2020/6/29 16:11
 */
@Data
public class CompanyServiceUsageCheckModel implements Serializable {

    private static final long serialVersionUID = -7581118165607859818L;
    /**
     * 已加入员工数
     */
    private String id;
    /**
     * 已加入员工数
     */
    private Integer employeeRsedCount;
    /**
     * 已建项目数
     */
    private Integer projectRsedNum;
    /**
     * 已导入模型数
     */
    private Integer projectModelRsedNum;
    /**
     * 已导入模型大小
     */
    private Long projectModelRsedSize;
    /**
     * 已使用云盘空间大小
     */
    private Long cloudDiskSpaceRsedSize;
    /**
     * 已转换模型转换数
     */
    private Integer projectModelConvertRsedNum;
    /**
     * 已转换模型数
     */
    private Long projectModelConvertRsedSize;
    /**
     * 文档大小
     */
    private Long docSize;
    /**
     * DWG文档数量
     */
    private Integer docDwgNum;
    /**
     * PDF文档数量
     */
    private Integer docPdfNum;
    /**
     * WORD文档数量
     */
    private Integer docWordNum;
    /**
     * EXCEL文档数量
     */
    private Integer docExcelNum;
    /**
     * 公司id
     */
    private String companyId;
    /**
     * 其他文档数量
     */
    private Integer docOtherNum;
    /**
     * 已冻结空间大小
     */
    private Long cloudDiskSpaceFreeSize;
    /**
     * 用户使用套餐id
     */
    private String serviceConfigId;
    /**
     * 用户vip开始时间
     */
    private String vipEffectiveStartTime;
    /**
     * 用户vip结束时间
     */
    private String vipFailureTime;
}

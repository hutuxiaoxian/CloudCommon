package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 公司套餐使用情况相关接口<br>
 *
 * @className: CompanyServiceUsageEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-06-23 11:27:16
 */
@Data
//@Entity
@Table(name = "np_company_service_usage", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true)
})
@TableName("np_company_service_usage")
public class CompanyServiceUsageEntity extends BaseEntity {
    @Column(name = "employee_rsed_count", columnDefinition = "int(11) unsigned DEFAULT '0' COMMENT '已加入员工数'")
    private Integer employeeRsedCount;

    @Column(name = "project_rsed_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '已建项目数'")
    private Integer projectRsedNum;

    @Column(name = "project_model_rsed_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '已导入模型数'")
    private Integer projectModelRsedNum;

    @Column(name = "vip_failure_time", columnDefinition = "datetime COMMENT '用户vip结束时间'")
    private String vipFailureTime;

    @Column(name = "vip_effective_start_time", columnDefinition = "datetime COMMENT '用户vip开始时间'")
    private String vipEffectiveStartTime;

    @Column(name = "project_model_rsed_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '已导入模型大小'")
    private String projectModelRsedSize;

    @Column(name = "cloud_disk_space_rsed_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '已使用云盘空间大小'")
    private String cloudDiskSpaceRsedSize;

    @Column(name = "cloud_disk_space_free_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '已冻结云盘空间大小'")
    private String cloudDiskSpaceFreeSize;

    @Column(name = "project_model_convert_rsed_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '已转换模型转换数'")
    private Integer projectModelConvertRsedNum;

    @Column(name = "project_model_convert_rsed_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '已转换模型数'")
    private String projectModelConvertRsedSize;

    @Column(name = "doc_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '文档大小'")
    private String docSize;

    @Column(name = "doc_dwg_num", columnDefinition = "int(11) DEFAULT '0' COMMENT 'DWG文档数量'")
    private Integer docDwgNum;

    @Column(name = "doc_pdf_num", columnDefinition = "int(11) DEFAULT '0' COMMENT 'PDF文档数量'")
    private Integer docPdfNum;

    @Column(name = "doc_word_num", columnDefinition = "int(11) DEFAULT '0' COMMENT 'WORD文档数量'")
    private Integer docWordNum;

    @Column(name = "doc_excel_num", columnDefinition = "int(11) DEFAULT '0' COMMENT 'EXCEL文档数量'")
    private Integer docExcelNum;

    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
    private String companyId;

    @Column(name = "doc_other_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '其他文档数量'")
    private Integer docOtherNum;

}

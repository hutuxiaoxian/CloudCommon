package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 项目表相关接口<br>
 *
 * @className: ProjectEntity
 * @package: com.bjblackhole.basicdata
 * @author: zhus
 * @date: 2020-07-02 18:08:45
 */
@Data
//@Entity
@Table(name = "np_project", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true)
})
@TableName("np_project")
public class ProjectEntity extends BaseEntity {

    @Column(name = "display_order", columnDefinition = "int(11) COMMENT '显示顺序'")
    private Integer displayOrder;

    @Column(name = "project_actual_end_time", columnDefinition = "datetime COMMENT '实际完工时间'")
    private String projectActualEndTime;

    @Column(name = "project_actual_start_time", columnDefinition = "datetime COMMENT '实际开工时间'")
    private String projectActualStartTime;

    @Column(name = "project_building_height", columnDefinition = "varchar(90) COMMENT '建筑高度'")
    private String projectBuildingHeight;

    @Column(name = "project_category", columnDefinition = "varchar(50) COMMENT '项目类型'")
    private String projectCategory;

    @Column(name = "project_check_unit", columnDefinition = "varchar(150) COMMENT '监理单位'")
    private String projectCheckUnit;

    @Column(name = "project_construction_model", columnDefinition = "varchar(90) COMMENT '承建模式'")
    private String projectConstructionModel;

    @Column(name = "project_construction_unit", columnDefinition = "varchar(150) COMMENT '建设单位'")
    private String projectConstructionUnit;

    @Column(name = "project_contract_price", columnDefinition = "varchar(90) COMMENT '合同金额'")
    private String projectContractPrice;

    @Column(name = "project_desc", columnDefinition = "text COMMENT '项目描述'")
    private String projectDesc;

    @Column(name = "project_design_unit", columnDefinition = "varchar(150) COMMENT '设计单位'")
    private String projectDesignUnit;

    @Column(name = "project_img", columnDefinition = "varchar(255) COMMENT '项目图片'")
    private String projectImg;

    @Column(name = "project_imgs", columnDefinition = "text COMMENT '项目效果图'")
    private String projectImgs;

    @Column(name = "project_implement_technology", columnDefinition = "varchar(50) COMMENT '施工技术'")
    private String projectImplementTechnology;

    @Column(name = "project_implement_unit", columnDefinition = "varchar(150) COMMENT '施工单位'")
    private String projectImplementUnit;

    @Column(name = "project_investment_subject", columnDefinition = "varchar(150) COMMENT '项目投资主体'")
    private String projectInvestmentSubject;

    @Column(name = "project_location", columnDefinition = "varchar(300) COMMENT '项目地址'")
    private String projectLocation;

    @Column(name = "project_name", columnDefinition = "varchar(90) COMMENT '项目名'")
    private String projectName;

    @Column(name = "project_plan_end_time", columnDefinition = "datetime COMMENT '计划完工时间'")
    private String projectPlanEndTime;

    @Column(name = "project_plan_start_time", columnDefinition = "datetime COMMENT '计划开工时间'")
    private String projectPlanStartTime;

    @Column(name = "project_plan_work_day", columnDefinition = "int(11) DEFAULT '0' COMMENT '计划总工期'")
    private Integer projectPlanWorkDay;

    @Column(name = "project_scale", columnDefinition = "varchar(90) COMMENT '项目规模'")
    private String projectScale;

    @Column(name = "project_status", columnDefinition = "varchar(50) COMMENT '项目状态'")
    private String projectStatus;

    @Column(name = "project_structure_area", columnDefinition = "varchar(90) COMMENT '建筑面积'")
    private String projectStructureArea;

    @Column(name = "project_used_area", columnDefinition = "varchar(90) COMMENT '用地面积'")
    private String projectUsedArea;

    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '企业id'")
    private String companyId;

    @Column(name = "engine_project_id", columnDefinition = "varchar(50) COMMENT '引擎方的项目id'")
    private String engineProjectId;

    @Column(name = "project_actual_work_day", columnDefinition = "int(11) DEFAULT '0' COMMENT '实际总工期'")
    private Integer projectActualWorkDay;


    @Column(name = "project_engine_model_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '模型数量'")
    private Integer projectEngineModelNum;

    @Column(name = "project_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '项目数量'")
    private Integer projectNum;

    @Column(name = "project_tag", columnDefinition = "varchar(50) COMMENT '项目标签（单项目，集群项目）'")
    private String projectTag;

    @Column(name = "project_engine_model_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '模型大小'")
    private Long projectEngineModelSize;

    @Column(name = "project_show", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '项目展示0，1'")
    private Integer projectShow;

}

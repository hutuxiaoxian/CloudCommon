package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 系统部门表相关接口<br>
 *
 * @className: SysDeptEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:40
 */
@Data
//@Entity
@Table(name = "np_sys_dept", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_project_id", columnList = "project_id"),
        @Index(name = "index_company_id", columnList = "company_id")
})
@TableName("np_sys_dept")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_dept", comment = "系统部门表")
public class SysDeptEntity extends BaseEntity {
    @Column(name = "dept_desc", columnDefinition = "varchar(250) COMMENT '部门描述'")
    private String deptDesc;

    @Column(name = "dept_name", columnDefinition = "varchar(50) COMMENT '部门名称'")
    private String deptName;

    @Column(name = "dept_status", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '部门状态:0正常,1停用'")
    private Integer deptStatus;

    @Column(name = "dept_type", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '部门分类:0 默认,1非默认'")
    private Integer deptType;

    @Column(name = "display_order", columnDefinition = "int(11) DEFAULT '0' COMMENT '显示顺序'")
    private Integer displayOrder = 0;

    @Column(name = "parent_id", columnDefinition = "bigint(20) COMMENT '父级部门id,为-1则代表是一级子目录'")
    private String parentId;

    @Column(name = "project_id", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '项目 id'")
    private String projectId;

    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司 id'")
    private String companyId;

}

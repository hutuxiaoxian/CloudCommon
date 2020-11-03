package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 系统角色表相关接口<br>
 * @className: SysRoleEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:40
 */
@Data
//@Entity
@Table(name = "np_sys_role", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "company_id", columnList = "company_id")
})
@TableName("np_sys_role")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_role", comment = "系统角色表")
public class SysRoleEntity extends BaseEntity {
    @Column(name = "company_id", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '公司id'")
    private String companyId;

    @Column(name = "role_desc", columnDefinition = "varchar(255) COMMENT '角色描述'")
    private String roleDesc;

    @Column(name = "role_name", columnDefinition = "varchar(40) COMMENT '角色名'")
    private String roleName;

    @Column(name = "is_default", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否是默认角色 用于星云企业初始化有几个初始角色 0 默认 1 非默认'")
    private Integer isDefault;

    @Column(name = "show_type", columnDefinition = "char(1) DEFAULT 'A' COMMENT '区分角色类型 A 星云平台 B 星云公司 C 星云公司项目'")
    private String showType;

    @Column(name = "statue", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '角色状态 0 可用 1 不可用'")
    private Integer statue;

    @Column(name = "data_scope", columnDefinition = "char(1) COMMENT '数据权限 A 全部数据权限 B 已加入项目 C 自定义数据权'")
    private String dataScope;

    @Column(name = "role_code", columnDefinition = "varchar(10) COMMENT '默认角色分类 A 项目超级管理员 B 普通管理员'")
    private String roleCode;
}


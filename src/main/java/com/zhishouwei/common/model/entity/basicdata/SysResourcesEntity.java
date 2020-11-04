package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 系统资源表相关接口<br>
 *
 * @className: SysResourcesEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:40
 */
@Data
//@Entity
@Table(name = "np_sys_resources", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "parent_id", columnList = "parent_id"),
})
@TableName("np_sys_resources")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_resources", comment = "系统资源表")
public class SysResourcesEntity extends BaseEntity {
    @Column(name = "resources_name", columnDefinition = "varchar(50) COMMENT '资源名称'")
    private String resourcesName;

    @Column(name = "display_order", columnDefinition = "int(11) DEFAULT '0' COMMENT '显示顺序'")
    private Integer displayOrder;

    @Column(name = "parent_id", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '父菜单id'")
    private String parentId;

    @Column(name = "path", columnDefinition = "varchar(100) COMMENT '路由地址'")
    private String path;

    @Column(name = "component", columnDefinition = "varchar(100) COMMENT '组件路径'")
    private String component;

    @Column(name = "is_frame", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）'")
    private Integer isFrame;

    @Column(name = "no_cache", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '是否缓存（0不缓存1缓存）'")
    private Integer noCache;

    @Column(name = "resources_status",
            columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '资源状态（0显示 1隐藏）'")
    private Integer resourcesStatus;

    @Column(name = "resources_type", columnDefinition = "tinyint(1) COMMENT '资源类型（0 目录 1菜单 2按钮）'")
    private Integer resourcesType;

    @Column(name = "perms", columnDefinition = "varchar(50) COMMENT '权限标识'")
    private String perms;

    @Column(name = "icon", columnDefinition = "varchar(150) COMMENT '菜单图标'")
    private String icon;

    @Column(name = "remark", columnDefinition = "varchar(200) COMMENT '备注'")
    private String remark;

    @Column(name = "remark_show", columnDefinition = "varchar(200) COMMENT '备注展示'")
    private String remarkShow;

    @Column(name = "parent_id_show", columnDefinition = "varchar(200) DEFAULT '' COMMENT '父菜单id展示'")
    private String parentIdShow;

    @Column(name = "parent_id_use", columnDefinition = "varchar(50) DEFAULT '' COMMENT '父菜单id使用'")
    private String parentIdUse;

    @Column(name = "show_type",
            columnDefinition = "tinyint(1) COMMENT '区分资源类型 0 项目可见 1 公司可见 2 平台可见 '")
    private Integer showType;

    @Column(name = "default_type",
            columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '区分是否是默认权限 0 默认 1 非默认'")
    private Integer defaultType;

    @Column(name = "show_order",
            columnDefinition = "int(2) DEFAULT null COMMENT '显示排序'")
    private Integer showOrder;
}


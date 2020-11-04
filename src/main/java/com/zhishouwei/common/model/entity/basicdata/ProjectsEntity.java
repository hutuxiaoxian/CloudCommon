package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @description: 集群项目-单项目关系表
 * @author： zhus
 * @version: 1.0
 * @date: 2020/6/30 15:29
 */
@Data
//@Entity
@Table(name = "np_projects", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true)
})
//@org.hibernate.annotations.Table(appliesTo = "np_projects", comment = "集群项目-单项目关系表")
@TableName(value = "np_projects")
public class ProjectsEntity extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", columnDefinition = "bigint(20) Comment '主键id'")
//    @TableId(type = IdType.AUTO)
//    private Long id;

    @Column(name = "projects_id", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '集群项目主键id'")
    private String projectsId;

    @Column(name = "project_id", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '单项目主键id'")
    private String projectId;

    @Column(name = "is_hide", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否隐藏 0 :显示  1：隐藏'")
    private Boolean isHide;
}


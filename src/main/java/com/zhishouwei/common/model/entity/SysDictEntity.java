package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 字典表相关接口<br>
 *
 * @className: SysDictEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 16:52:01
 */
@Data
//@Entity
@Table(name = "np_sys_dict", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_parent_id", columnList = "parent_id"),
        @Index(name = "index_project_id", columnList = "project_id"),
        @Index(name = "index_dict_type", columnList = "dict_type")
})
@TableName("np_sys_dict")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_dict", comment = "字典表")
public class SysDictEntity extends BaseEntity {

    @Column(name = "dict_label", columnDefinition = "varchar(40) DEFAULT '' COMMENT '字典标签'")
    private String dictLabel;

    @Column(name = "dict_sort", columnDefinition = "int(11) DEFAULT '1' COMMENT '字典排序'")
    private Integer dictSort;

    @Column(name = "dict_value", columnDefinition = "varchar(50) DEFAULT '' COMMENT '字典值'")
    private String dictValue;

    @Column(name = "dict_type", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '字典类别 1：父分类 2：子分类'")
    private Integer dictType;
    @Column(name = "dict_code", columnDefinition = "varchar(40) COMMENT '字段父分类code'")
    private String dictCode;
    @Column(name = "parent_id", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '上级id'")
    private String parentId;

    @Column(name = "project_id", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '项目id'")
    private String projectId;

    @Column(name = "remark", columnDefinition = "varchar(100) COMMENT '备注'")
    private String remark;

}


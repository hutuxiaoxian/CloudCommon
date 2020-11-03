package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 页码
     */
    @TableField(exist = false)
    private Integer page;

    /**
     * 页面大小
     */
    @TableField(exist = false)
    private Integer size;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP Comment '创建时间'")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;

    @Column(name = "create_user_id", columnDefinition = "varchar(50) Comment '创建人id'")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private String createUserId;

    @Column(name = "create_user_name", columnDefinition = "varchar(50) Comment '创建人'")
    @TableField(value = "create_user_name", fill = FieldFill.INSERT)
    private String createUserName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP Comment '更新时间'")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

    @Column(name = "update_user_id", columnDefinition = "varchar(50) Comment '更新人id'")
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;

    @Column(name = "update_user_name", columnDefinition = "varchar(50) Comment '更新人'")
    @TableField(value = "update_user_name", fill = FieldFill.INSERT_UPDATE)
    private String updateUserName;

    @Column(name = "is_delete", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志 0 :未删除  1：已删除'")
    @TableLogic
    private String isDelete;
}

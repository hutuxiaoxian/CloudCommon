package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/4/3 10:34
 */

@Data
public class IntBaseMongoEntity implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP Comment '创建时间'")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @Field("create_time")
    private String createTime;

    @Column(name = "create_user_name", columnDefinition = "varchar(50) Comment '创建人'")
    @TableField(value = "create_user_name", fill = FieldFill.INSERT)
    @Field("create_user_name")
    private String createUserName;

    @Column(name = "create_user_id", columnDefinition = "varchar(50) Comment '创建人id'")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    @Field("create_user_id")
    private String createUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP Comment '更新时间'")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @Field("update_time")
    private String updateTime;

    @Column(name = "update_user_name", columnDefinition = "varchar(50) Comment '更新人'")
    @TableField(value = "update_user_name", fill = FieldFill.INSERT_UPDATE)
    @Field("update_user_name")
    private String updateUserName;

    @Column(name = "update_user_id", columnDefinition = "varchar(50) Comment '更新人id'")
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    @Field("update_user_id")
    private String updateUserId;

    @Column(name = "is_delete", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志 0 :未删除  1：已删除'")
    @TableLogic
    @Field("is_delete")
    private String isDelete = "0";

}

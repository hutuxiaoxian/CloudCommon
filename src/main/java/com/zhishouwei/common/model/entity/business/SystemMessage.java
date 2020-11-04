package com.zhishouwei.common.model.entity.business;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 系统消息
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/7/17 18:48
 */
@Data
@Entity
@Table(name = "system_message", indexes = {
        @Index(name = "index_list", columnList = "user_id")
})
@TableName(value = "system_message")
public class SystemMessage extends BaseEntity {

//    @Id
//    @Column(name = "id", columnDefinition = "varchar(50) Comment '主键id'")
//    @TableId(type = IdType.ASSIGN_UUID)
//    private String id;

    @Column(name = "user_id", columnDefinition = "varchar(50) Comment '用户id'")
    private String userId;

    @Column(name = "content_list", columnDefinition = "text Comment '列表内容'")
    private String contentList;

    @Column(name = "organization", columnDefinition = "varchar(50) Comment '组织'")
    private String organization;

    @Column(name = "status", columnDefinition = "int(2) Comment '状态 1 提示 2 已读 3 忽略 4 删除'")
    private Integer status;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @Column(name = "create_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP Comment '创建时间'")
//    @TableField(value = "create_time", fill = FieldFill.INSERT)
//    private String createTime;

}

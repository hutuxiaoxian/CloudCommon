package com.zhishouwei.common.model.entity.pan;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

/**
 * 相关接口<br>
 *
 * @className: FileDeleteEntity
 * @package: com.bjblackhole.pan
 * @author: zhus
 * @date: 2020-07-17 15:59:04
 */
@Data
@Entity
@Table(name = "np_file_delete", indexes = {
        @Index(name = "index_id", columnList = "id")
})
@TableName("np_file_delete")
@Document(collection = "np_file_delete")
public class FileDeleteEntity {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.INPUT)
    @org.springframework.data.annotation.Id
    private String id;

    @Column(name = "create_user_name", columnDefinition = "varchar(50) Comment '创建人'")
    @TableField(value = "create_user_name", fill = FieldFill.INSERT)
    @Field("create_user_name")
    private String createUserName;

    @Column(name = "create_user_id", columnDefinition = "varchar(50) Comment '创建人id'")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    @Field("create_user_id")
    private String createUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "delete_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '删除时间'")
    @Field("delete_time")
    private String deleteTime;

    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
    @Field("company_id")
    private String companyId;

    @Column(name = "file_id", columnDefinition = "varchar(100) COMMENT 'fastDFS中文件id'")
    @Field("file_id")
    private String fileId;

    @Column(name = "file_md5", columnDefinition = "varchar(50) COMMENT '文件md5'")
    @Field("file_md5")
    private String fileMd5;

    @Column(name = "file_name", columnDefinition = "varchar(60) COMMENT '文件名字'")
    @Field("file_name")
    private String fileName;

    @Column(name = "file_size", columnDefinition = "bigint(20) COMMENT '文件大小'")
    @Field("file_size")
    private String fileSize;

    @Column(name = "file_suffix", columnDefinition = "varchar(20) COMMENT '文件后缀'")
    @Field("file_suffix")
    private String fileSuffix;

    @Column(name = "file_type", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '文件标识:0文件夹;1文件'")
    @Field("file_type")
    private Integer fileType;

    @Column(name = "parent_id", columnDefinition = "bigint(20) COMMENT '父级文件夹主键id,最顶级-1'")
    @Field("parent_id")
    private String parentId;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    @Field("project_id")
    private String projectId;

}

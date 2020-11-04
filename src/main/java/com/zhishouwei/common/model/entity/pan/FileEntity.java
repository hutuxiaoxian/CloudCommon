package com.zhishouwei.common.model.entity.pan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.IntBaseMongoEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

/**
 * 资料文件表相关接口<br>
 *
 * @className: FileEntity
 * @package: com.bjblackhole.pan
 * @author: zhus
 * @date: 2020-07-09 13:58:16
 */
@Data
@Entity
@Table(name = "np_file", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_parent_id", columnList = "parent_id"),
        @Index(name = "index_project_id", columnList = "project_id")
})
@TableName("np_file")
@Document(collection = "np_file")
public class FileEntity extends IntBaseMongoEntity {

    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    @org.springframework.data.annotation.Id
    private String id;

    @Column(name = "file_name", columnDefinition = "varchar(60) COMMENT '文件名字'")
    @Field("file_name")
    private String fileName;

    @Column(name = "file_suffix", columnDefinition = "varchar(20) COMMENT '文件后缀'")
    @Field("file_suffix")
    private String fileSuffix;

    @Column(name = "file_id", columnDefinition = "varchar(100) COMMENT 'fastDFS中文件id'")
    @Field("file_id")
    private String fileId;

    @Column(name = "file_size", columnDefinition = "bigint(20) COMMENT '文件大小'")
    @Field("file_size")
    private String fileSize;

    @Column(name = "file_md5", columnDefinition = "varchar(50) COMMENT '文件md5'")
    @Field("file_md5")
    private String fileMd5;

    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
    @Field("company_id")
    private String companyId;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    @Field("project_id")
    private String projectId;

    @Column(name = "parent_id",
            columnDefinition = "bigint(20) COMMENT '父级文件夹主键id,资料首页最顶级-1,回收站首页最顶级0'")
    @Field("parent_id")
    private String parentId;

    @Column(name = "file_type", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '文件标识:0文件夹;1文件'")
    @Field("file_type")
    private Integer fileType;

    @Column(name = "is_save", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '保存标志 0 :不保存  1：保存'")
    @Field("is_save")
    private String isSave = "1";

}

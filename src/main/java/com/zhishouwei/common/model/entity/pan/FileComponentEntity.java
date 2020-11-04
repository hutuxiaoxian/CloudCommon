package com.zhishouwei.common.model.entity.pan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资料文件和引擎构件关系表相关接口<br>
 *
 * @className: FileComponentEntity
 * @package: com.bjblackhole.pan
 * @author: zhus
 * @date: 2020-07-09 14:32:33
 */
@Data
@Entity
@Table(name = "np_file_component", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_file_id", columnList = "file_id"),
        @Index(name = "index_component_id", columnList = "component_id"),
        @Index(name = "index_project_id", columnList = "project_id")
})
@TableName("np_file_component")
@Document(collection = "np_file_component")
public class FileComponentEntity implements Serializable {
    private static final long serialVersionUID = -8989750198771499134L;
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    @org.springframework.data.annotation.Id
    private String id;

    @Column(name = "file_id", columnDefinition = "bigint(20) COMMENT '资料文件主键id'")
    @Field("file_id")
    private String fileId;

    @Column(name = "component_id", columnDefinition = "bigint(20) COMMENT '引擎构件主键id'")
    @Field("component_id")
    private String componentId;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    @Field("project_id")
    private String projectId;

    @Column(name = "is_delete", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志 0 :未删除  1：已删除'")
    @TableLogic
    @Field("is_delete")
    private String isDelete = "0";

    public FileComponentEntity() {
    }

    public FileComponentEntity(String fileId, String componentId, String projectId, String isDelete) {
        this.fileId = fileId;
        this.componentId = componentId;
        this.projectId = projectId;
        this.isDelete = isDelete;
    }
}

package com.zhishouwei.common.model.entity.pan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户收藏资源文件表相关接口<br>
 *
 * @className: FileFavoriteEntity
 * @package: com.bjblackhole.pan
 * @author: zhus
 * @date: 2020-07-09 15:21:02
 */
@Data
@Entity
@Table(name = "np_file_favorite", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_user_id", columnList = "user_id"),
        @Index(name = "index_project_id", columnList = "project_id")
})
@TableName("np_file_favorite")
@Document(collection = "np_file_favorite")
public class FileFavoriteEntity implements Serializable {
    private static final long serialVersionUID = -2552427540203785025L;
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    @org.springframework.data.annotation.Id
    private String id;

    @Column(name = "file_id", columnDefinition = "bigint(20) COMMENT '资料文件主键id'")
    @Field("file_id")
    private String fileId;

    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户id'")
    @Field("user_id")
    private String userId;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    @Field("project_id")
    private String projectId;
}

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
 * 标签表相关接口<br>
 *
 * @className: TagEntity
 * @package: com.bjblackhole.pan
 * @author: zhus
 * @date: 2020-07-09 14:32:02
 */
@Data
@Entity
@Table(name = "np_tag", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_project_id", columnList = "project_id"),
        @Index(name = "index_tag_name", columnList = "tag_name")
})
@TableName("np_tag")
@Document(collection = "np_tag")
public class TagEntity extends IntBaseMongoEntity {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    @org.springframework.data.annotation.Id
    private String id;

    @Column(name = "tag_name", columnDefinition = "varchar(60) COMMENT '标签名字'")
    @Field("tag_name")
    private String tagName;

    @Column(name = "tag_color", columnDefinition = "varchar(10) COMMENT '标签颜色'")
    @Field("tag_color")
    private String tagColor;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    @Field("project_id")
    private String projectId;

}

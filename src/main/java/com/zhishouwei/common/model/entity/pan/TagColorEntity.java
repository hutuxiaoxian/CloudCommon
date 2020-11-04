package com.zhishouwei.common.model.entity.pan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @author： zhus
 * @version: 1.0
 * @date: 2020/9/6 10:17
 */
@Data
@Entity
@Table(name = "np_tag_color", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_tag_color", columnList = "tag_color")
})
@TableName("np_tag_color")
public class TagColorEntity implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @Column(name = "tag_color", columnDefinition = "varchar(10) COMMENT '标签颜色'")
    private String tagColor;
}

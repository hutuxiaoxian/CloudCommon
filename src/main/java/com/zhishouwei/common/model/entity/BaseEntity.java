package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    @TableField(exist = false)
    private String splitTableId;
    @TableId(type = IdType.AUTO)
    private Integer id;
//    @TableId(type = IdType.ASSIGN_UUID)
//    private String id;
//    @TableField("create_time")
//    private Date createTime;
//    @TableField("update_time")
//    private Date updateTime;


    public String tableName() {
        String name = null;
        TableName tableName = getClass().getAnnotation(TableName.class);
        if (ObjectUtils.isNotEmpty(tableName)) {
            name = tableName.value();
        }
        return name;
    }
}

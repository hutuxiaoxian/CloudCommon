package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    @TableField(exist = false)
    private String splitTableId;
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
//    @TableField("create_time")
//    private Date createTime;
//    @TableField("update_time")
//    private Date updateTime;


    public String tableName() {
        TableName tableName = getClass().getAnnotation(TableName.class);
        return tableName.value();
    }
}

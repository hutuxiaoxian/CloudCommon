package com.zhishouwei.common.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/4/3 10:34
 */


@Data
public class BaseMongoEntity implements Serializable {
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field("create_time")
    private Date createTime;

    //创建人id
    @Field("create_user_id")
    private String createUserId;

    //创建人
    @Field("create_user_name")
    private String createUserName;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field("update_time")
    private Date updateTime;

    //更新人id
    @Field("update_user_id")
    private String updateUserId;

    //更新人
    @Field("update_user_name")
    private String updateUserName;

    //逻辑删除标志 0 :未删除  1：已删除
    @Field("is_delete")
    private String isDelete = "0";
}

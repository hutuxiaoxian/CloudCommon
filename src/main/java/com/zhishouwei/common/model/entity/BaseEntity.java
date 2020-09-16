package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//@Entity
@Data
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid", strategy = GenerationType.IDENTITY)
    @TableId
    private String id;

    private Date currentTime;
    private Date updateTime;
}
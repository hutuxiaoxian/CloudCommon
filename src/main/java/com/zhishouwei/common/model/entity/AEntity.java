package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "a")
@TableName("a")
public class AEntity extends BaseEntity {
    private String content;
}

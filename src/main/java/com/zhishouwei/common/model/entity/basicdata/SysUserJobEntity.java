package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * 用户岗位表相关接口<br>
 *
 * @className: SysUserJobEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:41
 */
@Data
//@Entity
@Table(name = "np_sys_user_job", indexes = {
        @Index(name = "index_job_id", columnList = "job_id"),
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_user_id", columnList = "user_id"),
        @Index(name = "index_project_id", columnList = "project_id"),
})
@TableName("np_sys_user_job")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_user_job", comment = "用户岗位表")
public class SysUserJobEntity extends BaseEntity {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    private String id;
    @Column(name = "job_id", columnDefinition = "varchar(50) COMMENT '岗位ID'")
    private String jobId;

    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户id'")
    private String userId;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    private String projectId;


}


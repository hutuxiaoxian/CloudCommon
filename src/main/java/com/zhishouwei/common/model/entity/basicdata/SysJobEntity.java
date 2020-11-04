package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 岗位表相关接口<br>
 *
 * @className: SysJobEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:41
 */
@Data
//@Entity
@Table(name = "np_sys_job", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "project_id", columnList = "project_id")
})
@TableName("np_sys_job")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_job", comment = "岗位表")
public class SysJobEntity extends BaseEntity {
    @Column(name = "job_name", columnDefinition = "varchar(50) COMMENT '岗位名称'")
    private String jobName;

    @Column(name = "job_sort", columnDefinition = "int(11)  DEFAULT '0' COMMENT '排序'")
    private String jobSort;

    @Column(name = "job_type", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '岗位类别 0:非默认 1：默认'")
    private Integer jobType;

    @Column(name = "project_id", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '项目id'")
    private String projectId;

}


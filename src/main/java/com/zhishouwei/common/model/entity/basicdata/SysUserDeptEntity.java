package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户和部门关联表相关接口<br>
 *
 * @className: SysUserDeptEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:40
 */
@Data
//@Entity
@Table(name = "np_sys_user_dept", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_user_id", columnList = "user_id"),
        @Index(name = "index_dept_id", columnList = "dept_id"),
})
@TableName("np_sys_user_dept")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_user_dept", comment = "用户和部门关联表")
public class SysUserDeptEntity extends BaseEntity {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    private String id;
    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户ID'")
    private String userId;
    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    private String projectId;
    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
    private String companyId;
    @Column(name = "dept_id", columnDefinition = "bigint(20) COMMENT '部门id'")
    private String deptId;

}


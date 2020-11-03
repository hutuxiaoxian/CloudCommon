package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

/**
 * 资源菜单管理表相关接口<br>
 *
 * @className: SysUserRoleEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:41
 */
@Data
//@Entity
@Table(name = "np_sys_user_role", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_role_id", columnList = "role_id"),
        @Index(name = "index_user_id", columnList = "user_id"),
        @Index(name = "index_project_id", columnList = "project_id"),
        @Index(name = "index_company_id", columnList = "company_id")
})
@TableName("np_sys_user_role")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_user_role", comment = "资源菜单管理表")
public class SysUserRoleEntity extends BaseEntity{
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
    @TableId(type = IdType.AUTO)
    private String id;
    @Column(name = "role_id", columnDefinition = "varchar(50) COMMENT '角色ID'")
    private String roleId;

    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户id'")
    private String userId;

    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    private String projectId;

    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
    private String companyId;

    @Column(name = "type", columnDefinition = "tinyint(1) COMMENT '区分关系类型 0 项目 1 公司 2 创建者 '")
    private Integer type;

    @Column(name = "is_delete", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志 0 :未删除  1：已删除'")
    @TableLogic
    private String isDelete;

}

package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户数据权限表相关接口<br>
 * @className: SysUserDataScopeEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-08 15:51:02
 */
@Data
//@Entity
@Table(name = "np_sys_user_data_scope", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "project_id", columnList = "project_id"),
        @Index(name = "company_id", columnList = "company_id"),
        @Index(name = "role_id", columnList = "role_id"),
})
@TableName("np_sys_user_data_scope")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_user_data_scope", comment = "用户数据权限表")
public class SysUserDataScopeEntity extends BaseEntity {
            @Id
            @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
            @TableId(type = IdType.AUTO)
            private String id;
            @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
            private String companyId;
        
            @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
            private String projectId;
        
            @Column(name = "role_id", columnDefinition = "varchar(50) COMMENT '角色ID'")
            private String roleId;
        
            @Column(name = "type", columnDefinition = "tinyint(1) COMMENT '区分关系类型 0 项目 1 公司 2 资料目录'")
            private Integer type;
        
            @Column(name = "directory_id", columnDefinition = "varchar(50) COMMENT '资料目录id'")
            private String directoryId;
        
    
}
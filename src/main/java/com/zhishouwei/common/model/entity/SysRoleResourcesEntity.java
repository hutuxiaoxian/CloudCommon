package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;


/**
 * 资源菜单管理表相关接口<br>
 * @className: SysRoleResourcesEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-01 15:50:41
 */
@Data
//@Entity
@Table(name = "np_sys_role_resources", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_roleId", columnList = "role_id"),
        @Index(name = "index_resources_id", columnList = "resources_id")
})
@TableName("np_sys_role_resources")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_role_resources", comment = "资源菜单管理表")
public class SysRoleResourcesEntity extends BaseEntity {
//            @Id
//            @Column(name = "id", columnDefinition = "bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id'")
//            @TableId(type = IdType.AUTO)
//            private String id;
            @Column(name = "role_id", columnDefinition = "varchar(50) COMMENT '角色ID'")
            private String roleId;

            @Column(name = "resources_id", columnDefinition = "varchar(50) COMMENT '资源id'")
            private String resourcesId;


}



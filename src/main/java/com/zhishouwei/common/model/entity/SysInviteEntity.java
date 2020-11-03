package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 邀请记录表相关接口<br>
 * @className: SysInviteEntity
 * @package: com.bjblackhole.basicdata
 * @author: 曾维录
 * @date: 2020-07-11 17:02:32
 */
@Data
//@Entity
@Table(name = "np_sys_invite", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_project_id", columnList = "project_id"),
        @Index(name = "index_company_id", columnList = "company_id")
})
@TableName("np_sys_invite")
//@org.hibernate.annotations.Table(appliesTo = "np_sys_invite", comment = "邀请记录表")
public class SysInviteEntity extends BaseEntity {
            @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
            private String projectId;
        
            @Column(name = "project_name", columnDefinition = "varchar(50) COMMENT '项目名'")
            private String projectName;
        
            @Column(name = "expiration_date_num", columnDefinition = "int(11) DEFAULT '7' COMMENT '有效期限'")
            private Integer expirationDateNum;
        
            @Column(name = "expiration_date_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '有效最后时间'")
            private String expirationDateTime;
        
            @Column(name = "audit_type", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '审核方式 0:需要 1:不需要 '")
            private Integer auditType;
        
            @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '公司id'")
            private String companyId;
        
            @Column(name = "company_name", columnDefinition = "varchar(50) COMMENT '公司名'")
            private String companyName;
        
            @Column(name = "invite_user", columnDefinition = "text COMMENT '邀请指定人员'")
            private String inviteUser;
        
            @Column(name = "invite_link", columnDefinition = "varchar(150) COMMENT '邀请链接'")
            private String inviteLink;
        
    
}

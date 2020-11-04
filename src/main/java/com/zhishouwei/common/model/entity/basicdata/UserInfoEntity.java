package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @author sunsl
 * @version 1.0
 * @date 2020/4/3 10:29
 */
@Data
//@Entity
@Table(name = "np_user_info", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_user_id", columnList = "user_id")
})
//@org.hibernate.annotations.Table(appliesTo = "np_user_info", comment = "平台用户扩展信息表")
@TableName(value = "np_user_info")
public class UserInfoEntity extends BaseEntity {

    @Column(name = "headimgurl", columnDefinition = "varchar(255) COMMENT '用户头像'")
    private String headimgurl;

    @Column(name = "project_dept_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    private String projectDeptId;

    @Column(name = "project_number", columnDefinition = "int(11) COMMENT '项目个数'")
    private Integer projectNumber;

    @Column(name = "real_name", columnDefinition = "varchar(50) COMMENT '真实姓名'")
    private String realName;

    @Column(name = "default_role_id", columnDefinition = "varchar(50) COMMENT '最后一次登录role_id'")
    private String defaultRoleId;

    @Column(name = "default_project_id", columnDefinition = "varchar(50) COMMENT '最后一次登录项目id'")
    private String defaultProjectId;

    @Column(name = "default_project_tag", columnDefinition = "varchar(50) COMMENT '最后一次登录项目类型'")
    private String defaultProjectTag;

    @Column(name = "default_company_id", columnDefinition = "varchar(50) COMMENT '最后一次登录的企业id'")
    private String defaultCompanyId;

    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户id'")
    private String userId;


}

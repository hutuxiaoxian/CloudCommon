package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户和项目关联表相关接口<br>
 *
 * @className: UserProjectEntity
 * @package: com.bjblackhole.basicdata
 * @author: zhus
 * @date: 2020-07-06 11:03:02
 */
@Data
//@Entity
@Table(name = "np_user_project", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_user_id", columnList = "user_id"),
        @Index(name = "index_project_id", columnList = "project_id"),
        @Index(name = "index_create_time", columnList = "create_time")
})
@TableName("np_user_project")
public class UserProjectEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2328950928058547633L;


    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户ID'")
    private String userId;
    @Column(name = "invite_user_id", columnDefinition = "varchar(50) COMMENT '邀请用户ID'")
    private String inviteUserId;
    @Column(name = "project_id", columnDefinition = "varchar(50) COMMENT '项目id'")
    private String projectId;
    @Column(name = "source_type", columnDefinition = "tinyint(1) COMMENT '来源类型 0 被邀请 1 自己创建的'")
    private Integer sourceType;
    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '企业id'")
    private String companyId;
    @Column(name = "status", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '状态 0 未审核 1 审核通过 2 审核未通过'")
    private Integer status;



}

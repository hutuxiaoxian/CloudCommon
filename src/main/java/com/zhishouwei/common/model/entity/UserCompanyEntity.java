package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户和企业关联表相关接口<br>
 *
 * @className: UserCompanyEntity
 * @package: com.bjblackhole.basicdata
 * @author: zhus
 * @date: 2020-07-06 11:11:53
 */
@Data
//@Entity
@Table(name = "np_user_company", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true),
        @Index(name = "index_user_id", columnList = "user_id"),
        @Index(name = "index_company_id", columnList = "company_id")
})
@TableName("np_user_company")
public class UserCompanyEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2647281303816544952L;


    @Column(name = "user_id", columnDefinition = "varchar(50) COMMENT '用户ID'")
    private String userId;
    @Column(name = "company_id", columnDefinition = "varchar(50) COMMENT '企业id'")
    private String companyId;
    @Column(name = "source_type", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '来源类型 0 被邀请 1 自己创建的'")
    private Integer sourceType;
    @Column(name = "status", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '状态 0 未审核 1 审核通过 2 审核未通过'")
    private Integer status;

}

package com.zhishouwei.common.model.entity.basicdata;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 企业表相关接口<br>
 *
 * @className: CompanyEntity
 * @package: com.bjblackhole.basicdata
 * @author: zhus
 * @date: 2020-07-02 19:57:12
 */
@Data
//@Entity
@Table(name = "np_company", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true)
})
@TableName("np_company")
public class CompanyEntity extends BaseEntity {

    @Column(name = "company_desc", columnDefinition = "text COMMENT '企业描述'")
    private String companyDesc;

    @Column(name = "company_name", columnDefinition = "varchar(50) COMMENT '企业名称'")
    private String companyName;

    @Column(name = "company_nature", columnDefinition = "varchar(50) COMMENT '企业性质'")
    private String companyNature;

    @Column(name = "company_scale", columnDefinition = "varchar(20) COMMENT '企业规模'")
    private String companyScale;

    @Column(name = "company_service_usage_id", columnDefinition = "varchar(50) COMMENT '公司套餐使用情况id'")
    private String companyServiceUsageId;

    @Column(name = "display_order", columnDefinition = "int(11) COMMENT '显示顺序'")
    private Integer displayOrder;

    @Column(name = "service_config_id", columnDefinition = "varchar(50) COMMENT '公司服务套餐id'")
    private String serviceConfigId;

}

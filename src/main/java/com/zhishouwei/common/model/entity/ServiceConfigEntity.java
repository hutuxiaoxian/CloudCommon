package com.zhishouwei.common.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 系统服务配置表<br>
 *
 * @className: ServiceConfigPO
 * @package: com.bjblackhole.common.entity
 * @author: TR
 * @date: 2020/6/18 14:27
 */
@Data
//@Entity
@Table(name = "np_service_config", indexes = {
        @Index(name = "index_id", columnList = "id", unique = true)
})
@TableName("np_service_config")
//@org.hibernate.annotations.Table(appliesTo = "np_service_config", comment = "系统服务配置表")
public class ServiceConfigEntity extends BaseEntity {
    @Column(name = "project_num", columnDefinition = "int(11) DEFAULT '1' COMMENT '可建项目数'")
    private int projectNum;
    @Column(name = "project_model_num", columnDefinition = "int(11) DEFAULT '1' COMMENT '可导入模型数'")
    private int projectModelNum;
    @Column(name = "project_model_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '可导入模型大小'")
    private Long projectModelSize;
    @Column(name = "project_model_convert_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '模型转换数'")
    private int projectModelConvertNum;
    @Column(name = "cloud_disk_space_size", columnDefinition = "bigint(20) DEFAULT '0' COMMENT '云盘空间大小'")
    private Long cloudDiskSpaceSize;
    @Column(name = "valid_date_num", columnDefinition = "int(11) DEFAULT '0' COMMENT '有效天数'")
    private int validDateNum;
    @Column(name = "employee_count", columnDefinition = "int(11) DEFAULT '0' COMMENT '可加入成员数'")
    private int employeeCount;
    @Column(name = "service_name", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '套餐名或者服务名 as  leve 0'")
    private String serviceName;
    @Column(name = "service_aias", columnDefinition = "varchar(20) DEFAULT NULL COMMENT '套餐别名'")
    private String serviceAias;
    @Column(name = "service_money", columnDefinition = "decimal(10,2) DEFAULT '0.00' COMMENT '套餐金额或者服务金额'")
    private BigDecimal serviceMoney;
    @Column(name = "service_status", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '套餐状态 0 启用 1 禁用'")
    private int serviceStatus;
    @Column(name = "whether_default", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '是否为默认套餐 0 是 1 否'")
    private int whetherDefault;

}

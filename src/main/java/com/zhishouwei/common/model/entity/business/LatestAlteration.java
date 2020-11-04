package com.zhishouwei.common.model.entity.business;

import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 最新动态
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/15 17:00
 */
@Data
@Entity
@Table(name = "latest_alteration", indexes = {
        @Index(name = "index_list", columnList = "company_id,project_id,create_time")
})
public class LatestAlteration extends BaseEntity {

    @Column(name = "content_index", columnDefinition = "text Comment '内容（包含跳转信息的）'")
    private String contentIndex;

    @Column(name = "platform_id", columnDefinition = "varchar(50) Comment '平台id'")
    private String platformId;

    @Column(name = "company_id", columnDefinition = "varchar(50) Comment '企业id'")
    private String companyId;

    @Column(name = "project_id", columnDefinition = "varchar(50) Comment '项目id'")
    private String projectId;

    @Column(name = "organization", columnDefinition = "varchar(50) Comment '组织'")
    private String organization;

    @Column(name = "file_id", columnDefinition = "varchar(100) Comment 'fastDFS中文件id/pak的id'")
    private String fileId;

    @Column(name = "direct_url", columnDefinition = "varchar(100) Comment '跳转路由'")
    private String directUrl;

    @Column(name = "direct_param", columnDefinition = "varchar(100) Comment '跳转参数'")
    private String directParam;

}

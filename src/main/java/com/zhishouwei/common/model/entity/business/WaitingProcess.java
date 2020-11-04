package com.zhishouwei.common.model.entity.business;

import com.zhishouwei.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 待办事项
 *
 * @author sunsl
 * @version 1.0
 * @date 2020/6/17 18:58
 */

@Data
@Entity
@Table(name = "waiting_process", indexes = {
        @Index(name = "index_list", columnList = "project_id,create_time")
})
public class WaitingProcess extends BaseEntity {

    @Column(name = "type_name", columnDefinition = "varchar(10) Comment '类型名称'")
    private String typeName;

    @Column(name = "content_index", columnDefinition = "text Comment '工作台首页内容'")
    private String contentIndex;

    @Column(name = "content_list", columnDefinition = "text Comment '列表内容'")
    private String contentList;

    @Column(name = "scene_id", columnDefinition = "varchar(50) Comment '场景id'")
    private String sceneId;

    @Column(name = "organization", columnDefinition = "varchar(50) Comment '组织'")
    private String organization;

    @Column(name = "company_id", columnDefinition = "varchar(50) Comment '企业id'")
    private String companyId;

    @Column(name = "project_id", columnDefinition = "varchar(50) Comment '项目id'")
    private String projectId;

    @Column(name = "file_id", columnDefinition = "varchar(100) Comment 'fastDFS中文件id/pak的id'")
    private String fileId;

    @Column(name = "direct_url", columnDefinition = "varchar(100) Comment '跳转路由'")
    private String directUrl;

    @Column(name = "direct_param", columnDefinition = "varchar(100) Comment '跳转参数'")
    private String directParam;

    @Column(name = "is_pano", columnDefinition = "int Comment '判断是批注：1还是标记:2'")
    private Integer isPano;



}

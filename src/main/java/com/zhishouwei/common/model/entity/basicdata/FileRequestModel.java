package com.zhishouwei.common.model.entity.basicdata;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhus
 * @version 1.0
 * @date 2020/6/1 14:36
 */
@Data
public class FileRequestModel implements Serializable {
    private static final long serialVersionUID = -4799996374808375181L;
    /**
     * 文件id：group1/M00/00/00/wKgBCV7WAgmABYQQAAHTqfzc_AU638.png
     */
    private String fileId;
    /**
     * 文件ids：group1/M00/00/00/wKgBCV7WAgmABYQQAAHTqfzc_AU638.png
     */
    private List<String> fileIds;
    /**
     * 文件组：group1
     */
    private String group;
    /**
     * 文件名：api.png
     */
    private String fileName;
    /**
     * 文件md5
     */
    private String fileMd5;
    /**
     * 文件大小
     */
    private Long fileSize;
    /**
     * 企业id
     */
    private String companyId;
    /**
     * 是否在线预览：true false
     */
    private Boolean isOnline;
}

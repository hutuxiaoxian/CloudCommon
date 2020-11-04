package com.zhishouwei.common.model.entity.basicdata;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 文件模型
 * @author： zhus
 * @version: 1.0
 * @date: 2020/6/23 18:50
 */
@Data
public class FileModel implements Serializable {

    private static final long serialVersionUID = -7608339777548675101L;
    /**
     * 文件id：group1/M00/00/00/wKgBCV7WAgmABYQQAAHTqfzc_AU638.png
     */
    private String fileId;

    /**
     * 文件组：group1
     */
    private String group;

    /**
     * 文件名：api.png
     */
    private String fileName;

    /**
     * 文件后缀：png
     */
    private String fileSuffix;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件MD5
     */
    private String fileMd5;

    public FileModel() {
    }

    public FileModel(String fileId, String group, String fileName, String fileSuffix, String fileMd5, Long fileSize) {
        this.fileId = fileId;
        this.group = group;
        this.fileName = fileName;
        this.fileSuffix = fileSuffix;
        this.fileMd5 = fileMd5;
        this.fileSize = fileSize;
    }
}

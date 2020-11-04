package com.zhishouwei.common.model.entity.basicdata;

import com.zhishouwei.common.model.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 资料文件表<br>
 *
 * @className: FilePojo
 * @package: com.bjblackhole.pan.pojo
 * @author: zhus
 * @date: 2020-07-09 13:58:16
 */
@Data
public class FilePojo extends BaseModel implements Serializable {
    /*
     * 创建时间
     */
    private String createTime;
    /*
     * 创建人
     */
    private String createUserName;
    /*
     * 创建人id
     */
    private String createUserId;
    /*
     * 更新时间
     */
    private String updateTime;
    /*
     * 更新人
     */
    private String updateUserName;
    /*
     * 更新人id
     */
    private String updateUserId;
    /*
     * 文件名字
     */
    private String fileName;
    /*
     * 文件后缀
     */
    private String fileSuffix;
    /*
     * fastDFS中文件id
     */
    private String fileId;
    /*
     * 文件大小
     */
    private String fileSize;
    /*
     * 文件md5
     */
    private String fileMd5;
    /*
     * 公司id
     */
    private String companyId;
    /*
     * 项目id
     */
    private String projectId;
    /*
     * 父级文件夹主键id,资料首页最顶级-1,回收站首页最顶级0
     */
    private String parentId;
    /*
     * 文件标识:0文件夹;1文件
     */
    private Integer fileType;
    /*
     * 逻辑删除标志 0 :未删除  1：已删除
     */
    private Integer isDelete;
    /*
     * 保存标志 0 :不保存  1：保存
     */
    private Integer isSave;
    /*
     * 资料文件ids
     */
    private List<String> ids;
    /*
     * 标签列表
     */
    private List<TagPojo> tags;
    /*
     * 标签列表ids
     */
    private List<String> tagIds;
    /*
     * 构件ids
     */
    private List<String> componentIds;
    /*
     * 是否被收藏 0:收藏，1:不收藏
     */
    private Integer isFavorite;
    /*
     * 搜索内容，文件名，后缀名
     */
    private String content;
    /*
     * 子文件
     */
    private List<FilePojo> children;
    /*
     * 是否有子文件
     */
    private Boolean hasChildren;
}

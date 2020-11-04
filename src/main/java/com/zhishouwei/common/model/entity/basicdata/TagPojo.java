package com.zhishouwei.common.model.entity.basicdata;

import com.zhishouwei.common.model.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 标签表<br>
 *
 * @className: TagPojo
 * @package: com.bjblackhole.pan.pojo
 * @author: zhus
 * @date: 2020-07-09 14:32:02
 */
@Data
public class TagPojo extends BaseModel implements Serializable {

    /*
     * 创建时间
     */
    private String createTime;
    /*
     * 创建人
     */
    private String createUserName;
    /*
     * 更新时间
     */
    private String updateTime;
    /*
     * 更新人
     */
    private String updateUserName;
    /*
     * 标签名字
     */
    private String tagName;
    /*
     * 标签颜色
     */
    private String tagColor;
    /*
     * 项目id
     */
    private String projectId;
    /*
     * 逻辑删除标志 0 :未删除  1：已删除
     */
    private Integer isDelete;
    /*
     * 标签ids
     */
    private List<String> ids;
    /*
     * 标签颜色集合
     */
    private List<String> tagColors;

}

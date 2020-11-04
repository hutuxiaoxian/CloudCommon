package com.zhishouwei.common.model.entity.basicdata.mongo;

import com.zhishouwei.common.model.entity.BaseMongoEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @description:
 * @author: 曾维录
 * @time: 2020/7/23 9:46
 */

@Data
@Document(collection = "np_sys_dict")
public class SysDictMongoEntity  extends BaseMongoEntity implements Serializable {
    private static final long serialVersionUID = 891022126277060121L;
    @Id
    private String id;
    /**
     * 字典标签
     */
    @Field("dict_label")
    private String dictLabel;

    /**
     *字典排序
     */
    @Field("dict_sort")
    private Integer dictSort;

    /**
     *字典值
     */
    @Field("dict_value")
    private String dictValue;

    /**
     *字典类别 1：父分类 2：子分类
     */
    @Field("dict_type")
    @Indexed(name = "index_dict_type")
    private Integer dictType;

    /**
     *字段父分类code
     */
    @Field("dict_code")
    private String dictCode;

    /**
     *上级id
     */
    @Field("parent_id")
    @Indexed(name = "index_parent_id")
    private String parentId;

    /**
     *项目id
     */
    @Field("project_id")
    @Indexed(name = "index_project_id")
    private String projectId;

    /**
     *备注
     */
    @Field("remark")
    private String remark;
}

package com.zhishouwei.common.model.entity.basicdata;

import lombok.Data;


import java.util.Set;

/**
 * @description:
 * @author: 曾维录
 * @time: 2020/9/1 17:42
 */
@Data
public class FileScopeModel {
    //数据权限 A 全部数据权限 B 无可用资源  C 自定义数据权
    private String code;
    //只有code 为c时才会又数据
    private Set<String> list;
}

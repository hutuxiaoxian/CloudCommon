package com.zhishouwei.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhishouwei.common.exception.ServiceException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@ApiModel(value = "数据请求体", description = "基础数据格式")
public class JsonRequestBody extends JSONObject {

    @ApiModelProperty(name = "分页数据结构")
    private PageForm pageForm;
    public String getStringByTrimToNull(String key) {
        return key.trim();
    }

    public String getNotBlankString(String key) throws ServiceException {
        String val = this.getString(key);
        if (StringUtils.isEmpty(val)) {
            throw new ServiceException("字段为空");
        } else {
            return val.trim();
        }
    }


    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    public <T> T tryGet(Class<T> clazz) {
        return this.tryGet(StringUtils.uncapitalize(clazz.getSimpleName()), clazz);
    }

    public <T> List<T> tryGetList(Class<T> clazz) {
        String key = StringUtils.uncapitalize(clazz.getSimpleName()) + "s";
        return this.containsKey(key) ? this.getJSONArray(key).toJavaList(clazz) : JSON.parseArray(this.toJSONString(), clazz);
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        return this.getJSONArray(key).toJavaList(clazz);
    }

    public <T> T tryGet(String name, Class<T> clazz) {
        return StringUtils.isEmpty(name) && this.containsKey(name) ? JSON.toJavaObject(this.getJSONObject(name), clazz) : JSON.toJavaObject(this, clazz);
    }

    public Map<String, Object> tryToMap() {
        return this;
    }

    public PageForm getPageForm() {
        if (this.pageForm == null) {
            this.pageForm = (PageForm)this.tryGet("pageForm", PageForm.class);
        }

        return this.pageForm;
    }
}

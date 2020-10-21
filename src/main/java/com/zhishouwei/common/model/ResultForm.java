package com.zhishouwei.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhishouwei.common.exception.ServiceException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Data
public class ResultForm implements Serializable {
    private Integer status;
    private Integer errorCode;
    private Object result;
    private Date timestamp;
    private List<ResultMessage> messages;

    public ResultForm() {
        this(200);
    }

    public ResultForm(int status) {
        this.status = 200;
        this.timestamp = new Date();
        this.messages = new ArrayList();
        this.status = status;
    }

    public ResultForm(Integer status, Object result, List<ResultMessage> messages) {
        this.status = 200;
        this.timestamp = new Date();
        this.messages = new ArrayList();
        this.status = status;
        this.result = result;
        this.messages = messages;
    }

    public ResultForm(Integer status, Integer errorCode, Object result, List<ResultMessage> messages) {
        this.status = 200;
        this.timestamp = new Date();
        this.messages = new ArrayList();
        this.status = status;
        this.errorCode = errorCode;
        this.result = result;
        this.messages = messages;
    }

    public static ResultForm success(Object result) {
        return success(result, "数据请求成功");
    }

    public static ResultForm success(Object result, String message, String... args) {
        return createResultForm(ResultEnum.success, result, MessageEnum.success, MessageFormat.format(message, message));
    }

    public static ResultForm error(Object result, String message, String... args) {
        return createResultForm(ResultEnum.error, result, MessageEnum.error, MessageFormat.format(message, message));
    }

    public static ResultForm error(Object result, Integer errorCode, String message, String... args) {
        return createResultForm(ResultEnum.error, result, errorCode, MessageEnum.error, MessageFormat.format(message, message));
    }

    public static ResultForm error(Object result, String message, Exception e) {
        return error(result, 500, message, e);
    }

    public static ResultForm error(Exception e) {
        return e instanceof ServiceException ?
                error((Object)null, 500, "", (ServiceException)e)
                :
                error((Object)null, 500, "", (Exception)e);
    }

    public static ResultForm error(String msg) {
        Exception exception = new Exception(msg);
        return error(exception);
    }


    public static ResultForm error(Object result, Integer errorCode, String message, Exception e) {
        return createResultForm(ResultEnum.error, result, errorCode, MessageEnum.error, message, e.getMessage());
    }

    private static ResultForm createResultForm(ResultEnum status, Object result, MessageEnum level, String... messages) {
        return new ResultForm(status.getResult(), result, ResultMessage.createReslutMessages(level, messages));
    }

    private static ResultForm createResultForm(ResultEnum status, Object result, Integer errorCode, MessageEnum level, String... messages) {
        return new ResultForm(status.getResult(), errorCode, result, ResultMessage.createReslutMessages(level, messages));
    }

    public String getMessage() {
        StringBuffer ms = new StringBuffer();
        Iterator var2 = this.messages.iterator();

        while(var2.hasNext()) {
            ResultMessage messgae = (ResultMessage)var2.next();
            ms.append(messgae.getBody());
        }

        return ms.toString();
    }

    public void setMessage(String message) {
        this.messages.clear();
        this.messages.add(new ResultMessage(this.status, message));
    }

    public boolean isSuccess() {
        return this.status == ResultEnum.success.getResult();
    }


    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public JSONObject toJson() {
        return JSON.parseObject(this.toJsonString());
    }
}

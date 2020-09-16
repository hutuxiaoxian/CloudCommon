package com.zhishouwei.common.controller;

import com.zhishouwei.common.model.DataPaging;
import com.zhishouwei.common.model.JsonRequestBody;
import com.zhishouwei.common.model.PageForm;
import com.zhishouwei.common.model.ResultForm;
import com.zhishouwei.common.model.entity.BaseEntity;
import com.zhishouwei.common.model.mapper.BaseMapper;
import com.zhishouwei.common.model.service.impl.BaseServiceImpl;
import com.zhishouwei.common.exception.ServiceException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.LinkedList;
import java.util.List;


public class BaseController<Entity extends BaseEntity, Service extends BaseServiceImpl<BaseMapper<Entity>, Entity>> {
    @Resource
    Service service;

    @ApiOperation("获取数据列表")
    @ResponseBody
    @RequestMapping(value = "list", method = {RequestMethod.GET,RequestMethod.POST})
    public ResultForm list(@RequestBody JsonRequestBody json) {
        if (json != null) {
            Entity t = (Entity) json.tryGet(service.getEntityClass());
            PageForm pageForm = json.getPageForm();
            try {
                DataPaging<Entity> list = service.getList(t, pageForm);
                return ResultForm.success(list);
            } catch (ServiceException e) {
                return ResultForm.error(e);
            }
        }
        return ResultForm.error("无数据");
    }
    @ResponseBody
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    public ResultForm update(@RequestBody JsonRequestBody json) {
        if (json != null) {
            Entity t = (Entity) json.tryGet(service.getEntityClass());
            try {
                Entity result = service.update(t);
                return ResultForm.success(result);
            } catch (ServiceException e) {
                return ResultForm.error(e);
            }
        }
        return ResultForm.error("无数据");
    }
    @ResponseBody
    @RequestMapping(value = "updateByList", method = {RequestMethod.POST})
    public ResultForm updateByList(@RequestBody JsonRequestBody json) {
        if (json != null) {
            LinkedList<Entity> t = (LinkedList<Entity>) json.tryGetList(service.getEntityClass());
            try {
                LinkedList<Entity> result = service.updateByList(t);
                return ResultForm.success(result);
            } catch (ServiceException e) {
                return ResultForm.error(e);
            }
        }
        return ResultForm.error("无数据");
    }
    @ResponseBody
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    public ResultForm save(@RequestBody JsonRequestBody json) {
        if (json != null) {
            Entity t = (Entity) json.tryGet(service.getEntityClass());
            try {
                Entity result = service.saveEntity(t);
                if (result != null){
                    return ResultForm.success(result);
                }
            } catch (ServiceException e) {
                return ResultForm.error(e);
            }
        }
        return ResultForm.error("无数据");
    }
    @ResponseBody
    @RequestMapping(value = "saveByList", method = {RequestMethod.POST})
    public ResultForm saveByList(@RequestBody JsonRequestBody json) {
        if (json != null) {
            List<Entity> list = json.tryGetList(service.getEntityClass());
            try {
                List<Entity> result = service.saveByList(new LinkedList(list));
                return ResultForm.success(result);
            } catch (ServiceException e) {
                return ResultForm.error(e);
            }
        }
        return ResultForm.error("无数据");
    }
}

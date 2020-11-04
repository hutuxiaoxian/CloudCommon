package com.zhishouwei.common.model.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhishouwei.common.exception.ServiceException;
import com.zhishouwei.common.model.DataPaging;
import com.zhishouwei.common.model.PageForm;
import com.zhishouwei.common.model.entity.BaseEntity;
import com.zhishouwei.common.model.mapper.BaseMapper;
import com.zhishouwei.common.model.mybatis.DynamicTableNameUtils;
import com.zhishouwei.common.model.service.BaseService;
import com.zhishouwei.common.utils.MapUtils;
import com.zhishouwei.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Slf4j
public class BaseServiceImpl<M extends BaseMapper<T>,T extends BaseEntity>  extends ServiceImpl<M, T> implements BaseService<M,T>, IService<T> {

    @Autowired
    private MybatisPlusInterceptor interceptor;

    public Class<T> getEntityClass() {
        return currentModelClass();
    }

    @Autowired(required = false)
    protected SqlSessionTemplate sqlSessionTemplate;

    private QueryWrapper<T> buildEntityQueryWrapper(T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (entity == null) {
            return queryWrapper;
        } else if (entity.getId() != null) {
            queryWrapper.eq(TableInfoHelper.getTableInfo(currentModelClass()).getKeyColumn(), entity.getId());
            return queryWrapper;
        } else {
            queryWrapper = new QueryWrapper<>(entity);
            return queryWrapper;
        }
    }

    private <t> Page<t> buildPage(PageForm pageForm) {
        if (pageForm == null) {
            pageForm = PageForm.NO_PAGING();
        }

        Page<t> page = new Page<>(pageForm.getCurrPage(), pageForm.getPageSize());
        Map<String, String> rule = MapUtils.split(pageForm.getSortRule(), ",", ":");

        for (String col : rule.keySet()) {
            String sort = rule.get(col);
            String unCol = StringUtils.toUnderlineCase(col);
            if ("DESC".equalsIgnoreCase(sort)) {
                page.addOrder(OrderItem.desc(unCol));
            } else {
                page.addOrder(OrderItem.asc(unCol));
            }
        }

        return page;
    }

    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public T saveEntity(T entity) throws ServiceException {
        boolean isSave = false;
        if (ObjectUtils.isNotEmpty(entity) && ObjectUtils.isEmpty(entity.getId())) {
            DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
            isSave = save(entity);
        }
        return isSave ? entity : null;
    }

    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public LinkedList<T> saveByList(LinkedList<T> list) throws ServiceException {
        LinkedList<T> result = new LinkedList<>();
        if (ObjectUtils.isNotEmpty(list) && list.size() > 0) {
            for (T item : list) {
                DynamicTableNameUtils.changeTableName(interceptor, item.tableName(), item.getSplitTableId());
                boolean isSave = save(item);
                if (isSave) {
                    result.add(item);
                }
            }
        }
        return result;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public T update(T entity) throws ServiceException {
        boolean isUpdate = false;
        if (ObjectUtils.isNotEmpty(entity)) {
            if (ObjectUtils.isNotEmpty(entity.getId()) && entity.getId().length() > 0) {
                DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
                isUpdate = update(entity, buildEntityQueryWrapper(entity));
            }
        } else {
            throw new ServiceException("未找到数据ID", ServiceException.ERROR_NO_ID);
        }
        return isUpdate ? entity : null;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public LinkedList<T> updateByList(LinkedList<T> list) throws ServiceException {
        LinkedList<T> result = new LinkedList<>();
        if (ObjectUtils.isNotEmpty(list) && list.size() > 0) {
            DynamicTableNameUtils.changeTableName(interceptor, result.getFirst().tableName(), result.getFirst().getSplitTableId());
            boolean isUpdate = updateBatchById(list);
            if (!isUpdate) {
                throw new ServiceException("批量更新数据失败！" + list.toString());
            }
        }
        return result;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public T saveOrUpdateEntity(T entity) throws ServiceException {
        boolean isOK = false;
        if (ObjectUtils.isNotEmpty(entity)) {
            DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
            isOK = saveOrUpdate(entity);
        }
        return isOK ? entity : null;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public LinkedList<T> saveOrUpdate(LinkedList<T> list) throws ServiceException {
        LinkedList<T> result = new LinkedList<>();
        if (ObjectUtils.isNotEmpty(list) && list.size() > 0) {
            DynamicTableNameUtils.changeTableName(interceptor, list.getFirst().tableName(), list.getFirst().getSplitTableId());
            for (T item : list) {
                boolean isOK = saveOrUpdate(item);
                if (!isOK) {
                    throw new ServiceException("数据保存更新失败");
                }
            }
        }
        return result;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public T getData(T entity) throws ServiceException {
        T result = null;
        if (ObjectUtils.isNotEmpty(entity)) {
            DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
            if (!ObjectUtils.isEmpty(entity.getId())) {
                result = getById(entity.getId());
            } else {
                result = getOne(buildEntityQueryWrapper(entity));
            }
        }
        return result;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public List<T> getList(T entity) throws ServiceException {
        List<T> result = null;
        if (ObjectUtils.isNotEmpty(entity)) {
            DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
            if (!ObjectUtils.isEmpty(entity.getId())) {
                result = new LinkedList<>();
                result.add(getById(entity.getId()));
            } else {
                result = list(buildEntityQueryWrapper(entity));
            }
        }
//        else {
//            // 查询全部数据，根据分页获取
//        }
        return result;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public DataPaging<T> getList(T entity, PageForm pager) throws ServiceException {
        DataPaging<T> result;
        DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
        if (ObjectUtils.isNotEmpty(entity) && ObjectUtils.isNotEmpty(entity.getId())) {
            result = new DataPaging<>();
            List<T> list = new LinkedList<>();
            list.add(getById(entity.getId()));
            result.setContents(list);
        } else {
            Page<T> page = buildPage(pager);
            IPage<T> data = baseMapper.selectPage(page, buildEntityQueryWrapper(entity));
//            final Map<String, Object> tempParams = MapUtils.isEmpty(params) ? Maps.newLinkedHashMap() : params;
//            tempParams.put(UUID.randomUUID().toString(), page);
//            sqlSessionTemplate.selectList(,tempParams);
            result = new DataPaging<T>(data.getRecords(), data.getTotal(), data.getPages(), pager);
        }
        return result;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public boolean delete(T entity) throws ServiceException {
        boolean isDel;
        if (ObjectUtils.isNotEmpty(entity) && ObjectUtils.isNotEmpty(entity.getId())) {
            DynamicTableNameUtils.changeTableName(interceptor, entity.tableName(), entity.getSplitTableId());
            isDel = removeById(entity.getId());
        } else {
            throw new ServiceException("未找到数据ID", ServiceException.ERROR_NO_ID);
        }
        return isDel;
    }
    @Transactional(rollbackFor = {ServiceException.class})
    @Override
    public boolean deleteByList(LinkedList<T> list) throws ServiceException {
        boolean isDel = false;
        if (ObjectUtils.isNotEmpty(list) && list.size() > 0) {
            List<String> ids = new ArrayList<>();
            for (T item : list) {
                if (ObjectUtils.isNotEmpty(item) && ObjectUtils.isNotEmpty(item.getId())) {
                    ids.add(item.getId() + "");
                } else {
                    throw new ServiceException("未找到数据ID", ServiceException.ERROR_NO_ID);
                }
            }
            DynamicTableNameUtils.changeTableName(interceptor, list.getFirst().tableName(), list.getFirst().getSplitTableId());
            isDel = removeByIds(ids);
        }
        return isDel;
    }

}


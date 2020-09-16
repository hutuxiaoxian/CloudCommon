package com.zhishouwei.common.model.service;

import com.zhishouwei.common.model.DataPaging;
import com.zhishouwei.common.model.PageForm;
import com.zhishouwei.common.model.entity.BaseEntity;
import com.zhishouwei.common.model.mapper.BaseMapper;

import java.rmi.ServerException;
import java.util.LinkedList;
import java.util.List;

public interface BaseService<M extends BaseMapper<T>, T extends BaseEntity> {

    /**
     * 新增数据记录
     * @param entity    数据存储对象。根据数据保存记录。如果ID存在，进行数据更新
     * @return 返回新增的数据记录
     * @throws ServerException 数据处理异常
     */
    T saveEntity(T entity) throws ServerException;
    /**
     * 新增数据记录列表
     * @param list    数据存储对象。根据数据保存记录。如果ID存在，进行数据更新
     * @return 返回新增的数据记录列表
     * @throws ServerException 数据处理异常
     */
    LinkedList<T> saveByList(LinkedList<T> list) throws ServerException;
    /**
     * 根据数据ID更新数据记录
     * @param entity    数据存储对象
     * @return  返回的更新数据记录
     * @throws  ServerException 服务处理异常
     */
    T update(T entity) throws ServerException;

    /**
     * 批量更新数据记录
     * 根据每条记录的ID进行更新，无ID时返回更新异常
     * @param list 包含ID的数据列表
     * @return  返回的更新数据记录
     * @throws ServerException 数据处理异常
     */
    LinkedList<T> updateByList(LinkedList<T> list) throws ServerException;
    /**
     * 新增数据记录，如果ID存在，进行数据更新
     * @param entity    数据存储对象
     * @return  返回的新曾或更新数据记录
     * @throws ServerException 数据处理异常
     */
    T saveOrUpdateEntity(T entity) throws ServerException;
    /**
     * 新增数据记录列表，如果ID存在，进行数据更新
     * @param list    数据存储对象
     * @return  返回的新曾或更新数据记录
     * @throws ServerException 数据处理异常
     */
    LinkedList<T> saveOrUpdate(LinkedList<T> list) throws ServerException;

    /**
     * 更新数据参数查询单条数据。优先根据ID进行查询，
     * 当ID不存在时，根据数据其它参数进行查询
     * 当查询出多条符合条件的记录时，取更新时间最新的一条记录
     * @param entity    查询条件对象
     * @return  查询结果
     * @throws ServerException 数据处理异常
     */
    T getData(T entity) throws ServerException;

    /**
     * 更新数据参数查询单条数据。优先根据ID进行查询，
     * 当ID不存在时，根据数据其它参数进行查询
     * @param entity 查询条件对象
     * @return  查询结果
     * @throws ServerException 数据处理异常
     */
    List<T> getList(T entity) throws ServerException;
    /**
     *
     * 更新数据参数查询单条数据。优先根据ID进行查询，
     * 当ID不存在时，根据数据其它参数进行查询
     * @param entity 查询条件对象
     * @param pager 分页条件
     * @return  查询有分页的结果
     * @throws ServerException 数据处理异常
     */
    DataPaging<T> getList(T entity, PageForm pager) throws ServerException;

    /**
     * 根据数据参数删除相应记录
     * 优先根据id进行删除操作
     * 当id不存在时，根据数据参数进行删除；参数条件进行并列（AND）判断；可能产生多个更新
     * @param entity    数据参数
     * @return  是否删除成功
     * @throws ServerException 数据处理异常
     */
    boolean delete(T entity) throws ServerException;

    /**
     * 根据数据参数删除相应记录
     * 根据id进行删除操作
     * 当id不存在时，抛出数据参数异常
     * @param list  需要删除的数据参数列表
     * @return  是否删除成功
     * @throws ServerException 数据处理异常
     */
    boolean deleteByList(LinkedList<T> list) throws ServerException;
}

package com.zhishouwei.common.model.mybatis;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;

import java.util.HashMap;
import java.util.Map;

public class DynamicTableNameUtils {

    /**
     * 处理分表逻辑，可在Entity中定义。
     * 分表处理格式 splitTableId_tableName;
     * @param interceptor 拦截器组，已通过Bean注入 MyBatisPlusInterceptor
     * @param oldName   表名，目前支持通过@TableName方式写入的表名。可由BaseEntity中的tableName()获得。
     * @param getSplitTableId   分表识别前缀
     */
    public static void changeTableName(MybatisPlusInterceptor interceptor, String oldName, String getSplitTableId) {
        for (InnerInterceptor item : interceptor.getInterceptors()) {
            if (item instanceof DynamicTableNameInnerInterceptor) {
                TableNameHandler handler = new TableNameHandler() {
                    @Override
                    public String dynamicTableName(String sql, String tableName) {
                        return getSplitTableId + "_" + tableName;
                    }
                };
                if (((DynamicTableNameInnerInterceptor) item).getTableNameHandlerMap() == null) {
                    Map<String, TableNameHandler> map = new HashMap<String, TableNameHandler>();
                    map.put(oldName, handler);
                    ((DynamicTableNameInnerInterceptor)item).setTableNameHandlerMap(map);
                } else {
                    ((DynamicTableNameInnerInterceptor) item).getTableNameHandlerMap().put(oldName, handler);
                }
            }
        }
    }
}

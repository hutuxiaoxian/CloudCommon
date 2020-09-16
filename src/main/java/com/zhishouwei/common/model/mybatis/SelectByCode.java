package com.zhishouwei.common.model.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;

public class SelectByCode  extends AbstractMethod {
    //    SELECT_BY_ID("selectById", "根据ID 查询一条数据", "SELECT %s FROM %s WHERE %s=#{%s}"),
    private final String method = "selectByCode";
    private final String sqlScript = "SELECT %s FROM %s WHERE %s=#{%s}";

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
//		SqlMethod sqlMethod = SqlMethod.SELECT_BY_ID;
        SqlSource sqlSource = new RawSqlSource(configuration, String.format(sqlScript,
                this.sqlSelectColumns(tableInfo, false), tableInfo.getTableName(), "code", "code"), Object.class);

        return addSelectMappedStatementForTable(mapperClass, method, sqlSource, tableInfo);
    }
}

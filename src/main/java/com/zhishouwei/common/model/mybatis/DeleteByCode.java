package com.zhishouwei.common.model.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;

public class DeleteByCode extends AbstractMethod {
    private final String method = "deleteByCode";
    private final String sqlScript = "<script>\\nDELETE FROM %s WHERE %s=#{%s}\\n</script>";
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlSource sqlSource = new RawSqlSource(configuration, String.format(sqlScript,
                this.sqlSelectColumns(tableInfo, false), tableInfo.getTableName(), "code", "code"), Object.class);
        return addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}

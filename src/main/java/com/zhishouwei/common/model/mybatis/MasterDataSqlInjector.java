package com.zhishouwei.common.model.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

public class MasterDataSqlInjector extends DefaultSqlInjector {
    public final static String SELECT_BY_CODE ="selectByCode";

    public final static String UPDATE_BY_CODE ="UpdateByCode";

    public final static String DELETE_BY_CODE ="DeleteByCode";

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methods = super.getMethodList(mapperClass);
        methods.add(new SelectByCode());
        methods.add(new UpdateByCode());
        methods.add(new DeleteByCode());
        return methods;
    }
}

package com.zhishouwei.common.model.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.zhishouwei.common.controller.BaseController;
import com.zhishouwei.common.model.entity.BaseEntity;
import com.zhishouwei.common.model.service.BaseService;
import com.zhishouwei.common.model.service.impl.BaseServiceImpl;
import com.zhishouwei.common.utils.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@Data
@Configuration
public class BaseGenerator  {

    @Value("spring.datasource.url")
//    private String mysqlUrl = "jdbc:mysql://localhost:3306/demo";
    private String mysqlUrl;
    @Value("spring.datasource.username")
//    private String mysqlUsername = "root";
    private String mysqlUsername;
    @Value("spring.datasource.password")
//    private String mysqlPassword = "VcaHmg0!qBeayg$ku6f~_Q1vtalQ4egu";
    private String mysqlPassword;

    private BaseGenerator instances;
    public static void main(String[] args) {
        BaseGenerator t = new BaseGenerator();
        t.init();
    }
    private HashMap<String, String> packageMap = new HashMap<>();

    private String projectPath = System.getProperty("user.dir");
    private String projectName = projectPath.substring(projectPath.lastIndexOf("/") + 1);

    private void init() {
        AutoGenerator gen = new AutoGenerator();

        //mybatis-plus 全局配置信息
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("hutu");//作者名
//        String projectPath = System.getProperty("user.dir");
        //生成文件的输出目录
        globalConfig.setOutputDir(projectPath + "/src/main/java");

        //生成后是否打开文件夹
        globalConfig.setOpen(false);
        globalConfig.setIdType(IdType.ASSIGN_UUID);
        //时间类型对应策略：只使用java.util.date代替
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setFileOverride(false);//是否覆盖已有文件
        globalConfig.setBaseResultMap(true);//开启BaseResultMap
        globalConfig.setBaseColumnList(true);//开启baseColumnList
        //自定义文件命名，注意:%s会自动填充表实体属性
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setEntityName("%sEntity");//实体名字

        globalConfig.setSwagger2(true);
        gen.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        //mysql 数据库
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(mysqlUrl);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername(mysqlUsername);
        dataSourceConfig.setPassword(mysqlPassword);

        gen.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        String name = StringUtils.getPackageName(projectPath, projectName);
        log.info("{}---------- {}", projectPath, name);
        packageConfig.setModuleName("");
        //packageConfig.setModuleName("anti_generator");
        packageConfig.setParent("");
        packageConfig.setEntity(name + ".entity");
        packageConfig.setController(name + ".controller");
        packageConfig.setService(name + ".service");
        packageConfig.setServiceImpl(name + ".service.impl");
        packageConfig.setMapper(name + ".mapper");
        gen.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel); //表名生成策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel); //列名生成策略
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setChainModel(true);
        //lomok 模板
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        //是否生成注解@TableField
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        //需要生成的表
        strategyConfig.setInclude();
        strategyConfig.setSuperEntityClass(BaseEntity.class);
        strategyConfig.setSuperControllerClass(BaseController.class);
        strategyConfig.setSuperServiceClass(BaseService.class);
        strategyConfig.setSuperServiceImplClass(BaseServiceImpl.class);
        strategyConfig.setSuperEntityColumns("id","createTime","updateTime");
        gen.setStrategy(strategyConfig);

        //自定义属性注入，这个必须有
        InjectionConfig cfg=new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        gen.setCfg(cfg);

        // 添加模板
        gen.setTemplate(createTemp());
//        gen.setTemplateEngine(new VelocityTemplateEngine());

        //执行生成
        gen.execute();
    }

    private TemplateConfig createTemp() {
        TemplateConfig temp = new TemplateConfig()
                .setEntity("temp/entity")
                .setController("temp/controller")
                .setMapper("temp/mapper")
                .setService("temp/service")
                .setServiceImpl("temp/serviceImpl");
        temp.setXml(null);

        return temp;
    }


    private void mkdirImpl(String service, File file, HashMap<String, String> map) throws IOException {
        File impl = new File(file.getCanonicalPath() + "/" + "impl");
        impl.mkdir();
        map.put("impl", impl.getCanonicalPath());

    }
    private File checkDirectory(File file, String pak) {
        for (File item : file.listFiles()) {
            if (item.isDirectory() && item.getName().equals(pak)) {
                return item;
            }
        }
        return null;
    }


    public BaseGenerator getInstances() {
        synchronized (getClass()) {
            if (instances == null) {
                instances = new BaseGenerator();
                instances.init();
            }
        }
        return instances;
    }

}

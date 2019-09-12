package com.abc.mybatisplus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @description: 自动代码生成
 * @author: DeZhao Chen
 * @create: 2019-09-11 17:38
 **/
public class CodeGenerator {
    public static void main(String[] args)  {

        String[] tableNames = {"user"};
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/mp?kuseSSL=false&serverTimezone=GMT";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(true)
                .setAuthor("陈德照")
                .setEnableCache(true)
                .setBaseResultMap(true)
                .setOutputDir("C:/Users/kakao/Desktop/mybatisPlus/src/main/java")//指定到要生成的目录的java层
                .setFileOverride(true)
                .setServiceName("%sSerice");

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent("com.abc.mybatisplus")
                                .setController("controller")//设置控制层包名
                                .setEntity("entity")//设置entity包名
                                .setService("service")//设置service层包名
                                .setServiceImpl("serviceImpl")
                                .setMapper("mapper")
                        .setXml("mapper")
                ).execute();
    }
    }




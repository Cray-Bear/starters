/*
 * Copyright (c) 2011-2019, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.fty1.orm.test.h2.config;

import com.fty1.orm.annotation.IdType;
import com.fty1.orm.core.MybatisConfiguration;
import com.fty1.orm.core.config.GlobalConfig;
import com.fty1.orm.core.parser.AbstractJsqlParser;
import com.fty1.orm.core.parser.ISqlParser;
import com.fty1.orm.extension.injector.LogicSqlInjector;
import com.fty1.orm.extension.plugins.OptimisticLockerInterceptor;
import com.fty1.orm.extension.plugins.PaginationInterceptor;
import com.fty1.orm.extension.plugins.PerformanceInterceptor;
import com.fty1.orm.extension.plugins.SqlExplainInterceptor;
import com.fty1.orm.extension.spring.MybatisSqlSessionFactoryBean;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis Plus Config
 *
 * @author Caratacus
 * @since 2017/4/1
 */
@Configuration
@MapperScan("com.fty1.orm.test.h2.mapper")
public class MybatisPlusConfig {

    @Bean("mybatisSqlSession")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader, GlobalConfig globalConfiguration) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config-object-factory.xml"));
        sqlSessionFactory.setTypeAliasesPackage("com.fty1.orm.test.h2.entity.persistent");
        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        /*
         * 下划线转驼峰开启
         */
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setDefaultEnumTypeHandler(EnumOrdinalTypeHandler.class);  //默认枚举处理
        sqlSessionFactory.setConfiguration(configuration);
        PaginationInterceptor pagination = new PaginationInterceptor();
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(new AbstractJsqlParser(){
    
            @Override
            public void processInsert(Insert insert) {
        
            }
    
            @Override
            public void processDelete(Delete delete) {
        
            }
    
            @Override
            public void processUpdate(Update update) {
        
            }
    
            @Override
            public void processSelectBody(SelectBody selectBody) {
        
            }
        });
        sqlExplainInterceptor.setSqlParserList(sqlParserList);
        OptimisticLockerInterceptor optLock = new OptimisticLockerInterceptor();
        sqlSessionFactory.setPlugins(new Interceptor[]{
            pagination,
            optLock,
            sqlExplainInterceptor,
            new PerformanceInterceptor()
        });
        globalConfiguration.setMetaObjectHandler(new H2MetaObjectHandler());
        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        sqlSessionFactory.setTypeEnumsPackage("com.fty1.orm.test.h2.enums");
        return sqlSessionFactory.getObject();
    }

    @Bean
    public GlobalConfig globalConfiguration() {
        GlobalConfig conf = new GlobalConfig();
        conf.setSqlInjector(new LogicSqlInjector());
        conf.setDbConfig(new GlobalConfig.DbConfig()
            .setLogicDeleteValue("1")
            .setLogicNotDeleteValue("0")
            .setIdType(IdType.ID_WORKER));
        return conf;
    }
}

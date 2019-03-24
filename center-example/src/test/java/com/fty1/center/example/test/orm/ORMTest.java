package com.fty1.center.example.test.orm;

import com.fty1.center.example.DemoApplicationTests;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;


public class ORMTest extends DemoApplicationTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;


    @Test
    public void test() throws Exception{
        Configuration configuration = sqlSessionFactory.getConfiguration();
        SqlSessionFactory res = sqlSessionFactoryBean.getObject();
    }
    
}

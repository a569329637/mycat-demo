package com.gsq.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by guishangquan on 2017/9/8.
 */
public class SqlSessionUtils {

    private static String resource = "mybatis-conf.xml";

    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream is = SqlSessionUtils.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory;
    }

    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}

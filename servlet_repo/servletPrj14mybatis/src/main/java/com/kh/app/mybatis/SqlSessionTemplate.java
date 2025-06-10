package com.kh.app.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	// 이제는 JDBC의 Conn 대신 MyBatis 의 SqlSession
	public static SqlSession getSqlSession() throws Exception { 
		String resource = "/config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession ss = sqlSessionFactory.openSession();
		return ss;
	}

}



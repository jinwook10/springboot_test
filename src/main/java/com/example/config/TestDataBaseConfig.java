package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(value="com.example.mapper.test", sqlSessionFactoryRef="testSqlSessionFactory")
@EnableTransactionManagement
public class TestDataBaseConfig {
	@Primary
	@Bean(name="testDataSource")
	@ConfigurationProperties(prefix="spring.test.datasource")
	public DataSource testDataSource() {
		//application.properties에서 정의한 DB 연결 정보를 빌드
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(name="testSqlSessionFactory")
	public SqlSessionFactory testSessionFactory(@Qualifier("testDataSource") DataSource testDataSource) throws Exception{
		//세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(testDataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/test/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.example.model");
		return sqlSessionFactoryBean.getObject();
	}
	
	@Primary
	@Bean(name="testSqlSession")
	public SqlSessionTemplate testSqlSession(SqlSessionFactory testSqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(testSqlSessionFactory);
	}
}

package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(value="com.example.mapper.another", sqlSessionFactoryRef="anotherSqlSessionFactory")
@EnableTransactionManagement

public class AnotherDataBaseConfig {
	@Bean(name="anotherDataSource")
	@ConfigurationProperties(prefix="spring.another.datasource")
	public DataSource anotherDataSource() {
		//application.properties에서 정의한 DB 연결 정보를 빌드
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name="anotherSqlSessionFactory")
	public SqlSessionFactory anotherSqlSessionFactory(@Qualifier("anotherDataSource")DataSource anotherDataSource, ApplicationContext applicationContext) throws Exception{
		//세션 생성 시, 빌드된 DataSource를 세팅하고 SQL문을 관리할 mapper.xml의 경로를 알려준다.
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(anotherDataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/another/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.example.dto");
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="anotherSqlSessionTemplate")
	public SqlSessionTemplate anotherSqlSessionTemplate(SqlSessionFactory anotherSqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(anotherSqlSessionFactory);
	}
}

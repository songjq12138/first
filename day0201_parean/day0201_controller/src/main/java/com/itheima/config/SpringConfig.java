package com.itheima.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 关于spring配置的配置类
 * @author Administrator
 *
 */
@Configuration
@ComponentScan("com.itheima.service")
@MapperScan("com.itheima.dao")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {
	
	//配置数据源
	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		try {
			datasource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			datasource.setJdbcUrl("jdbc:oracle:thin:@192.168.61.6:1521:orcl");
			datasource.setUser("itheima39");
			datasource.setPassword("itheima");
		} catch (PropertyVetoException e) {
			// TODO 
			e.printStackTrace();
		}
		return datasource;
	}
	
	//配置事务管理器
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager() {
		DataSourceTransactionManager transaction =new DataSourceTransactionManager();
		transaction.setDataSource(getDataSource());
		return transaction;
	}
	
	//配置sqlsessionfactorybean
	@Bean
	public SqlSessionFactoryBean getSqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlsession =new SqlSessionFactoryBean();
		PageInterceptor pi=new PageInterceptor();
		Properties pro=new Properties();
		pro.setProperty("reasonable", "true");
		pi.setProperties(pro);
		sqlsession.setPlugins(new PageInterceptor[] {pi});
		sqlsession.setDataSource(getDataSource());
		return sqlsession;
	}
}

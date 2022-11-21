package com.svk.onlineshopping_backend.hibernate_config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.svk.onlineshopping_backend"})
@EnableTransactionManagement
@PropertySource("classpath:connection.properties")
public class HibernateConfig {
	
//	@Value("${jdbc.url}")
//	private String DATABASE_URL;
//	@Value("${jdbc.driver}")
//	private String DATABASE_DRIVER;
//	@Value("${jdbc.dialect}")
//	private String DATABASE_DIALECT;
//	@Value("${jdbc.username}")
//	private String DATABASE_USERNAME;
//	@Value("${jdbc.password}")
//	private String DATABASE_PASSWORD;
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/online_shopping";
//	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping_bkp";
//	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping_testing";
	private final static String DATABASE_DRIVER="com.mysql.cj.jdbc.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_PASSWORD="root";
	
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.svk.onlineshopping_backend");
		return builder.buildSessionFactory();
		
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
}

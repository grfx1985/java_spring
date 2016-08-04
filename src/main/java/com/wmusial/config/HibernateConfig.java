package com.wmusial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
@PropertySource(value = {"hibernate.properties"})
public class HibernateConfig {

    @Autowired
    private Environment environment;
    //1. DataSource

    @Bean
    public DataSource dataSource{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver.class.name"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.user.name"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));

        return dataSource;
    }
    //2. EntityManagerFactory
    @Bean
    public EntityManagerFactory entityManagerFactory{


    }
    //3. PlatformTransactionManager
    @Bean
    public PlatformTransactionManager txManager)() {

    }


}

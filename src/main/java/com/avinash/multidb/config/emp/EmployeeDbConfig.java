package com.avinash.multidb.config.emp;

import com.avinash.multidb.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "employeeEntityManagerFactory",
        transactionManagerRef = "employeeTransactionManager",
        basePackages = {"com.avinash.multidb.repositories.employee"})
public class EmployeeDbConfig {
    @Primary
    @Bean(name = "employeePropBean")
    @ConfigurationProperties("spring.mysql.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }
    @Primary
    @Bean(name = "employeeDatasource")
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource dataSource(@Qualifier("employeePropBean") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    @Primary
    @Bean(name = "employeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
            (EntityManagerFactoryBuilder factoryBuilder, @Qualifier("employeeDatasource") DataSource dataSource){
        return factoryBuilder.dataSource(dataSource).packages("com.avinash.multidb.model").persistenceUnit("Employee").build();
    }
    @Primary
    @Bean(name = "employeeTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(@Qualifier("employeeEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}

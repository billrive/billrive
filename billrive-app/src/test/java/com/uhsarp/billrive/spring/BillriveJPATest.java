/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.spring;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Prashanth Batchu
 */
/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories*/ //(basePackages = { "com.uhsarp.billrive.domain" })
public class BillriveJPATest {
    
     private static final Logger logger = LoggerFactory.getLogger(BillriveJPATest.class);
    
     @Bean
    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(H2).build();
        
        DriverManagerDataSource ds = new DriverManagerDataSource();


    try {
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("");
//        ds.setPassword("1234");
        ds.setUrl("jdbc:mysql://localhost:3306/billrivedbtest");

    } catch (Exception e) {
        logger.error(e.getMessage());
//        System.out.println(e);
    }
    return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("com.uhsarp.billrive.domain");
        lef.setPersistenceUnitName("billrivePU");
        return lef;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
//        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(Boolean.TRUE);
//        vendorAdapter.setShowSql(Boolean.TRUE);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.uhsarp.springjsfjpa.entity");
////        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
//        //return factory.getObject();
//        //Changed as per Josh's suggestion
//       return (EntityManagerFactory) factory;
//    }
	
    
}

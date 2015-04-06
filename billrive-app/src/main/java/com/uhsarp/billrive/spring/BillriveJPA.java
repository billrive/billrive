package com.uhsarp.billrive.spring;

import java.util.Properties;

import javax.persistence.ValidationMode;
import javax.sql.DataSource;



import org.h2.jdbcx.JdbcDataSource;
//import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
 * 
 * #spring.datasource.url = jdbc:h2:file:../database/billrivedb
#spring.datasource.username = sa
#spring.datasource.driverClassName = org.h2.Driver
#spring.jpa.hibernate.ddl-auto=validate
##spring.jpa.generate-ddl=true
#spring.jpa.show-sql=true
#spring.jpa.open-in-view=true
#spring.data.jpa.repositories.enabled=true
 */


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class BillriveJPA {

    private static final Logger logger = LoggerFactory.getLogger(BillriveJPA.class);

    
   
 /*   @Bean
    public DataSource hsqlDataSource()
    {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(org.hsqldb.jdbcDriver.class.getName());
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");
        basicDataSource.setUrl("jdbc:hsqldb:file:../database/billrivedb");
        return basicDataSource;
    }*/
    
    
  
    //h2
    @Bean
    public DataSource embeddedDataSource(){
    	
    	JdbcDataSource ds = new JdbcDataSource();       
       // ds.setURL("jdbc:hsqldb:file:../database/billrivedb");
        ds.setURL("jdbc:h2:file:../database/billrivedb");
        ds.setUser("sa");
        ds.setPassword("");

        return ds;
    }
    
    //mysql
    //@Bean
    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(H2).build();

        DriverManagerDataSource ds = new DriverManagerDataSource();

        try {
            ds.setDriverClassName("com.mysql.jdbc.Driver");
            ds.setUsername("root");
            ds.setPassword("");
//            ds.setPassword("1234");
            ds.setUrl("jdbc:mysql://localhost:3306/billrivedb");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ds;
    }

    Properties jpaProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto","create");
               setProperty("hibernate.show_sql","true");
            }
        };
    }
    
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        //lef.setJpaProperties(jpaProperties());
        lef.setPackagesToScan("com.uhsarp.billrive.domain");
        lef.setPersistenceUnitName("billrivePU");
        //lef.setValidationMode(ValidationMode.AUTO);
        
        return lef;
       
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
       // hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }
}

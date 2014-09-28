package com.uhsarp.billrive.spring.boot;

import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.util.Enumeration;

/**
 *
 * @author Prashanth Batchu
 */
/*@Configuration
@EnableJpaRepositories
@EnableTransactionManagement*/
public class BillriveSpringBootExclusiveConfig {


    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.uhsarp.billrive.domain");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }




   /* @Bean
    public Filter corsBean(){
        CORSFilter corsFilter = new CORSFilter();
        FilterConfig filterConfig = new FilterConfig() {
            public String getFilterName() {
                return null;
            }

            public ServletContext getServletContext() {
                return null;
            }

            public String getInitParameter(String name) {
                return null;
            }

            public Enumeration<String> getInitParameterNames() {
                return null;
            }
        }
        corsFilter.init();
        corsFilter.setInitParameter("cors.supportedMethods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
        corsFilter.setInitParameter("cors.supportedHeaders", "Accept, Origin, X-Requested-With, Content-Type, Last-Modified, Authorization");
        corsFilter.setInitParameter("cors.supportsCredentials ", "false");
        corsFilter.setInitParameter("cors.allowOrigin ", "*");
//      corsFilter.setInitParameter("cors.allowOrigin ", "http://localhost:8383");
        corsFilter.addMappingForUrlPatterns(null, false, "*//*");

       return corsFilter;
    }*/
}

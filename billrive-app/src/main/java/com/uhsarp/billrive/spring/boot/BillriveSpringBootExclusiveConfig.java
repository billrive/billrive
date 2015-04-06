package com.uhsarp.billrive.spring.boot;

import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 *
 * @author Prashanth Batchu
 */
//@Configuration
public class BillriveSpringBootExclusiveConfig {

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

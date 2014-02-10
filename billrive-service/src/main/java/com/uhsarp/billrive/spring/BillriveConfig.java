/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Prashanth Batchu
 */
@Configuration
//@EnableWebMvc
//@ImportResource("billrive-jpa.xml") //Import any existing xml context files
//@Import(BillriveJPA.class)
//@EnableTransactionManagement //substitute for  <tx:annotation-driven/>
//@ComponentScan({"com.uhsarp.billrive.webservices.rest", "com.uhsarp.billrive.services,com.uhsarp.billrive.dao"})

@ComponentScan(basePackages = {"com.uhsarp.billrive.services","com.uhsarp.billrive.dao"})
public class BillriveConfig {
    
//    @Bean
//    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping(){
//        
//        return new DefaultAnnotationHandlerMapping();
//    }
    
}

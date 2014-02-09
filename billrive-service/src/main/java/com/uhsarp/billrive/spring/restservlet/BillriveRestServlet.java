/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.spring.restservlet;

import com.uhsarp.billrive.spring.BillriveConfig;
import com.uhsarp.billrive.spring.BillriveJPA;
import com.uhsarp.billrive.spring.security.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Prashanth Batchu
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.uhsarp.billrive.webservices.rest"})
//@EnableTransactionManagement //substitute for  <tx:annotation-driven/>
//@ComponentScan({"com.uhsarp.billrive.webservices.rest", "com.uhsarp.billrive.services","com.uhsarp.billrive.dao"})
//@Import({BillriveConfig.class,BillriveJPA.class/*,SecurityConfig.class*/})
public class BillriveRestServlet{
    
//    @Bean
//    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping(){
//        
//        return new DefaultAnnotationHandlerMapping();
//    }
    
}

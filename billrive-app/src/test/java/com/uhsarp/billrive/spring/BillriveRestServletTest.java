/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.spring;

import com.uhsarp.billrive.spring.BillriveConfigTest;
import com.uhsarp.billrive.spring.BillriveJPATest;
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
@Import({BillriveConfigTest.class,BillriveJPATest.class})
public class BillriveRestServletTest{
    
//    @Bean
//    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping(){
//        
//        return new DefaultAnnotationHandlerMapping();
//    }
    
}

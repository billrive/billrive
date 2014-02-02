/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Prashanth Batchu
 */
@Configuration
@ImportResource("billrive-jpa.xml") //Import any existing xml context files
@EnableTransactionManagement //substitute for  <tx:annotation-driven/>
@ComponentScan({"com.uhsarp.billrive.webservices.rest", "com.uhsarp.billrive.services,com.uhsarp.billrive.dao"})
public class BillriveConfig {
    
//    @Bean
//    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping(){
//        
//        return new DefaultAnnotationHandlerMapping();
//    }
    
}

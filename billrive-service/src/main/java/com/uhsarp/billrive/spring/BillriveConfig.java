package com.uhsarp.billrive.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Prashanth Batchu
 */
@Configuration
@ComponentScan(basePackages = {"com.uhsarp.billrive.services","com.uhsarp.billrive.dao"})
public class BillriveConfig {
  
}

package com.uhsarp.billrive.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
/**
 * Created by Uhsarp on 8/31/14.
 */
@ComponentScan(basePackages={"com.uhsarp.billrive.spring","com.uhsarp.billrive.domain","com.uhsarp.billrive.webservices.rest"})
@EnableAutoConfiguration
public class BillRiveInit {
     public static void main(String[] args) {
            SpringApplication.run(BillRiveInit.class, args);
}
}

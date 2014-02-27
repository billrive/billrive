/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.spring;


import com.thetransactioncompany.cors.CORSFilter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;


/**
 *
 * @author Prashanth Batchu
 */
public class Initializer implements WebApplicationInitializer  /*extends
        AbstractAnnotationConfigDispatcherServletInitializer */ {

//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//         return new Class[] {BillriveConfig.class,BillriveJPA.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] {BillriveRestServlet.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
    
   
    @Override
    public void onStartup(ServletContext container) throws ServletException {
    
      // Create the 'root' Spring application context
      AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
      rootContext.register(BillriveConfig.class,BillriveJPA.class,SecurityConfig.class);

      // Manage the lifecycle of the root application context
      container.addListener(new ContextLoaderListener(rootContext));
//      container.addListener(new ContextLoaderListener(rootContext));

      // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(BillriveRestServlet.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
      
//      FilterRegistration.Dynamic corsFilter = container.addFilter("CORS", com.uhsarp.billrive.spring.CORSFilter.class);
//      corsFilter.addMappingForUrlPatterns(null, false, "/*");
      FilterRegistration corsFilter = container.addFilter("CORS", CORSFilter.class);
      //corsFilter.setInitParameter("cors.allowGenericHttpRequests ", "true");
      corsFilter.setInitParameter("cors.supportedMethods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
      corsFilter.setInitParameter("cors.supportedHeaders", "Accept, Origin, X-Requested-With, Content-Type, Last-Modified, Authorization");
      corsFilter.setInitParameter("cors.supportsCredentials ", "false");
//      corsFilter.setInitParameter("cors.supportedHeaders", "Content-Type, X-Requested-With, Origin, Accept");
      //corsFilter.setInitParameter("cors.allowOrigin ", "http://localhost:8383");
      corsFilter.addMappingForUrlPatterns(null, false, "/*");
      
      

      //FilterRegistration.Dynamic customCorsFilter = container.addFilter("CUSTOMCORS", SimpleCORSFilter.class);
      //customCorsFilter.addMappingForUrlPatterns(null, false, "/*");
      
       FilterRegistration.Dynamic  springSecurityFilterChain = container.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
       springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
      
       
       //Native Tomcat CORS Filter
       
//       FilterRegistration.Dynamic tomcatCORSFilter = container.addFilter("",CorsFilter.class);
       
    }
 }
    
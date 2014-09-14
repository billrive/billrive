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
//This file is not used when running billrive as a "Spring Boot" app instead of a webapp!
public class Initializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext container) throws ServletException {
    
      // Create the 'root' Spring application context
      AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
      rootContext.register(BillriveConfig.class,BillriveJPA.class,SecurityConfig.class);

      // Manage the lifecycle of the root application context
      container.addListener(new ContextLoaderListener(rootContext));

      // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(BillriveRestServlet.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
      
      //Setting up the CORS filter
      FilterRegistration corsFilter = container.addFilter("CORS", CORSFilter.class);
      corsFilter.setInitParameter("cors.supportedMethods", "GET, HEAD, POST, PUT, DELETE, OPTIONS");
      corsFilter.setInitParameter("cors.supportedHeaders", "Accept, Origin, X-Requested-With, Content-Type, Last-Modified, Authorization");
      corsFilter.setInitParameter("cors.supportsCredentials ", "false");
      corsFilter.setInitParameter("cors.allowOrigin ", "*");
//      corsFilter.setInitParameter("cors.allowOrigin ", "http://localhost:8383");
      corsFilter.addMappingForUrlPatterns(null, false, "/*");
      
       FilterRegistration.Dynamic  springSecurityFilterChain = container.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
       springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
      
    }
 }
    
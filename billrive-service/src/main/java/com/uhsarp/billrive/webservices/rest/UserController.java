/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.webservices.rest;

import com.uhsarp.billrive.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.uhsarp.billrive.services.UserService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Prashanth Batchu
 */

@RestController
@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "/user")
public class UserController extends GenericController{
    
    	@Autowired
	private UserService userService;

  
        private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
//        private static final Logger logger_c = Logger.getLogger(UserController.class);
        private static final Logger logger_c = LoggerFactory.getLogger(UserController.class);
        
        
    	@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("userId") Long userId) {
            
		User user = new User();
                logger_c.info("Value of userId is  "+userId);
		try {
			user = userService.getUserByUserId(userId);

		} catch (Exception e) {
                       e.printStackTrace();
			String sMessage = "Error getting all users. [%1$s]";
			return null;                  
                     
		}
 
                logger_c.info("Value of Users ArrayList is  ");

		logger_c.debug("Returing Users: " + user.toString());
		return user;
	}
        
        @RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user_p,HttpServletResponse httpResponse_p, WebRequest request_p) {
            
		User user = new User();
//                logger_c.info("Value of userId is  "+userId);
		try {
			user = userService.addUser(user_p);

		} catch (Exception e) {
                       e.printStackTrace();
			String sMessage = "Error getting all users. [%1$s]";
			return null;                  
                     
		}
            httpResponse_p.setStatus(HttpStatus.CREATED.value());

		/* set location of created resource */
		httpResponse_p.setHeader("Location", request_p.getContextPath() + "/user" + user.getId());
		return user;
	}

                
        public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}

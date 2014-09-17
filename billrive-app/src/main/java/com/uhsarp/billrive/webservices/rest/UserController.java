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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Prashanth Batchu
 */

@RestController
@RequestMapping(value = "/user")
public class UserController extends GenericController{

    	@Autowired
	private UserService userService;
    private User user;

     private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
        private static final Logger logger_c = LoggerFactory.getLogger(UserController.class);


    	@RequestMapping(method = RequestMethod.GET)
	public User getUser() {

                org.springframework.security.core.userdetails.User userInMemory;
                userInMemory = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String name = userInMemory.getUsername(); //get logged in username


                try{
                    user = userService.getUserByUserName(name);


                }catch (Exception e) {
                       e.printStackTrace();
                       return null;

		            }
            return user;
	}

    @RequestMapping(method = RequestMethod.POST)
	public User addUser(@RequestBody User user_p) {

		try {
			user = userService.addUser(user_p);

		} catch (Exception e) {
                       e.printStackTrace();
			String sMessage = "Error getting all users. [%1$s]";
			return null;

		}
		return user;
	}


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}

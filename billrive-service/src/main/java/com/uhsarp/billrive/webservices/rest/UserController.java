/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.webservices.rest;

import com.uhsarp.billrive.domain.User;
import static com.uhsarp.billrive.webservices.rest.UserController.isEmpty;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import com.uhsarp.billrive.services.UserService;

/**
 *
 * @author Prashanth Batchu
 */

@Controller
public class UserController extends GenericController{
    
    	@Autowired
	private UserService userService;

  
	@Autowired
	private View jsonView_i;
        
        
        private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
//        private static final Logger logger_c = Logger.getLogger(UserController.class);
        private static final Logger logger_c = LoggerFactory.getLogger(UserController.class);
        
        
    	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable("userId") Long userId) {
            
		User user = new User();
                logger_c.info("Value of userId is  "+userId);
		try {
			user = userService.getUserByUserId(userId);

		} catch (Exception e) {
                       e.printStackTrace();
			String sMessage = "Error getting all users. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));                  
                     
		}
 
                logger_c.info("Value of Users ArrayList is  ");

		logger_c.debug("Returing Users: " + user.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, user);
	}
        
        
        	@RequestMapping(value = "/{userId}/users/{billId}", method = RequestMethod.GET)
	public ModelAndView getUsers(@PathVariable("billId") Long billId_p,@PathVariable("userId") int userId) {
		User bill = null;

		
//		if (isEmpty(billId_p) || billId_p.length() < 5) {
//			String sMessage = "Error invoking getUser - Invalid bill Id parameter";
//			return createErrorResponse(sMessage);
//		}

		try {
//			bill = userService.getUserById(billId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getUser. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		logger_c.debug("Returing User: " + bill.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, bill);
	}
                
                
        @RequestMapping(value = { "/{userId}/users/" }, method = { RequestMethod.POST })
	public ModelAndView createUser(@RequestBody User bill_p,@PathVariable("userId") int userId,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		User createdUser;
		logger_c.debug("Creating User: " + bill_p.toString());

		try {
			createdUser = userService.createUser(bill_p);
		} catch (Exception e) {
			String sMessage = "Error creating new bill. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		/* set HTTP response code */
		httpResponse_p.setStatus(HttpStatus.CREATED.value());

		/* set location of created resource */
		httpResponse_p.setHeader("Location", request_p.getContextPath() + "/{userId}/users/" + bill_p.getId());

		/**
		 * Return the view
		 */
		return new ModelAndView(jsonView_i, DATA_FIELD, createdUser);
	}

	/**
	 * Updates bill with given bill id.
	 *
	 * @param bill_p
	 *            the bill_p
	 * @return the model and view
	 */
	@RequestMapping(value = { "/{userId}/bill/{billId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateUser(@RequestBody User bill_p, @PathVariable("billId") String billId_p,@PathVariable("userId") int userId,
								   HttpServletResponse httpResponse_p) {

		logger_c.debug("Updating User: " + bill_p.toString());

		/* validate bill Id parameter */
		if (isEmpty(billId_p) || billId_p.length() < 5) {
			String sMessage = "Error updating bill - Invalid bill Id parameter";
			return createErrorResponse(sMessage);
		}

		User bill = null;

		try {
			bill = userService.updateUser(bill_p);
		} catch (Exception e) {
			String sMessage = "Error updating bill. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, DATA_FIELD, bill);
	}

	/**
	 * Deletes the bill with the given bill id.
	 *
	 * @param billId_p
	 *            the bill id_p
	 * @return the model and view
	 */
	@RequestMapping(value = "/{userId}/users/{billId}", method = RequestMethod.DELETE)
	public ModelAndView removeUser(@PathVariable("billId") String billId_p,@PathVariable("userId") int userId,
								   HttpServletResponse httpResponse_p) {

		logger_c.debug("Deleting User Id: " + billId_p.toString());

		/* validate bill Id parameter */
		if (isEmpty(billId_p) || billId_p.length() < 5) {
			String sMessage = "Error deleting bill - Invalid bill Id parameter";
			return createErrorResponse(sMessage);
		}

		try {
			userService.deleteUser(billId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getUsers. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, DATA_FIELD, null);
	}
        
        public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}
        
        	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
                
                  public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}

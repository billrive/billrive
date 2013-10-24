/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.uhsarp.billrive.domain.User;
import com.uhsarp.billrive.services.UserService;
import com.uhsarp.billrive.webservices.rest.GenericController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Prashanth Batchu
 */

@Controller

public class UserController extends GenericController{
    
    	@Autowired
	private UserService userService;

  
        private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
//        private static final Logger logger_c = Logger.getLogger(UserController.class);
        private static final Logger logger_c = LoggerFactory.getLogger(UserController.class);
        
        
    	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
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
        
    /**
     *
     * @param user_p
     * @param httpResponse_p
     * @param request_p
     */
    @RequestMapping(value = "/user/", method = { RequestMethod.POST })
	public void addUser(@RequestBody User user_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		User createdUser;
		logger_c.debug("Creating User: " + user_p.toString());

		try {
			createdUser = userService.addUser(user_p);
		} catch (Exception e) {
			String sMessage = "Error creating new user. [%1$s]";
                        //just for testing the logging framework. sout will be removed.
                        System.out.println(e);
                        e.printStackTrace();
//			return null;
		}

		/* set HTTP response code */
		httpResponse_p.setStatus(HttpStatus.CREATED.value());

		/* set location of created resource */
		httpResponse_p.setHeader("Location", request_p.getContextPath() + "/user/{userId}/user/" + user_p.getId());

		/**
		 * Return the view
		 */
//		return new ModelAndView(jsonView_i, DATA_FIELD, createdUser);
	}
                
        public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.webservices.rest;

import com.uhsarp.billrive.domain.Friend;
import com.uhsarp.billrive.services.FriendService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
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

/**
 *
 * @author Prashanth Batchu
 */
@Controller
public class FriendController {
    
    	@Autowired
	private FriendService friendService;

	@Autowired
	private View jsonView_i;
        
        
        private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
        private static final Logger logger_c = Logger.getLogger(FriendController.class);
        
        
    	@RequestMapping(value = "/rest/friends/", method = RequestMethod.GET)
	public ModelAndView getFriends(@PathVariable("userId") int userId) {
		List<Friend> friends = null;

		try {
			friends = friendService.getFriends();
		} catch (Exception e) {
			String sMessage = "Error getting all friends. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		logger_c.debug("Returing Friends: " + friends.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, friends);
	}
        
        
        	@RequestMapping(value = "/rest/{userId}/{userId}/friends/{friendId}", method = RequestMethod.GET)
	public ModelAndView getFriend(@PathVariable("friendId") String friendId_p,@PathVariable("userId") int userId) {
		Friend friend = null;

		
		if (isEmpty(friendId_p) || friendId_p.length() < 5) {
			String sMessage = "Error invoking getFriend - Invalid friend Id parameter";
			return createErrorResponse(sMessage);
		}

		try {
			friend = friendService.getFriendById(friendId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getFriend. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		logger_c.debug("Returing Friend: " + friend.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, friend);
	}
                
                
        @RequestMapping(value = { "/rest/{userId}/{userId}/friends/" }, method = { RequestMethod.POST })
	public ModelAndView createFriend(@RequestBody Friend friend_p,
			HttpServletResponse httpResponse_p, WebRequest request_p,@PathVariable("userId") int userId) {

		Friend createdFriend;
		logger_c.debug("Creating Friend: " + friend_p.toString());

		try {
			createdFriend = friendService.createFriend(friend_p);
		} catch (Exception e) {
			String sMessage = "Error creating new friend. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		/* set HTTP response code */
		httpResponse_p.setStatus(HttpStatus.CREATED.value());

		/* set location of created resource */
		//httpResponse_p.setHeader("Location", request_p.getContextPath() + "/rest/{userId}/{userId}/friends/" + friend_p.getFriendId());

		/**
		 * Return the view
		 */
		return new ModelAndView(jsonView_i, DATA_FIELD, createdFriend);
	}

	/**
	 * Updates friend with given friend id.
	 *
	 * @param friend_p
	 *            the friend_p
	 * @return the model and view
	 */
	@RequestMapping(value = { "/rest/{userId}/{userId}/friends/{friendId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateFriend(@RequestBody Friend friend_p, @PathVariable("friendId") String friendId_p,
								   HttpServletResponse httpResponse_p,@PathVariable("userId") int userId) {

		logger_c.debug("Updating Friend: " + friend_p.toString());

		/* validate friend Id parameter */
		if (isEmpty(friendId_p) || friendId_p.length() < 5) {
			String sMessage = "Error updating friend - Invalid friend Id parameter";
			return createErrorResponse(sMessage);
		}

		Friend friend = null;

		try {
			friend = friendService.updateFriend(friend_p);
		} catch (Exception e) {
			String sMessage = "Error updating friend. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, DATA_FIELD, friend);
	}

	/**
	 * Deletes the friend with the given friend id.
	 *
	 * @param friendId_p
	 *            the friend id_p
	 * @return the model and view
	 */
	@RequestMapping(value = "/rest/{userId}/{userId}/friends/{friendId}", method = RequestMethod.DELETE)
	public ModelAndView removeFriend(@PathVariable("friendId") String friendId_p,
								   HttpServletResponse httpResponse_p,@PathVariable("userId") int userId) {

		logger_c.debug("Deleting Friend Id: " + friendId_p.toString());

		/* validate friend Id parameter */
		if (isEmpty(friendId_p) || friendId_p.length() < 5) {
			String sMessage = "Error deleting friend - Invalid friend Id parameter";
			return createErrorResponse(sMessage);
		}

		try {
			friendService.deleteFriend(friendId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getFriends. [%1$s]";
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
}

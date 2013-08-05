/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.webservices.rest;

import com.uhsarp.billrive.domain.Group;
import com.uhsarp.billrive.domain.Payment;
import com.uhsarp.billrive.domain.UserFinances;
import com.uhsarp.billrive.services.GroupService;
import com.uhsarp.billrive.services.PaymentService;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 *
 * @author Sravan
 */
@Controller
public class PaymentController {
        
    	@Autowired
	private PaymentService PaymentService;

	@Autowired
	private View jsonView_i;
        
        
        private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
        private static final Logger logger_c = Logger.getLogger(GroupController.class);
        
                        
         //Temporary..for testing. POST not working.       
/*     @RequestMapping(value = { "/rest/{userId}/{userId}/groups/newGroup" }, method = { RequestMethod.POST })
    public ModelAndView createGroup(@RequestBody Group group_p,@PathVariable("userId") int userId,
    HttpServletResponse httpResponse_p, WebRequest request_p) {*/
 @RequestMapping(value = "/rest/{userId}/payments/newPayment", method = RequestMethod.GET)
	public ModelAndView createGroup(@PathVariable("userId") int userId) {
    Payment createdPayment;
    //logger_c.debug("Creating Group: " + group_p.toString());
    //Payment(userId, FriendId, date, description)
   Payment paymentObj = new Payment();
    try {
        
        //Pass userId and friend Id
    createdPayment = PaymentService.createPayment(1, paymentObj);
    } catch (Exception e) {
    String sMessage = "Error creating new group. [%1$s]";
    return createErrorResponse(String.format(sMessage, e.toString()));
 }

    /* set HTTP response code */
   // httpResponse_p.setStatus(HttpStatus.CREATED.value());

/* set location of created resource */
//httpResponse_p.setHeader("Location", request_p.getContextPath() + "/rest/{userId}/{userId}/groups/" + group_p.getGroupId());

/**
* Return the view
*/
    return new ModelAndView(jsonView_i, DATA_FIELD, createdPayment);
}

    private ModelAndView createErrorResponse(String format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

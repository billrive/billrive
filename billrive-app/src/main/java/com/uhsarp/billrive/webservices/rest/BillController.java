/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.webservices.rest;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.BillSimpleEntry;
import com.uhsarp.billrive.domain.SimpleUserIdAndLiableCost;
import com.uhsarp.billrive.services.BillService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Prashanth Batchu
 */
@RestController
public class BillController extends GenericController{

    	@Autowired
	private BillService billService;


//	@Autowired
//	private View jsonView_i;


        private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
        private static final Logger logger_c = Logger.getLogger(BillController.class);


    	@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "/user/{userId}/bills", method = RequestMethod.GET)
	public @ResponseBody List<Bill> getBills(@PathVariable("userId") int userId) {
		List<Bill> bills = new ArrayList<Bill>();
                logger_c.info("Value of userId is  "+userId);

		try {
			bills = null;
		} catch (Exception e) {
			String sMessage = "Error getting all bills. [%1$s]";
			return bills;
		}
                logger_c.info("Value of Bills ArrayList is  ");

		logger_c.debug("Returing Bills: " + bills.toString());
		return bills;
	}


        	@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "/user/{userId}/bill/{billId}", method = RequestMethod.GET)
	public @ResponseBody Bill getBill(@PathVariable("billId") String billId_p,@PathVariable("userId") int userId) {
		Bill bill = null;


		if (isEmpty(billId_p) || billId_p.length() < 5) {
			String sMessage = "Error invoking getBill - Invalid bill Id parameter";
			return bill;
		}

		try {
			bill = null;//billService.getBillById(billId_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getBill. [%1$s]";
			return bill;
		}

		logger_c.debug("Returing Bill: " + bill.toString());
		return bill;
	}


        @RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = { "/user/{userId}/bill" }, method = { RequestMethod.POST })
	public void addBill(@RequestBody Bill bill_p,@PathVariable("userId") int userId,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Bill createdBill=null;
		logger_c.debug("Creating Bill: " + bill_p.toString());

		try {
			bill_p.setBillCreaterId((long)userId);
                        createdBill = billService.addBill(bill_p);
		} catch (Exception e) {
			String sMessage = "Error creating new bill. [%1$s]";
		}

		/* set HTTP response code */
                if(createdBill!=null)
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
                else
                    httpResponse_p.setStatus(HttpStatus.EXPECTATION_FAILED.value());

		/* set location of created resource */
		httpResponse_p.setHeader("Location", request_p.getContextPath() + "/user/{userId}/bill/" + bill_p.getId());

	}

	/**
	 * Updates bill with given bill id.
	 *
	 * @param bill_p
	 *            the bill_p
	 * @return the model and view
	 */
	@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = { "/user/{userId}/bill/{billId}" }, method = { RequestMethod.PUT })
	public void editBill(@RequestBody Bill bill_p, @PathVariable("billId") String billId_p,@PathVariable("userId") int userId,
								   HttpServletResponse httpResponse_p) {

		logger_c.debug("Updating Bill: " + bill_p.toString());

		/* validate bill Id parameter */
		if (isEmpty(billId_p) || billId_p.length() < 5) {
			String sMessage = "Error updating bill - Invalid bill Id parameter";
		}

		Bill mergedBill = null;

		try {
                        BillSimpleEntry billSimpleEntry_p = bill_p.getBillSimpleEntry();
                        List<SimpleUserIdAndLiableCost> theList = billSimpleEntry_p.getSimpleUserIdAndLiableCost();
                        BigDecimal userCount = new BigDecimal(theList.size());
                        BigDecimal newTotal = bill_p.getBillTotal();
                        BigDecimal newLiableCost = newTotal.divide(userCount);

                        //Update the liable costs
                        for(SimpleUserIdAndLiableCost s : theList) {
                            BigDecimal liableCostDiff = newLiableCost.subtract(s.getLiableCost());
                            s.setLiableCost(newLiableCost);
                            s.setLiableCostDiff(liableCostDiff);
                        }
                        billSimpleEntry_p.setSimpleUserIdAndLiableCost(theList);
			mergedBill = billService.editBill(bill_p);
		} catch (Exception e) {
			String sMessage = "Error updating bill. [%1$s]";
		}
                if(mergedBill!=null)
		httpResponse_p.setStatus(HttpStatus.OK.value());
                else
                    httpResponse_p.setStatus(HttpStatus.EXPECTATION_FAILED.value());
	}

	/**
	 * Deletes the bill with the given bill id.
	 *
	 * @param bill_p
	 *            the bill_p
	 * @return the model and view
	 */
	@RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "/user/{userId}/bill/{billId}", method = RequestMethod.DELETE)
	public void deleteBill(@RequestBody Long billId, @PathVariable("billId") String billId_p,@PathVariable("userId") int userId,
								   HttpServletResponse httpResponse_p) {
                Boolean deleted=false;

                Bill bill_p = billService.getBillById(billId);
		logger_c.debug("Deleting Bill with : " + bill_p.toString());

		/* validate bill Id parameter */
		if (isEmpty(billId_p) || billId_p.length() < 5) {
			String sMessage = "Error deleting bill - Invalid bill Id parameter";
//			return createErrorResponse(sMessage);
		}

		try {
			 deleted = billService.deleteBill(bill_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getBills. [%1$s]";
//			return createErrorResponse(String.format(sMessage, e.toString()));
		}
                if(deleted)
		httpResponse_p.setStatus(HttpStatus.OK.value());
                else
                    httpResponse_p.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//		return new ModelAndView(jsonView_i, DATA_FIELD, null);
	}

        public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}

        	private String createErrorResponse(String sMessage) {
		return sMessage;
	}

                  public BillService getBillService() {
        return billService;
    }

    public void setBillService(BillService billService) {
        this.billService = billService;
    }

}
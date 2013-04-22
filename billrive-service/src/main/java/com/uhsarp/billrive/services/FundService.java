package com.uhsarp.billrive.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.uhsarp.billrive.domain.Fund;

/**
 * The Class FundService.
 */
@Service
public class FundService {

	private static final Logger logger_c = Logger.getLogger(FundService.class);

	/**
	 * Get the fund by id.
	 *
	 * @param fundId_p
	 *            the fund id_p
	 * @return the fund by id
	 */
	public Fund getFundById(String fundId_p) {
		Fund fund = new Fund();

		fund.setFundId(fundId_p);
		fund.setFundDescription("High Risk Equity Fund");
		fund.setBidPrice(26.80);
		fund.setOfferPrice(27.40);
		fund.setLastUpdated(new Date());

		return fund;
	}

	/**
	 * Gets all funds.
	 *
	 * @return the all funds
	 */
	public List<Fund> getAllFunds() {
		List<Fund> funds = new ArrayList<Fund>();

		for (int i = 0; i < 10; i++) {
			Fund fund = new Fund();

			fund.setFundId("12345" + i);
			fund.setFundDescription("High Risk Equity Fund " + (i + 1));
			fund.setBidPrice(26.80 + (Math.random() * 10));
			fund.setOfferPrice(27.40 + (Math.random() * 10));
			fund.setLastUpdated(new Date());

			funds.add(fund);
		}

		return funds;
	}

	/**
	 * Creates the fund.
	 *
	 * @param fund_p
	 *            the fund_p
	 * @return the fund
	 */
	public Fund createFund(Fund fund_p) {

		logger_c.debug("Persisting fund in database: " + fund_p.toString());

		/* set id and timestamp */
		fund_p.setFundId("12345");
		fund_p.setLastUpdated(new Date());

		return fund_p;
	}

	/**
	 * Update fund.
	 *
	 * @param fund_p
	 *            the fund_p
	 * @return the fund
	 */
	public Fund updateFund(Fund fund_p) {

		logger_c.debug("Updating fund in database: " + fund_p.toString());

		/* set timestamp */
		fund_p.setLastUpdated(new Date());

		return fund_p;
	}

	/**
	 * Delete fund.
	 *
	 * @param fundId_p
	 *            the fund id_p
	 */
	public void deleteFund(String fundId_p) {
		logger_c.debug("Deleting fund from database: " + fundId_p.toString());

	}

}

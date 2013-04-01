/**
 * Project		: MileNMile
 * FileName		: Nfc_Ads.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 1:00:16
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Nfc_Ads
 * @file	: Nfc_Ads.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 1:00:16
 * </PRE>
 */
public class NfcAd extends BaseModel<Long> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7196643153528865509L;

	/** The nfc_id. */
	private String nfc_id;
	
	/** The ad_id. */
	private String ad_id;
	
	/** The cost. */
	private Integer cost;
	
	/** The bid. */
	private Integer bid;
	
	/** The reg_date. */
	private Date reg_date;

	/**
	 * @return nfc_id
	 */
	public String getNfc_id() {
		return nfc_id;
	}

	/**
	 * Sets the nfc_id.
	 *
	 * @param nfc_id the new nfc_id
	 */
	public void setNfc_id(String nfc_id) {
		this.nfc_id = nfc_id;
	}

	/**
	 * @return ad_id
	 */
	public String getAd_id() {
		return ad_id;
	}

	/**
	 * @param ad_id
	 *            Set to ad_id
	 */
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	/**
	 * @return cost
	 */
	public Integer getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            Set to cost
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	/**
	 * @return bid
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * @param bid
	 *            Set to bid
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/**
	 * @return reg_date
	 */
	public Date getReg_date() {
		return reg_date;
	}

	/**
	 * Sets the reg_date.
	 *
	 * @param reg_date the new reg_date
	 */
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}

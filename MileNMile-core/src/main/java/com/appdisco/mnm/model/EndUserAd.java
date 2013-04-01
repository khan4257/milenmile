/**
 * Project		: MileNMile
 * FileName		: EndUserAd.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 1:03:30
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.EndUserAd
 * @file	: EndUserAd.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 1:03:30
 * </PRE>
 */
public class EndUserAd extends BaseModel<Long> {
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 992789270196103735L;
	
	/** The nfc_id. */
	private String nfc_id;
	
	/** The ad_id. */
	private String ad_id;
	
	/** The u_id. */
	private Long u_id;
	
	/** The type. */
	private Integer type;
	
	/** The reg_date. */
	private Date reg_date;
	
	/**
	 * @return nfc_id
	 */
	public String getNfc_id() {
		return nfc_id;
	}
	/**
	 * @param nfc_id Set to nfc_id
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
	 * @param ad_id Set to ad_id
	 */
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	/**
	 * @return u_id
	 */
	public Long getU_id() {
		return u_id;
	}
	/**
	 * @param u_id Set to u_id
	 */
	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}
	/**
	 * @return type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type Set to type
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return reg_date
	 */
	public Date getReg_date() {
		return reg_date;
	}
	/**
	 * @param reg_date Set to reg_date
	 */
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}

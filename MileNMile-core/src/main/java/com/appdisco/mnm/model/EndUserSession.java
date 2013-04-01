/**
 * Project		: MileNMile
 * FileName		: EndUserSession.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 12:04:39
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.EndUserSession
 * @file	: EndUserSession.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 12:04:39
 * </PRE>
 */
public class EndUserSession extends BaseModel<String> {
	
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -6363026042922168119L;
	
	/** The access_id. */
	private String access_id;
	
	/** The nfc_id. */
	private Integer nfc_id;
	
	/** The expired. */
	private Boolean expired;
	
	/** The expired_date. */
	private Date expired_date;
	
	/** The reg_date. */
	private Date reg_date;
	
	
	/**
	 * @return access_id
	 */
	public String getAccess_id() {
		return access_id;
	}
	/**
	 * @param access_id Set to access_id
	 */
	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}
	/**
	 * @return nfc_id
	 */
	public Integer getNfc_id() {
		return nfc_id;
	}
	/**
	 * @param nfc_id Set to nfc_id
	 */
	public void setNfc_id(Integer nfc_id) {
		this.nfc_id = nfc_id;
	}
	/**
	 * @return expired
	 */
	public Boolean getExpired() {
		return expired;
	}
	/**
	 * @param expired Set to expired
	 */
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	/**
	 * @return expired_date
	 */
	public Date getExpired_date() {
		return expired_date;
	}
	/**
	 * @param expired_date Set to expired_date
	 */
	public void setExpired_date(Date expired_date) {
		this.expired_date = expired_date;
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

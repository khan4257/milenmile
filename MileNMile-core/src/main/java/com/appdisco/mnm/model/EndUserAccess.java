/**
 * Project		: MileNMile
 * FileName		: EndUserAccess.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오전 11:59:39
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.EndUserAccess
 * @file	: EndUserAccess.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오전 11:59:39
 * </PRE>
 */
public class EndUserAccess extends BaseModel<String> {
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 7005673784814992297L;
	
	/** The u_id. */
	private Long u_id;
	
	/** The device_id. */
	private String device_id;
	
	/** The push_key. */
	private String push_key;
	
	/** The expired. */
	private Boolean expired;
	
	/** The expired_date. */
	private Date expired_date;
	
	/** The reg_date. */
	private Date reg_date;
	
	
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
	 * @return device_id
	 */
	public String getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id Set to device_id
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return push_key
	 */
	public String getPush_key() {
		return push_key;
	}
	/**
	 * @param push_key Set to push_key
	 */
	public void setPush_key(String push_key) {
		this.push_key = push_key;
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

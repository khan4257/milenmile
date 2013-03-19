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
	
	/** The tag_id. */
	private String tag_id;
	
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
	 * @return tag_id
	 */
	public String getTag_id() {
		return tag_id;
	}
	/**
	 * @param tag_id Set to tag_id
	 */
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
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

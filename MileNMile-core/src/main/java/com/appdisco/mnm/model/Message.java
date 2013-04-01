/**
 * Project		: MileNMile
 * FileName		: UserMessage.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 12:52:32
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.UserMessage
 * @file	: UserMessage.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 12:52:32
 * </PRE>
 */
public class Message extends BaseModel<Long> {
	
	/** The serialVersionUID */
	private static final long serialVersionUID = 7106352731005023875L;

	/** The u_id. */
	private Integer u_id;
	
	/** The end_user_u_id. */
	private Integer end_user_u_id;
	
	/** The message. */
	private String message;
	
	/** The reg_date. */
	private Date reg_date;

	/**
	 * @return u_id
	 */
	public Integer getU_id() {
		return u_id;
	}

	/**
	 * @param u_id Set to u_id
	 */
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	/**
	 * @return end_user_u_id
	 */
	public Integer getEnd_user_u_id() {
		return end_user_u_id;
	}

	/**
	 * @param end_user_u_id Set to end_user_u_id
	 */
	public void setEnd_user_u_id(Integer end_user_u_id) {
		this.end_user_u_id = end_user_u_id;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message Set to message
	 */
	public void setMessage(String message) {
		this.message = message;
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

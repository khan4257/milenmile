/**
 * Project		: MileNMile
 * FileName		: StoreLoc.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 12:59:32
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.StoreLoc
 * @file	: StoreLoc.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 12:59:32
 * </PRE>
 */
public class StoreLoc extends BaseModel<Integer> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5031088346611172910L;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The reg_date. */
	private Date reg_date;

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            Set to title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            Set to description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return reg_date
	 */
	public Date getReg_date() {
		return reg_date;
	}

	/**
	 * @param reg_date
	 *            Set to reg_date
	 */
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}

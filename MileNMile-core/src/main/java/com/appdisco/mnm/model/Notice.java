/**
 * Project		: MileNMile
 * FileName		: Notice.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 12:58:22
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Notice
 * @file	: Notice.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 12:58:22
 * </PRE>
 */
public class Notice extends BaseModel<Long> {

	/** The serialVersionUID */
	private static final long serialVersionUID = 3997854740658501948L;

	/** The u_id. */
	private Integer u_id;

	/** The type. */
	private Integer type;

	/** The title. */
	private String title;

	/** The content. */
	private String content;

	/** The reg_date. */
	private Date reg_date;

	/**
	 * @return u_id
	 */
	public Integer getU_id() {
		return u_id;
	}

	/**
	 * @param u_id
	 *            Set to u_id
	 */
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	/**
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            Set to type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

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
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            Set to content
	 */
	public void setContent(String content) {
		this.content = content;
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

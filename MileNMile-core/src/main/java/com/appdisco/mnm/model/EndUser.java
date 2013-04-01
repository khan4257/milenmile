/**
 * Project		: MileNMile
 * FileName		: EndUser.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 7:35:22
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.EndUser
 * @file	: EndUser.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 7:35:22
 * </PRE>
 */
public class EndUser extends BaseModel<Long> {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 2990669966881420106L;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The phone_no. */
	private String phone_no;

	/** The name. */
	private String name;
	
	/** The is role. */
	private Integer role;

	/** The secession_date. */
	private Date secession_date;

	/** The reg_date. */
	private Date reg_date;

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            Set to username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            Set to password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return phone_no
	 */
	public String getPhone_no() {
		return phone_no;
	}

	/**
	 * @param phone_no
	 *            Set to phone_no
	 */
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Set to name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return role
	 */
	public Integer getRole() {
		return role;
	}

	/**
	 * @param isActivated Set to role
	 */
	public void setRole(Integer role) {
		this.role = role;
	}

	/**
	 * @return secession_date
	 */
	public Date getSecession_date() {
		return secession_date;
	}

	/**
	 * @param secession_date Set to secession_date
	 */
	public void setSecession_date(Date secession_date) {
		this.secession_date = secession_date;
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

/**
 * Project		: MileNMile
 * FileName		: User.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 12:34:00
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.User
 * @file	: User.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 12:34:00
 * </PRE>
 */
public class User extends BaseModel<Long> {
	
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 7472649542365138721L;

	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The name. */
	private String name;
	
	/** The type. */
	private Integer type;
	
	/** The role. */
	private Integer role;
	
	/** The reg_date. */
	private Date reg_date;
	
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username Set to username
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
	 * @param password Set to password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Set to name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role Set to role
	 */
	public void setRole(Integer role) {
		this.role = role;
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

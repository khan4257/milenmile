/**
 * Project		: MileNMile
 * FileName		: Nfc.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 1:00:00
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Nfc
 * @file	: Nfc.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 1:00:00
 * </PRE>
 */
public class Nfc extends BaseModel<String> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2035442012884435808L;

	/** The station. */
	private Integer station;
	
	/** The location. */
	private Integer location;
	
	/** The loc_no. */
	private Integer loc_no;
	
	/** The cost. */
	private Integer cost;
	
	/** The reg_date. */
	private Date reg_date;
	/**
	 * @return station
	 */
	public Integer getStation() {
		return station;
	}
	/**
	 * @param station Set to station
	 */
	public void setStation(Integer station) {
		this.station = station;
	}
	/**
	 * @return location
	 */
	public Integer getLocation() {
		return location;
	}
	/**
	 * @param location Set to location
	 */
	public void setLocation(Integer location) {
		this.location = location;
	}
	/**
	 * @return loc_no
	 */
	public Integer getLoc_no() {
		return loc_no;
	}
	/**
	 * @param loc_no Set to loc_no
	 */
	public void setLoc_no(Integer loc_no) {
		this.loc_no = loc_no;
	}
	/**
	 * @return cost
	 */
	public Integer getCost() {
		return cost;
	}
	/**
	 * @param cost Set to cost
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
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

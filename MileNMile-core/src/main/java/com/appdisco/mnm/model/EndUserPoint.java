/**
 * Project		: MileNMile
 * FileName		: EndUserPoint.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 1:00:54
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.EndUserPoint
 * @file	: EndUserPoint.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 1:00:54
 * </PRE>
 */
public class EndUserPoint extends BaseModel<Long> {
	/** The serialVersionUID */
	private static final long serialVersionUID = -4975117984572882722L;
	
	/** The ad_id. */
	private String ad_id;
	
	/** The u_id. */
	private Long u_id;
	
	/** The point. */
	private Integer point;
	
	/** The type. */
	private Integer type;
	
	/** The reg_date. */
	private Date reg_date;
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
	 * @return point
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * @param point Set to point
	 */
	public void setPoint(Integer point) {
		this.point = point;
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

/**
 * Project		: MileNMile
 * FileName		: EndUserVO.java
 * Package		: com.appdisco.mnm.model.vo
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 11. 오후 12:35:08
 */
package com.appdisco.mnm.model.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.vo.EndUserVO
 * @file	: EndUserVO.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 11. 오후 12:35:08
 * </PRE>
 */
public class EndUserVO implements Serializable {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -8837120682116035285L;

	/** The id. */
	private Long id;
	
	/** The username. */
	private String username;
	
	/** The phone_no. */
	private String phone_no;
	
	/** The name. */
	private String name;
	
	/** The gender. */
	private Integer gender;
	
	/** The birth_year. */
	private Integer birth_year;
	
	/** The profile. */
	private String profile;
	
	/** The profile_img. */
	private String profile_img;
	
	/** The job. */
	private String job;
	
	/** The loc. */
	private String loc;
	
	/** The is married. */
	private Boolean isMarried;
	
	/** The have car. */
	private Boolean haveCar;
	
	/** The point. */
	private Long point;
	
	private Date reg_date;

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

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id Set to id
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return phone_no
	 */
	public String getPhone_no() {
		return phone_no;
	}

	/**
	 * @param phone_no Set to phone_no
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
	 * @param name Set to name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile Set to profile
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return profile_img
	 */
	public String getProfile_img() {
		return profile_img;
	}

	/**
	 * @param profile_img Set to profile_img
	 */
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	/**
	 * @return job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job Set to job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return loc
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc Set to loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * @return gender
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * @param gender Set to gender
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * @return birth_year
	 */
	public Integer getBirth_year() {
		return birth_year;
	}

	/**
	 * @param birth_year Set to birth_year
	 */
	public void setBirth_year(Integer birth_year) {
		this.birth_year = birth_year;
	}

	/**
	 * @return isMarried
	 */
	public Boolean isMarried() {
		return isMarried;
	}

	/**
	 * @param isMarried Set to isMarried
	 */
	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}

	/**
	 * @return haveCar
	 */
	public Boolean getHaveCar() {
		return haveCar;
	}

	/**
	 * @param haveCar Set to haveCar
	 */
	public void setHaveCar(Boolean haveCar) {
		this.haveCar = haveCar;
	}

	/**
	 * @return point
	 */
	public Long getPoint() {
		return point;
	}

	/**
	 * @param point Set to point
	 */
	public void setPoint(Long point) {
		this.point = point;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}

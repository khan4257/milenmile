/**
a * Project		: MileNMile
 * FileName		: EndUserProfile.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 11. 오전 10:26:52
 */
package com.appdisco.mnm.model;


/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.EndUserProfile
 * @file	: EndUserProfile.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 11. 오전 10:26:52
 * </PRE>
 */
public class EndUserProfile extends BaseModel<Long> {

	/** The serialVersionUID */
	private static final long serialVersionUID = 8393267956066171034L;

	/** The profile. */
	private String profile;
	
	/** The profile_img. */
	private String profile_img;
	
	/** The birth_year. */
	private Integer birth_year;
	
	/** The gender. */
	private Integer gender;
	
	/** The is married. */
	private Boolean isMarried;
	
	/** The have car. */
	private Boolean haveCar;

	/** The recieve push. */
	private Boolean recievePush;
	
	/** The recieve sms. */
	private Boolean recieveSms;
	
	/** The job. */
	private String job;
	
	/** The loc. */
	private String loc;
	
	/** The point. */
	private Long point;

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
	 * @return birthday
	 */
	public Integer getBirth_year() {
		return birth_year;
	}

	/**
	 * @param birthday Set to birthday
	 */
	public void setBirth_year(Integer birth_year) {
		this.birth_year = birth_year;
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
	 * Gets the recieve push.
	 *
	 * @return the recieve push
	 */
	public Boolean getRecievePush() {
		return recievePush;
	}

	/**
	 * Sets the recieve push.
	 *
	 * @param recievePush the new recieve push
	 */
	public void setRecievePush(Boolean recievePush) {
		this.recievePush = recievePush;
	}

	/**
	 * Gets the recieve sms.
	 *
	 * @return the recieve sms
	 */
	public Boolean getRecieveSms() {
		return recieveSms;
	}

	/**
	 * Sets the recieve sms.
	 *
	 * @param recieveSms the new recieve sms
	 */
	public void setRecieveSms(Boolean recieveSms) {
		this.recieveSms = recieveSms;
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
	 * @return location
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param location Set to location
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	/**
	 * @return birthday
	 */
	public Long getPoint() {
		return point;
	}

	/**
	 * @param birthday Set to birthday
	 */
	public void setPoint(Long point) {
		this.point = point;
	}
}

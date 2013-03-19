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

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 8393267956066171034L;

	private String profile;
	
	private String profile_img;
	
	private Integer birth_year;
	
	private Integer gender;
	
	private Boolean isMarried;
	
	private Boolean haveCar;

	private String job;
	
	private String loc;

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
	
	
}

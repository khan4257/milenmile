/**
 * Project		: MileNMile
 * FileName		: StoreItem.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 12:59:01
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.StoreItem
 * @file	: StoreItem.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 12:59:01
 * </PRE>
 */
public class StoreItem extends BaseModel<Long> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5324817557961096268L;

	/** The u_id. */
	private Long u_id;
	
	/** The img. */
	private String img;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The loc. */
	private Integer loc;

	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/** The start_date. */
	private String start_date;
	
	/** The end_date. */
	private String end_date;
	
	/** The start_time. */
	private String start_time;
	
	/** The end_time. */
	private String end_time;
	
	/** The approval. */
	private Integer approval;
	
	/** The approval_u_id. */
	private Integer approval_u_id;
	
	/** The approval_date. */
	private Date approval_date;
	
	/** The reg_date. */
	private Date reg_date;

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
	 * @return img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img Set to img
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title Set to title
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
	 * @param description Set to description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return loc
	 */
	public Integer getLoc() {
		return loc;
	}

	/**
	 * @param loc Set to loc
	 */
	public void setLoc(Integer loc) {
		this.loc = loc;
	}

	/**
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate Set to startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate Set to endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return start_date
	 */
	public String getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date Set to start_date
	 */
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return end_date
	 */
	public String getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date Set to end_date
	 */
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return start_time
	 */
	public String getStart_time() {
		return start_time;
	}

	/**
	 * @param start_time Set to start_time
	 */
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	/**
	 * @return end_time
	 */
	public String getEnd_time() {
		return end_time;
	}

	/**
	 * @param end_time Set to end_time
	 */
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	/**
	 * @return approval
	 */
	public Integer getApproval() {
		return approval;
	}

	/**
	 * @param approval Set to approval
	 */
	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	/**
	 * @return approval_u_id
	 */
	public Integer getApproval_u_id() {
		return approval_u_id;
	}

	/**
	 * @param approval_u_id Set to approval_u_id
	 */
	public void setApproval_u_id(Integer approval_u_id) {
		this.approval_u_id = approval_u_id;
	}

	/**
	 * @return approval_date
	 */
	public Date getApproval_date() {
		return approval_date;
	}

	/**
	 * @param approval_date Set to approval_date
	 */
	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
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

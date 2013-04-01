/**
 * Project		: MileNMile
 * FileName		: Ads.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오전 11:53:02
 */
package com.appdisco.mnm.model;

import java.util.Date;

import com.appdisco.mnm.common.utils.DateUtil;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Ads
 * @file	: Ads.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오전 11:53:02
 * </PRE>
 */
public class Ad extends BaseModel<String> {
	
	/** The serialVersionUID */
	private static final long serialVersionUID = -3013823195973411824L;

	/** The secret. */
	private String secret;
	
	/** The u_id. */
	private Integer u_id;
	
	/** The type. */
	private Integer type;
	
	/** The content. */
	private String content;
	
	/** The cost. */
	private Integer cost;
	
	/** The bid. */
	private Integer bid;
	
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
	 * @return secret
	 */
	public String getSecret() {
		return secret;
	}
	/**
	 * @param secret Set to secret
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}
	/**
	 * @return u_id
	 */
	public Integer getU_id() {
		return u_id;
	}
	/**
	 * @param u_id Set to u_id
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
	 * @param type Set to type
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content Set to content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @return bid
	 */
	public Integer getBid() {
		return bid;
	}
	/**
	 * @param bid Set to bid
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
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
		if (startDate != null) {
			start_date = DateUtil.convertDateToString(startDate, DateUtil.DATE_PATTERN);
			start_time = DateUtil.convertDateToString(startDate, DateUtil.TIME_PATTERN);
		} else {
			start_date = null;
			start_time = null;
		}
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
		if (endDate != null) {
			end_date = DateUtil.convertDateToString(endDate, DateUtil.DATE_PATTERN);
			end_time = DateUtil.convertDateToString(endDate, DateUtil.TIME_PATTERN);
		} else {
			end_date = null;
			end_time = null;
		}
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

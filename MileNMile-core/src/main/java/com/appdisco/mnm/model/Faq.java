/**
 * Project		: MileNMile
 * FileName		: Faq.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 12:58:39
 */
package com.appdisco.mnm.model;

import java.util.Date;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Faq
 * @file	: Faq.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 12:58:39
 * </PRE>
 */
public class Faq extends BaseModel<Integer> {
	
	/** The serialVersionUID */
	private static final long serialVersionUID = 6013890477512297968L;
	
	/** The u_id. */
	private Long u_id;
	
	/** The question. */
	private String question;
	
	/** The answer. */
	private String answer;
	
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
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question Set to question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer Set to answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
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

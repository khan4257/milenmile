/**
 * Project		: MileNMile
 * FileName		: BaseModel.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 7:32:52
 */
package com.appdisco.mnm.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.BaseModel
 * @file	: BaseModel.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 7:32:52
 * </PRE>
 */
@SuppressWarnings("serial")
public class BaseModel<PK> implements Serializable {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	private PK id;
	
	public void setId(PK id) {
		this.id = id;
	}
	
	public PK getId() {
		return id;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

package com.appdisco.mnm.common.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.dto.ResponseCode
 * @file	: ResponseCode.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 12:09:07
 * </PRE>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="head")
public class ResponseCode {
	
	/** The code. */
	@XmlElement
	private int code = 200;     // 200, 210, 220 ...
	
	/** The code_msg. */
	@XmlElement
	private String code_msg;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the code_msg.
	 *
	 * @return the code_msg
	 */
	public String getCode_msg() {
		return code_msg;
	}

	/**
	 * Sets the code_msg.
	 *
	 * @param code_msg the new code_msg
	 */
	public void setCode_msg(String code_msg) {
		this.code_msg = code_msg;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return String.format("ResponseCode [code=%s, code_msg=%s]", code, code_msg);
	}
}

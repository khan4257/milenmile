/**
 * Project		: MileNMile
 * FileName		: ApiException.java
 * Package		: com.appdisco.mnm.common
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 1. 31. 오전 10:51:40
 */
package com.appdisco.mnm.common;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.ApiException
 * @file	: ApiException.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 12:09:30
 * </PRE>
 */
public class ApiException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5090810092153787856L;

	/** The code. */
	private int code;
	
	/** The title. */
	private String title;
	
	/** The body. */
	private String body;
	
	/**
	 * Instantiates a new api exception.
	 */
	public ApiException() {
		super();
	}

	/**
	 * Instantiates a new api exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new api exception.
	 *
	 * @param message the message
	 */
	public ApiException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new api exception.
	 *
	 * @param cause the cause
	 */
	public ApiException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Instantiates a new api exception.
	 *
	 * @param code the code
	 */
	public ApiException(int code) {
		super();
		this.code = code;
	}
	
	/**
	 * Instantiates a new api exception.
	 *
	 * @param code the code
	 * @param title the title
	 */
	public ApiException(int code, String title) {
		super(title);
		this.code = code;
		this.title = title;
	}
	
	/**
	 * Instantiates a new api exception.
	 *
	 * @param code the code
	 * @param title the title
	 * @param body the body
	 */
	public ApiException(int code, String title, String body) {
		super(title);
		this.code = code;
		this.title = title;
		this.body = body;
	}

	public ApiException(int code, String title, Throwable cause) {
		super(title, cause);
		this.code = code;
		this.title = title;
	}
	
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}

}

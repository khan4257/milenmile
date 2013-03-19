/**
 * Project		: MileNMile
 * FileName		: SearchOps.java
 * Package		: com.appdisco.mnm.common.dto
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 7:40:36
 */
package com.appdisco.mnm.common.dto;

import java.util.HashMap;
import java.util.Map;


/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.dto.SearchOps
 * @file	: SearchOps.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 7:49:22
 * </PRE>
 */
public class SearchOps {
	
	/** The where. */
	private Map<String, Object> where = new HashMap<String, Object>();
	
	/** The page. */
	private Integer page;
	
	/** The size. */
	private Integer size;
	
	/**
	 * Instantiates a new search ops.
	 */
	public SearchOps() {}
	
	/**
	 * Instantiates a new search ops.
	 *
	 * @param field the field
	 * @param value the value
	 */
	public SearchOps(String field, String value) {
		this(field, value, null, null);
	}
	
	/**
	 * Instantiates a new search ops.
	 *
	 * @param field the field
	 * @param value the value
	 * @param page the page
	 * @param size the size
	 */
	public SearchOps(String field, String value, Integer page, Integer size) {
		where.put(field, value);
	}
	
	/**
	 * Instantiates a new search ops.
	 *
	 * @param values the values
	 */
	public SearchOps(Map<String, Object> values) {
		this(values, null, null);
	}
	
	/**
	 * Instantiates a new search ops.
	 *
	 * @param values the values
	 * @param page the page
	 * @param size the size
	 */
	public SearchOps(Map<String, Object> values, Integer page, Integer size) {
		where.putAll(values);
		this.page = page;
		this.size = size;
	}
	
	/**
	 * Adds the value.
	 *
	 * @param field the field
	 * @param value the value
	 */
	public void addValue(String field, Object value) {
		where.put(field, value);
	}
	
	/**
	 * Sets the limit.
	 *
	 * @param page the page
	 * @param size the size
	 */
	public void setLimit(Integer page, Integer size) {
		this.page = page;
		this.size = size;
	}
	
	/**
	 * Sets the limit.
	 *
	 * @param size the new limit
	 */
	public void setLimit(Integer size) {
		this.size = size;
	}
	
	/**
	 * Checks if is limit.
	 *
	 * @return true, if is limit
	 */
	public boolean isLimit() {
		return size != null || page != null;
	}
}

package com.appdisco.mnm.common.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.dto.ResponseData
 * @file	: ResponseData.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 12:08:58
 * </PRE>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="body")
public class ResponseData<T, E> {

	/** The info. */
	@XmlElement
	private T info = null;
	
	/** The list. */
	@XmlElement
	private List<E> list = new ArrayList<E>();
	
	public ResponseData(T info) {
		this.info = info;
	}
	
	public ResponseData(T info, E data) {
		this.info = info;
		this.list.add(data);
	}
	
	public ResponseData(T info, List<E> list) {
		this.info = info;
		this.list = list;
	}
	
	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Sets the info.
	 *
	 * @param info the new info
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public List<E> getList() {
		return list;
	}

	/**
	 * <PRE>
	 * Sets the list.
	 *
	 * @param list the list
	 * @class	: ResponseData
	 * @brief	:
	 * @author	: KHAN
	 * @date	: 2013. 1. 30 오후 1:48:47
	 * </PRE>
	 */
	public void setList(List<E> list) {
		this.list = list;
	}
	
	/**
	 * <PRE>
	 * Adds the list.
	 *
	 * @param data the data
	 * @class	: ResponseData
	 * @brief	:
	 * @author	: KHAN
	 * @date	: 2013. 1. 30 오후 1:48:47
	 * </PRE>
	 */
	public void addList(E data) {
		this.list.add(data);
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return String.format("ResponseData [info=%s, list=%s]", info, list);
	}
}

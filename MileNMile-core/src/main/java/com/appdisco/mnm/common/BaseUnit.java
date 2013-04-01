/**
 * Project		: MileNMile
 * FileName		: BaseUnit.java
 * Package		: com.appdisco.mnm.common
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 6:26:28
 */
package com.appdisco.mnm.common;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.appdisco.mnm.common.utils.MultiLanguageMessage;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.BaseUnit
 * @file	: BaseUnit.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 6:26:28
 * </PRE>
 */
public class BaseUnit {
	
	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired 
	private MultiLanguageMessage messageService;

	@Value(value="${dir.image_dir}")
	protected String image_dir;

	@Value(value="${dir.root_image_url}")
	protected String root_image_url;

	@Value(value="${url.server_url}")
	protected String server_url;

	public String getImageDir() {
		return image_dir;
	}

	public String getRootImageUrl() {
		return root_image_url;
	}
	
	public String getServerUrl() {
		return server_url;
	}

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @return the message
	 */
	public String getMessage(String key) {
		return messageService.getMessage(key);
	}

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @param objs the objs
	 * @return the message
	 */
	public String getMessage(String key, Object[] objs) {
		return messageService.getMessage(key, objs);
	}

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @param locale the locale
	 * @return the message
	 */
	public String getMessage(String key, Locale locale) {
		return getMessage(key, null, locale);
	}

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @param obj the obj
	 * @param locale the locale
	 * @return the message
	 */
	public String getMessage(String key, Object obj, Locale locale) {
		return getMessage(key, new Object[] { obj }, locale);
	}

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @param objs the objs
	 * @param locale the locale
	 * @return the message
	 */
	public String getMessage(String key, Object[] objs, Locale locale) {
		return messageService.getMessage(key, objs, locale);
	}

}

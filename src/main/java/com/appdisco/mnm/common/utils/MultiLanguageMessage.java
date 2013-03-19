package com.appdisco.mnm.common.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.utils.MultiLanguageMessage
 * @file	: MultiLanguageMessage.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 8:12:26
 * </PRE>
 */
@Service
public class MultiLanguageMessage {
	
	/** The Message Source Accessor. */
	@Autowired
	private MessageSourceAccessor messageSourceAccessor = null;
		
	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @return the message
	 */
	public String getMessage(String key) {
		return messageSourceAccessor.getMessage(key);
	}

	/**
	 * Gets the message.
	 *
	 * @param key the key
	 * @param objs the objs
	 * @return the message
	 */
	public String getMessage(String key, Object[] objs) {
		return messageSourceAccessor.getMessage(key, objs);
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
		return messageSourceAccessor.getMessage(key, objs, locale);
	}
}

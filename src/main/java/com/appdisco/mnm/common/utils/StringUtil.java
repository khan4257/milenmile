package com.appdisco.mnm.common.utils;

/**
 * <PRE>
 * package	: com.khan.opensns.common
 *
 * @class	: 
 * @file	: StringUtil.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 1. 30. 오후 1:39:35
 * </PRE>
 */
public class StringUtil {

	/**
	 * str이 널이면 ""를 반환.
	 *
	 * @param str 검사할 문자열
	 * @return nvl String value
	 */
	public static String nvl(String str) {
		
		if (str == null || str.equals("null") || str.trim().isEmpty()) {
			return "";
		} else {
			return str;
		}
	}

	public static boolean isNull(String str) {
		return (str == null || nvl(str).trim().isEmpty());
	}
}

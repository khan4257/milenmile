package com.appdisco.mnm.web;

import com.appdisco.mnm.common.BaseUnit;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.web.BaseController
 * @file	: BaseController.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 6:27:10
 * </PRE>
 */
public class BaseController extends BaseUnit {

	/**
	 * Check value.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	protected static boolean checkValue(Object obj) {
		if (obj == null)
			return false;
		if ("".equals(obj))
			return false;

		return true;
	}
	
	protected static int Int(String val) {
		return Integer.parseInt(val);
	}
	
	protected static boolean Bool(String val) {
		return Boolean.parseBoolean(val);
	}
	
	protected static long Long(String val) {
		return Long.parseLong(val);
	}
	
	protected static String Str(Object o) {
		return String.valueOf(o);
	}
}

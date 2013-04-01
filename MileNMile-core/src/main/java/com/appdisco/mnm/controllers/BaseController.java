package com.appdisco.mnm.controllers;

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
	
	protected static Integer Int(String val) {
		if (val == null) 
			return null;
		
		try {
			return Integer.parseInt(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	protected static Boolean Bool(String val) {
		if (val == null) 
			return null;
		try {
			return Boolean.parseBoolean(val);
		} catch (Exception e) {
			return null;
		}
	}
	
	protected static Long Long(String val) {
		if (val == null) 
			return null;
		try {
			return Long.parseLong(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	protected static String Str(Object o) {
		return String.valueOf(o);
	}
}

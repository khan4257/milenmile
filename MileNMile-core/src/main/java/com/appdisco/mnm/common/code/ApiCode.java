package com.appdisco.mnm.common.code;

import javax.servlet.http.HttpServletResponse;


/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.code.ApiCode
 * @file	: ApiCode.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 12:09:17
 * </PRE>
 */
public class ApiCode {
	
	/** The invalid version error. */
	public static int INVALID_VERSION_ERROR		= 300;
	
	/** The network error. */
	public static int BAD_REQUEST	 			= HttpServletResponse.SC_BAD_REQUEST; //통신오류
	
	/** The network error. */
	public static int BAD_PARAMETER	 			= 461; //통신오류
	
	/** The system error. */
	public static int SYSTEM_ERROR 				= 410; //시스템오류
	
	/** The DB error. */
	public static int DB_ERROR 					= 420; //DB오류
	
	/** The custom error. */
	public static int CUSTOM_ERROR 				= 430; //고객코드오류
	
	/** The etc error. */
	public static int ETC_ERROR 				= 600; //기타오류
	
	/** The error message. */
	public static int ERROR_MSG 				= 201; //오류 메세지
	
	/** The success. */
	public static int SUCCESS 					= 200; //성공
	
	/** The duplicate id error. */
	public static int DUP_USERNAME_ERROR		= 431; //중복 ID 오류
	
	/** The duplicate email error. */
	public static int DUP_EMAIL_ERROR			= 432; //중복 EMAIL 오류
	
	/** The not exists user error. */
	public static int NOT_EXISTS_USER_ERROR		= 433; //없는 사용자 오류
	
	/** The password error. */
	public static int PASSWORD_ERROR			= 434; //패스워드 오류

	/** The duplicate FB id error. */
	public static int DUP_FB_ID_ERROR			= 435; //중복 Facebook ID 오류
	
	/** The duplicate user phone error. */
	public static int DUP_USER_PHONE_ERROR		= 435; //중복 전화번호 오류
	
	/** The permission denied. */
	public static int PERMISSION_DENIED			= HttpServletResponse.SC_NOT_ACCEPTABLE;
	
}

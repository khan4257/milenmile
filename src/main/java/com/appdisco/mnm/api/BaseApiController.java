/**
 * Project		: MileNMile
 * FileName		: BaseApiController.java
 * Package		: com.appdisco.mnm.api
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 7:31:36
 */
package com.appdisco.mnm.api;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;
import com.appdisco.mnm.common.dto.ResponseCode;
import com.appdisco.mnm.common.dto.ResponseData;
import com.appdisco.mnm.common.utils.StringUtil;
import com.appdisco.mnm.web.BaseController;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.api.BaseApiController
 * @file	: BaseApiController.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 7:31:36
 * </PRE>
 */
public class BaseApiController extends BaseController {
	
//	@Value(value="#{}") String majorVersion;
//	@Autowired String minorVersion;
//	@Autowired String majorVersion;
	
	protected static final String DEFAULT_PAGE_VIEW_FORMAT = "json"; 

	// 자체 논리적오류 내용 처리.
	/**
	 * Handle oAuth exception.
	 *
	 * @param e the ApiException
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@ExceptionHandler(ApiException.class)
	public static ModelAndView handleApiException(ApiException e, HttpServletRequest request, HttpServletResponse response) {
		return handleException(e, request, response);
	}

	// Required parameter 처리.
	/**
	 * Handle required parameter exception.
	 *
	 * @param e the exception
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public static ModelAndView handleRequiredParamException(MissingServletRequestParameterException e, HttpServletRequest request,
			HttpServletResponse response) {
		ApiException ex = new ApiException(ApiCode.ETC_ERROR, e.getMessage());
		return handleException(ex, request, response);
	}

	/**
	 * Handle required method exception.
	 *
	 * @param e the e
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public static ModelAndView handleRequiredMethodException(HttpRequestMethodNotSupportedException e, HttpServletRequest request,
			HttpServletResponse response) {
		ApiException ex = new ApiException(ApiCode.ETC_ERROR, e.getMessage());
		return handleException(ex, request, response);
	}

	/**
	 * Make model and view.
	 *
	 * @param fmt the fmt
	 * @param list the list
	 * @return the model and view
	 */
	protected static ModelAndView makeModelAndView(String fmt, List<Object> list) {
		ModelAndView mv = null;

		if ("xml".equals(fmt)) {
			mv = new ModelAndView("pageXmlReport", "head", list.get(0));
			mv.addObject("body", list.get(1));
		}
		if (DEFAULT_PAGE_VIEW_FORMAT.equals(fmt)) {
			mv = new ModelAndView("pageJsonReport", "head", list.get(0));
			mv.addObject("body", list.get(1));
		}

		return mv;
	}

	/**
	 * 오류내용의 json/xml 전문 처리.
	 * Handle exception.
	 *
	 * @param e the e
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	protected static ModelAndView handleException(ApiException e, HttpServletRequest request, HttpServletResponse response) {
		ResponseCode code = new ResponseCode();
		
		/* HEAD:CODE */
		code.setCode(e.getCode());
		code.setCode_msg(e.getTitle());

		/* BODY:INFO */
		ResponseData<String, Void> data = new ResponseData<String, Void>(e.getMessage());

		ModelAndView mv = new ModelAndView("pageJsonReport", "head", code);

		mv.addObject("body", data);
		response.setStatus(e.getCode());
		return mv;
	}

	
	public static Locale getLocale(String country_type, String language, Locale loc) {
		Locale locale = null;
		if (!"".equals(StringUtil.nvl(language)) && !"".equals(StringUtil.nvl(country_type))) {
			locale = new Locale(language, country_type);
		} else {
			locale = loc;
		}
		return locale;
	}
	
}

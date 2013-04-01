/**
 * Project		: MileNMile
 * FileName		: SettingController.java
 * Package		: com.appdisco.mnm.api
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 26. 오후 5:53:20
 */
package com.appdisco.mnm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.dto.ResponseCode;
import com.appdisco.mnm.common.dto.ResponseData;
import com.appdisco.mnm.service.ApplicationService;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.api.SettingController
 * @file	: SettingController.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 26. 오후 5:53:20
 * </PRE>
 */
@Controller
@RequestMapping(value = "/api/setting/*")
public class SettingController extends BaseApiController {
	
	@Autowired
	private ApplicationService appService;
	
	/**
	 * Ping.
	 *
	 * @param version the version
	 * @param fmt the fmt
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/ping.{fmt}", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView ping(
			@PathVariable int version,
			@PathVariable String fmt) throws ApiException {
				
		return makeSuccessResponse(fmt);
	}
	
	public ModelAndView chkNewVersion(
			@PathVariable int version,
			@PathVariable String fmt) throws ApiException {
		
		ResponseCode code = ResponseCode.successCode();
		
		try {
			String newVersion = appService.getNewVersion();
			ResponseData<String, String> data = new ResponseData<String, String>(newVersion);
			return makeModelAndView(fmt, code, data);
		} catch (ApiException e) {
			log.warn("New version check exception", e);
			throw e;
		}
	}
}

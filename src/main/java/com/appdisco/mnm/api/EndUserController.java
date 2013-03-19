/**
 * Project		: MileNMile
 * FileName		: EndUserController.java
 * Package		: com.appdisco.mnm.api
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 8:18:00
 */
package com.appdisco.mnm.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;
import com.appdisco.mnm.common.code.ApiErrorMessages;
import com.appdisco.mnm.common.dto.ResponseCode;
import com.appdisco.mnm.common.dto.ResponseData;
import com.appdisco.mnm.model.EndUser;
import com.appdisco.mnm.model.vo.EndUserVO;
import com.appdisco.mnm.service.EndUserService;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.api.EndUserController
 * @file	: EndUserController.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 8:18:00
 * </PRE>
 */

@Controller
@RequestMapping(value = "/api/enduser/*")
public class EndUserController extends BaseApiController {
	
	/** The end user service. */
	@Autowired
	private EndUserService endUserService;
	
//	public ModelAndView createUser

	
	/**
	 * Creates the account.
	 *
	 * @param request the request
	 * @param version the version
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/createAccount.{fmt}", method=RequestMethod.POST)
	public ModelAndView createAccount(
			@PathVariable int version,
			@PathVariable String fmt,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "device_id", required = true) String device_id,
			@RequestParam(value = "phone_no", required = true) String phone_no,
			@RequestParam(value = "birth_year", required = true) String birth_year,
			@RequestParam(value = "gender", required = true) String gender,
			@RequestParam(value = "is_married", required = true) String isMarried,
			@RequestParam(value = "have_car", required = true) String haveCar,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			EndUser endUser = endUserService.createAccount(
					username, password, name, phone_no, device_id, Int(birth_year), Int(gender), Bool(isMarried), Bool(haveCar), locale);
			
			if (endUser != null && endUser.getId() > 0) {
				ResponseCode code = new ResponseCode();
				code.setCode(ApiCode.SUCCESS);
				code.setCode_msg("Success");
				ResponseData<String, EndUser> data = new ResponseData<String, EndUser>("", endUser);
				List<Object> list = new ArrayList<Object>();
				list.add(code);
				list.add(data);
				return makeModelAndView(fmt, list);
			} else {
				log.warn("Create User Account error\n" + endUser.toString());
				throw new ApiException(ApiCode.ETC_ERROR, getMessage(ApiErrorMessages.CREATE_ACCOUNT_ERROR, locale));
			}
		} catch (ApiException e) {
			if (e.getCode() == ApiCode.DUP_USERNAME_ERROR) {
				log.warn("Duplicate user error", e);
			} else {
				log.warn("error", e);
			}
			throw e;
		} catch (DataAccessException e) {
			log.warn("Create User Account error", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	@RequestMapping(value = "{version}/login.{fmt}", method=RequestMethod.POST)
	public ModelAndView login(
			@PathVariable int version,
			@PathVariable String fmt,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "device_id", required = true) String device_id,
			@RequestParam(value = "push_key", required = true) String push_key,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			Map<String, String> map = endUserService.login(username, password, device_id, push_key, locale);
			
			ResponseCode code = new ResponseCode();
			ResponseData<String, Map<String, String>> data = new ResponseData<String, Map<String, String>>("", map);
			
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(code);
			list.add(data);
			
			return makeModelAndView(fmt, list);
		} catch (ApiException e) {
			log.warn("error", e);
			throw e;
		} catch (DataAccessException e) {
			log.warn("Login Error....", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	@RequestMapping(value = "{version}/{access_id}/start.{fmt}", method=RequestMethod.POST)
	public ModelAndView login(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			Map<String, String> map = endUserService.login(access_id, locale);
			
			ResponseCode code = new ResponseCode();
			ResponseData<String, Map<String, String>> data = new ResponseData<String, Map<String, String>>("", map);
			
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(code);
			list.add(data);
			
			return makeModelAndView(fmt, list);
		} catch (ApiException e) {
			log.warn("error", e);
			throw e;
		} catch (DataAccessException e) {
			log.warn("Login Error....", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	@RequestMapping(value = "{version}/{access_id}/profile.{fmt}", method=RequestMethod.GET)
	public ModelAndView getEndUserProfile(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			return exportEndUserProfile(Long(id), locale, fmt);
		} catch (ApiException e) {
			if (e.getCode() == ApiCode.DUP_USERNAME_ERROR) {
				log.warn("Duplicate user error", e);
			} else {
				log.warn("error", e);
			}
			throw e;
		} catch (DataAccessException e) {
			log.warn("Create User Account error", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	//updateEndUserProfile

	@RequestMapping(value = "{version}/{access_id}/profile.{fmt}", method=RequestMethod.PUT)
	public ModelAndView updateEndUserProfile(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "haveCar", required = true) String haveCar,
			@RequestParam(value = "isMarried", required = true) String isMarried,
			@RequestParam(value = "job", required = true) String job,
			@RequestParam(value = "loc", required = true) String location,
			@RequestParam(value = "profile", required = true) String profile,
			@RequestParam(value = "profile_img", required = true) MultipartFile profile_img,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("haveCar", Bool(haveCar));
			params.put("isMarried", Bool(isMarried));
			params.put("job", job);
			params.put("loc", location);
			params.put("profile", profile);
			
			boolean result = endUserService.updateEndUserProfile(Long(id), params, locale);
			
			if (result) {
				endUserService.updateProfileImage(Long(id), profile_img, locale);
				return exportEndUserProfile(Long(id), locale, fmt);
			} else {
				throw new ApiException (ApiCode.ETC_ERROR);
			}
			
		} catch (ApiException e) {
			if (e.getCode() == ApiCode.DUP_USERNAME_ERROR) {
				log.warn("Duplicate user error", e);
			} else {
				log.warn("error", e);
			}
			throw e;
		} catch (DataAccessException e) {
			log.warn("Create User Account error", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	private ModelAndView exportEndUserProfile(Long id, Locale locale, String fmt) throws ApiException {
		EndUserVO endUser = endUserService.getEndUserVO(id, locale);
		
		if (endUser != null && endUser.getId() > 0) {
			ResponseCode code = new ResponseCode();
			code.setCode(ApiCode.SUCCESS);
			code.setCode_msg("Success");
			ResponseData<String, EndUserVO> data = new ResponseData<String, EndUserVO>("", endUser);
			List<Object> list = new ArrayList<Object>();
			list.add(code);
			list.add(data);
			return makeModelAndView(fmt, list);
		} else {
			log.warn("Create User Account error\n" + endUser.toString());
			throw new ApiException(ApiCode.ETC_ERROR, getMessage(ApiErrorMessages.CREATE_ACCOUNT_ERROR, locale));
		}
	}
}

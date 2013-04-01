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

import java.util.HashMap;
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
	
	
	/**
	 * Creates the account.
	 *
	 * @param version the version
	 * @param fmt the fmt
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param phone_no the phone_no
	 * @param birth_year the birth_year
	 * @param gender the gender
	 * @param isMarried the is married
	 * @param haveCar the have car
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
			EndUserVO endUserVO = endUserService.createAccount(
					username, password, name, phone_no, Int(birth_year), Int(gender), Bool(isMarried), Bool(haveCar), locale);
			
			if (endUserVO != null && endUserVO.getId() > 0) {
				return makeSuccessResponse(fmt);
			} else {
				log.warn("Create User Account error\n" + endUserVO.toString());
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
	
	/**
	 * Login.
	 *
	 * @param version the version
	 * @param fmt the fmt
	 * @param username the username
	 * @param password the password
	 * @param device_id the device_id
	 * @param push_key the push_key
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
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
			
			ResponseCode code = ResponseCode.successCode();
			ResponseData<String, Map<String, String>> data = new ResponseData<String, Map<String, String>>("", map);
			
			return makeModelAndView(fmt, code, data);
		} catch (ApiException e) {
			log.warn("error", e);
			throw e;
		} catch (DataAccessException e) {
			log.warn("Login Error....", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Login.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param nfc_id the nfc_id
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/start.{fmt}", method=RequestMethod.POST)
	public ModelAndView login(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "nfc_id", required = false) String nfc_id,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			Map<String, String> map = endUserService.login(access_id, Int(nfc_id), locale);
			
			ResponseCode code = ResponseCode.successCode();
			ResponseData<String, Map<String, String>> data = new ResponseData<String, Map<String, String>>("", map);

			return makeModelAndView(fmt, code, data);
		} catch (ApiException e) {
			log.warn("error", e);
			throw e;
		} catch (DataAccessException e) {
			log.warn("Login Error....", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Logout.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/end.{fmt}", method=RequestMethod.POST)
	public ModelAndView logout(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			endUserService.expireSession(access_id, locale);
			
			return makeSuccessResponse(fmt);
		} catch (ApiException e) {
			log.warn("error", e);
			throw e;
		} catch (DataAccessException e) {
			log.warn("Login Error....", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Gets the end user profile.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param id the id
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the end user profile
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/profile.{fmt}", method=RequestMethod.GET)
	public ModelAndView getEndUserProfile(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			if (id != null) {
				return exportEndUserProfile(Long(id), locale, fmt);
			} else {
				Long u_id = endUserService.getEndUserAccess(access_id).getU_id();
				return exportEndUserProfile(u_id, locale, fmt);
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
	//updateEndUserProfile

	/**
	 * Update end user profile.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param haveCar the have car
	 * @param isMarried the is married
	 * @param job the job
	 * @param location the location
	 * @param profile the profile
	 * @param recieveSms the recieve sms
	 * @param recievePush the recieve push
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/profile.{fmt}", method=RequestMethod.PUT)
	public ModelAndView updateEndUserProfile(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "haveCar", required = false) String haveCar,
			@RequestParam(value = "isMarried", required = false) String isMarried,
			@RequestParam(value = "job", required = false) String job,
			@RequestParam(value = "loc", required = false) String location,
			@RequestParam(value = "profile", required = false) String profile,
			@RequestParam(value = "recieveSms", required = false) String recieveSms,
			@RequestParam(value = "recievePush", required = false) String recievePush,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			if (haveCar != null)
				params.put("haveCar", Bool(haveCar));
			if (isMarried != null)
				params.put("isMarried", Bool(isMarried));
			if (job != null)
				params.put("job", job);
			if (location != null)
				params.put("loc", location);
			if (profile != null)
				params.put("profile", profile);
			if (recieveSms != null)
				params.put("recieveSms", Bool(recieveSms));
			if (recievePush != null)
				params.put("recievePush", Bool(recievePush));
			
			if (params.isEmpty())
				throw new ApiException (ApiCode.BAD_PARAMETER, getMessage(ApiErrorMessages.BAD_PARAMETER, locale));
			
			Long id = endUserService.getEndUserAccess(access_id).getU_id();
			
			if (endUserService.updateEndUserProfile(id, params, locale)) {
				return makeSuccessResponse(fmt);
			} else {
				throw new ApiException (ApiCode.ETC_ERROR);
			}
			
		} catch (ApiException e) {
			log.debug("ApiException", e);
			throw e;
		} catch (DataAccessException e) {
			log.debug("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Update end user profile.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param profile_img the profile_img
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/profile_img.{fmt}", method={RequestMethod.POST})
	public ModelAndView updateEndUserProfile(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "profile_img", required = false) MultipartFile profile_img,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			Long id = endUserService.getEndUserAccess(access_id).getU_id();
			
			if (profile_img != null) {
				String filename = endUserService.updateProfileImage(id, profile_img, locale);
				ResponseData<String, Void> data = new ResponseData<String, Void>(filename);
				return makeModelAndView(fmt, ResponseCode.successCode(), data);
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
			log.warn("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Sign out.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/profile.{fmt}", method=RequestMethod.DELETE)
	public ModelAndView signOut(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			if (endUserService.signOut(access_id))
				endUserService.expireSession(access_id, locale);
			else {
				throw new ApiException(ApiCode.NOT_EXISTS_USER_ERROR);
			}
			return makeSuccessResponse(fmt);
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

	/**
	 * Change password.
	 *
	 * @param version the version
	 * @param access_id the access_id
	 * @param fmt the fmt
	 * @param pwd the pwd
	 * @param newPwd the new pwd
	 * @param country_type the country_type
	 * @param language the language
	 * @param loc the loc
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	@RequestMapping(value = "{version}/{access_id}/changePassword.{fmt}", method=RequestMethod.PUT)
	public ModelAndView changePassword(
			@PathVariable int version,
			@PathVariable String access_id,
			@PathVariable String fmt,
			@RequestParam(value = "password", required = false) String pwd,
			@RequestParam(value = "new_password", required = false) String newPwd,
			@RequestParam(value = "country_type", required = false) String country_type,
			@RequestParam(value = "language", required = false, defaultValue = "") String language,
			Locale loc
			) throws ApiException {
		
		Locale locale = getLocale(country_type, language, loc);
		
		try {
			Long id = endUserService.getEndUserAccess(access_id).getU_id();
			boolean result = endUserService.updatePassword(id, pwd, newPwd, locale);
			if (result)
				return makeSuccessResponse(fmt);
			else 
				throw new ApiException (ApiCode.ETC_ERROR);
		} catch (ApiException e) {
			log.warn("API error", e);
			throw e;
		} catch (DataAccessException e) {
			log.warn("Password change error", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	

	/**
	 * Export end user profile.
	 *
	 * @param id the id
	 * @param locale the locale
	 * @param fmt the fmt
	 * @return the model and view
	 * @throws ApiException the api exception
	 */
	private ModelAndView exportEndUserProfile(Long id, Locale locale, String fmt) throws ApiException {
		EndUserVO endUser = endUserService.getEndUserVO(id, locale);
		
		if (endUser != null && endUser.getId() > 0) {
			ResponseCode code = ResponseCode.successCode();
			ResponseData<String, EndUserVO> data = new ResponseData<String, EndUserVO>("", endUser);
			
			return makeModelAndView(fmt, code, data);
		} else {
			log.warn("Export User Account error\n" + endUser);
			throw new ApiException(ApiCode.NOT_EXISTS_USER_ERROR, getMessage(ApiErrorMessages.NOT_EXISTS_USER_ERROR, locale));
		}
	}
}

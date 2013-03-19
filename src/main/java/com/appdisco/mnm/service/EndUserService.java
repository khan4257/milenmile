/**
* Project		: MileNMile
 * FileName		: EndUserService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 8:15:39
 */
package com.appdisco.mnm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;
import com.appdisco.mnm.common.code.ApiErrorMessages;
import com.appdisco.mnm.common.utils.IdGenerator;
import com.appdisco.mnm.dao.EndUserAccessDao;
import com.appdisco.mnm.dao.EndUserDao;
import com.appdisco.mnm.dao.EndUserProfileDao;
import com.appdisco.mnm.dao.EndUserRoleDao;
import com.appdisco.mnm.dao.EndUserSessionDao;
import com.appdisco.mnm.dao.readonly.EndUserVODao;
import com.appdisco.mnm.model.EndUser;
import com.appdisco.mnm.model.EndUserAccess;
import com.appdisco.mnm.model.EndUserProfile;
import com.appdisco.mnm.model.EndUserSession;
import com.appdisco.mnm.model.vo.EndUserVO;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.EndUserService
 * @file	: EndUserService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 8:15:39
 * </PRE>
 */
@Service
public class EndUserService extends BaseService {
	
	/** The end user dao. */
	@Autowired
	private EndUserDao endUserDao;

	/** The end user profile dao. */
	@Autowired
	private EndUserProfileDao endUserProfileDao;
	
	@Autowired
	private EndUserAccessDao endUserAccessDao;
	
	@Autowired
	private EndUserSessionDao endUserSessionDao;

	/** The role dao. */
	@Autowired
	private EndUserRoleDao endUserRoleDao;
	
	@Autowired
	private EndUserVODao endUserVODao;
	
	/**
	 * Creates the account.
	 *
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param phone_no the phone_no
	 * @param device_id the device_id
	 * @param locale the locale
	 * @return the end user
	 * @throws ApiException the api exception
	 */
	public EndUser createAccount(
			String username, 
			String password, 
			String name, 
			String phone_no, 
			String device_id,
			int birth_year,
			int gender,
			boolean isMarried,
			boolean haveCar,
			Locale locale) throws ApiException {
		
		EndUser endUser = new EndUser();
		endUser.setUsername(username);
		endUser.setPassword(password);
		endUser.setName(name);
		endUser.setDevice_id(device_id);
		endUser.setPhone_no(phone_no);
		endUser.setRole(getEnableEndUserRole());
		endUser.setReg_date(new Date());
		
		try {
			endUser = createEndUser(endUser, locale);
		} catch (DuplicateKeyException e) {
			throw new ApiException(ApiCode.DUP_USERNAME_ERROR, getMessage(ApiErrorMessages.DUPLICATE_USERNAME_ERROR, locale), e);
		}
		
		if (endUser.getId() != null && endUser.getId() > 0) { 
			try {
				createEndUserProfile(endUser.getId(), birth_year, gender, isMarried, haveCar, locale);
			} catch (DataAccessException e) {
				throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale));
			} 
		}
		
		return endUser;
	}
	
	/**
	 * Update password.
	 *
	 * @param id the id
	 * @param pwd the pwd
	 * @param newPwd the new pwd
	 * @param locale the locale
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean updatePassword(long id, String pwd, String newPwd, Locale locale) throws ApiException {
		if (chkPwd(id, pwd)) {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("password", newPwd);
			return updateEndUser(id, params);
		} else {
			String err = getMessage(ApiErrorMessages.PASSWORD_ERROR, locale);
			throw new ApiException(ApiCode.PASSWORD_ERROR, err);
		}
	}
	
	/**
	 * Creates the end user.
	 *
	 * @param endUser the end user
	 * @param locale the locale
	 * @return the end user
	 * @throws ApiException the api exception
	 */
	public EndUser createEndUser(EndUser endUser, Locale locale) throws ApiException {
		try {
			return endUserDao.insert(endUser);
		} catch (DuplicateKeyException e) {
			log.error("Duplicated key exception", e);
			String err = getMessage(ApiErrorMessages.DUPLICATE_USERNAME_ERROR, locale);
			throw new ApiException(ApiCode.DUP_USERNAME_ERROR, err, e);
		}
	}
	
	/**
	 * Update end user.
	 *
	 * @param endUser the end user
	 * @return true, if successful
	 */
	public boolean updateEndUser(EndUser endUser) {
		return endUserDao.update(endUser);
	}
	
	/**
	 * Update end user.
	 *
	 * @param id the id
	 * @param params the params
	 * @return true, if successful
	 */
	public boolean updateEndUser(Long id, Map<String, Object> params) {
		return endUserDao.update(id, params);
	}
	
	/**
	 * Removes the end user.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean removeEndUser(Long id) {
		return endUserDao.delete(id);
	}
	
	/**
	 * Checks if is valid user.
	 *
	 * @param id the id
	 * @return true, if is valid user
	 */
	public boolean isValidUser(Long id) {
		return endUserDao.isValidUser(id, getEnableEndUserRole());
	}
	
	/**
	 * Checks if is valid user.
	 *
	 * @param username the username
	 * @return true, if is valid user
	 */
	public boolean isValidUser(String username) {
		return endUserDao.isValidUser(username, getEnableEndUserRole());
	}
	
	/**
	 * Chk pwd.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public EndUser chkPwd(String username, String password) throws ApiException {
		try {
			return endUserDao.chkPwd(username, password, getEnableEndUserRole());
		} catch (ApiException e) {
			throw e;
		}
	}
	
	/**
	 * Chk pwd.
	 *
	 * @param id the id
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean chkPwd(Long id, String password) throws ApiException {
		try {
			return endUserDao.chkPwd(id, password, getEnableEndUserRole());
		} catch (ApiException e) {
			throw e;
		}
	}
	
	/**
	 * Login.
	 *
	 * @param email the email
	 * @param password the password
	 * @return true, if successful
	 */
	public Map<String, String> login(String email, String password, String device_id, String push_key, Locale locale) throws ApiException {
		if (!isValidUser(email))
			throw new ApiException(ApiCode.NOT_EXISTS_USER_ERROR, getMessage(ApiErrorMessages.NOT_EXISTS_USER_ERROR, locale));
		
		EndUser user = chkPwd(email, password);
		if (user == null)
			throw new ApiException(ApiCode.PASSWORD_ERROR, getMessage(ApiErrorMessages.PASSWORD_ERROR, locale));
		log.info(user.toString());
		Long id = user.getId();
		log.info(String.format("user id : %d", id));
		//TODO 
		EndUserAccess access = createEndUserAccess(user.getId(), device_id, push_key, locale);
		
		EndUserSession session = createSession(access.getId(), "", locale);
		
//		List<String> list = new ArrayList<String>();
//		list.add(access.getId());
//		list.add(session.getId());
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("access", access.getId());
		map.put("session", session.getId());
		
		return map;
	}
	
	/**
	 * Login.
	 *
	 * @param access the access
	 * @param locale the locale
	 * @return the map
	 * @throws ApiException the api exception
	 */
	public Map<String, String> login(String access, Locale locale) throws ApiException {
		
		if (!validAccessKey(access, locale)) {
			throw new ApiException(ApiCode.NOT_EXISTS_USER_ERROR);
		}
		
		EndUserSession session = createSession(access, "", locale);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("access", access);
		map.put("session", session.getId());
		
		return map;
	}
	
	/**
	 * Creates the end user access.
	 *
	 * @param u_id the u_id
	 * @param device_id the device_id
	 * @param push_key the push_key
	 * @param locale the locale
	 * @return the end user access
	 * @throws ApiException the api exception
	 */
	public EndUserAccess createEndUserAccess(Long u_id, String device_id, String push_key, Locale locale) throws ApiException {
		EndUserAccess access = new EndUserAccess();
		access.setId(IdGenerator.getUUID());
		access.setU_id(u_id);
		access.setDevice_id(device_id);
		access.setPush_key(push_key);
		access.setExpired(false);
		access.setReg_date(new Date());
		
		try {
			return endUserAccessDao.insert(access);
		} catch (DuplicateKeyException e) {
			
			throw new ApiException(e);
		} catch (DataAccessException e) {
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	public EndUserSession createSession(String access_id, String tag_id, Locale locale) throws ApiException {
		EndUserSession session = new EndUserSession();
		
		session.setId(IdGenerator.getUUID());
		session.setAccess_id(access_id);
		session.setTag_id(tag_id);
		session.setReg_date(new Date());
		
		try {
			return endUserSessionDao.insert(session);
		} catch (DuplicateKeyException e) {
			
			throw new ApiException(e);
		} catch (DataAccessException e) {
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Expire session.
	 *
	 * @param access_id the access_id
	 * @param locale the locale
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean expireSession(String access_id, Locale locale) throws ApiException {
		try {
			return endUserSessionDao.expireSession(access_id);
		} catch (DuplicateKeyException e) {
			
			throw new ApiException(e);
		} catch (DataAccessException e) {
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	/**
	 * Gets the enable end user role.
	 *
	 * @return the enable end user role
	 */
	private Integer getEnableEndUserRole() {
		return endUserRoleDao.getRoleByName("USER").getId();
	}
	

	/* ###################################### END USER PROFILE ###################################### */
	
	/**
	 * Creates the end user profile.
	 *
	 * @param id the id
	 * @param birth_year the birth_year
	 * @param gender the gender
	 * @param isMarried the is married
	 * @param haveCar the have car
	 * @param locale the locale
	 * @return true, if successful
	 * @throws ApiException the api exception
	 * @throws DataAccessException the data access exception
	 */
	public EndUserProfile createEndUserProfile(Long id, int birth_year, int gender, boolean isMarried, boolean haveCar, Locale locale) throws ApiException, DataAccessException {
		EndUserProfile endUserProfile = new EndUserProfile();
		endUserProfile.setId(id);
		endUserProfile.setBirth_year(birth_year);
		endUserProfile.setGender(gender);
		endUserProfile.setIsMarried(isMarried);
		endUserProfile.setHaveCar(haveCar);
		
		try {
			endUserProfile = endUserProfileDao.insert(endUserProfile);
			return endUserProfile;
		} catch (DataAccessException e) {
			log.warn("DataAccessException", e);
			throw e;
		}
		
	}
	
	/**
	 * Update end user profile.
	 *
	 * @param profile the profile
	 * @param locale the locale
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean updateEndUserProfile (EndUserProfile profile, Locale locale) throws ApiException {
		try {
			return endUserProfileDao.update(profile);
		} catch (DataAccessException e) {
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale));
		}
	}
	
	/**
	 * Update end user profile.
	 *
	 * @param id the id
	 * @param params the params
	 * @param locale the locale
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean updateEndUserProfile(Long id, Map<String, Object> params, Locale locale) throws ApiException {
		try {
			return endUserProfileDao.update(id, params);
		} catch (DataAccessException e) {
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale));
		}
	}
	
	/**
	 * Update profile image.
	 *
	 * @param id the id
	 * @param image the image
	 * @param locale the locale
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean updateProfileImage(Long id, MultipartFile image, Locale locale) throws ApiException {
		String filename = id + "_" + System.currentTimeMillis() + ".png" ;
		
		uploadFile(getImageDir(), filename, image);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("profile_img", getRootImageUrl() + filename);
		
		return updateEndUserProfile(id, params, locale);
	}
	
	/**
	 * Delete profile image.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean deleteProfileImage(Long id, String img_src, Locale locale) throws ApiException {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("profile_img", "");
				
		return updateEndUserProfile(id, params, locale);
	}
	

	/* ###################################### END USER VO ###################################### */
	
	/**
	 * Gets the end user vo.
	 *
	 * @param id the id
	 * @param locale the locale
	 * @return the end user vo
	 * @throws ApiException the api exception
	 */
	public EndUserVO getEndUserVO(Long id, Locale locale) throws ApiException {
		try {
			return endUserVODao.get(id);
		} catch (DataAccessException e) {
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR, locale), e);
		}
	}
	
	
	/* ###################################### END USER ACCESS ###################################### */
	
	public boolean validAccessKey(String access, Locale locale) throws ApiException {
		return getEndUserAccess(access) != null;
	}
	
	public EndUserAccess getEndUserAccess(String access) throws ApiException {
		try {
			return  endUserAccessDao.get(access);
		} catch (DataAccessException e) {
			log.error("Data Access Exception", e);
			throw new ApiException (ApiCode.DB_ERROR);
		}
	}
}

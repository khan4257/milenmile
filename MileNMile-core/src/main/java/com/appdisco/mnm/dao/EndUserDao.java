/**
 * Project		: MileNMile
 * FileName		: EndUserDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 7:52:37
 */
package com.appdisco.mnm.dao;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.model.EndUser;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.EndUserDao
 * @file	: EndUserDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 7:52:37
 * </PRE>
 */
public interface EndUserDao extends GenericDao<Long, EndUser> {
	public Boolean isValidUser(Long id, Integer low_role);
	public Boolean isValidUser(String username, Integer low_role);
	public Boolean isValidUser(String username, String phone_no, Integer low_role);
	public Boolean chkPwd(Long id, String passwor, Integer low_roled) throws ApiException;
	public EndUser chkPwd(String username, String password, Integer low_role) throws ApiException;
	public String getUsername(String phone_no, Integer low_role);
}

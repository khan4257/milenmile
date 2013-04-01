/**
 * Project		: MileNMile
 * FileName		: EndUserAccessDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 12:06:25
 */
package com.appdisco.mnm.dao;

import java.util.List;

import com.appdisco.mnm.model.EndUserAccess;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.EndUserAccessDao
 * @file	: EndUserAccessDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 12:06:25
 * </PRE>
 */
public interface EndUserAccessDao extends GenericDao<String, EndUserAccess> {
	public boolean expireAccess(Long u_id);
	public List<String> getAllPushKeys();
	public String getPushKey(Long id);
}


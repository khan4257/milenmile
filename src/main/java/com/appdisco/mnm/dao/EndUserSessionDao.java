/**
 * Project		: MileNMile
 * FileName		: EndUserSessionDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 12:07:09
 */
package com.appdisco.mnm.dao;

import com.appdisco.mnm.model.EndUserSession;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.EndUserSessionDao
 * @file	: EndUserSessionDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 12:07:09
 * </PRE>
 */
public interface EndUserSessionDao extends GenericDao<String, EndUserSession> {
	public boolean expireSession(String access_id);
}

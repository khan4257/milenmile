/**
 * Project		: MileNMile
 * FileName		: UserDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 3:59:02
 */
package com.appdisco.mnm.dao;

import com.appdisco.mnm.model.User;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.UserDao
 * @file	: UserDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 3:59:02
 * </PRE>
 */
public interface UserDao extends GenericDao<Integer, User> {
	public User getUser(String username);
}

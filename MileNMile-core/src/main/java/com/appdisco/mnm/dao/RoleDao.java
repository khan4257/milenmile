/**
 * Project		: MileNMile
 * FileName		: RoleDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 3:56:28
 */
package com.appdisco.mnm.dao;

import com.appdisco.mnm.model.Role;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.RoleDao
 * @file	: RoleDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 3:56:28
 * </PRE>
 */
public interface RoleDao extends GenericDao<Long, Role> {
	public Role getRoleByName(String name);
}

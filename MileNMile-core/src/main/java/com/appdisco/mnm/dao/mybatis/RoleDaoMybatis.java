/**
 * Project		: MileNMile
 * FileName		: RoleDaoMybatis.java
 * Package		: com.appdisco.mnm.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 3:57:57
 */
package com.appdisco.mnm.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.RoleDao;
import com.appdisco.mnm.model.Role;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.RoleDaoMybatis
 * @file	: RoleDaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 3:57:57
 * </PRE>
 */
@Repository
public class RoleDaoMybatis extends BaseDaoMybatis<Long, Role> implements RoleDao {
	
	/**
	 * @param name
	 * @return
	 */
	public Role getRoleByName(String name) {
		return getSqlSessionSEL().selectOne(getKey("getByName"), name);
	}
}

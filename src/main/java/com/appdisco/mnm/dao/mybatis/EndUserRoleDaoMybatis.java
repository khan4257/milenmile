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

import com.appdisco.mnm.dao.EndUserRoleDao;
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
public class EndUserRoleDaoMybatis extends BaseDaoMybatis<Long, Role> implements EndUserRoleDao {
	
	public EndUserRoleDaoMybatis() {
		super("EndUserRole");
	}
	
	/**
	 * @param name
	 * @return
	 */
	public Role getRoleByName(String name) {
		return getSqlSession().selectOne(getKey("getByName"), name);
	}
}

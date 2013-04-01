/**
 * Project		: MileNMile
 * FileName		: RoleService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 4:03:00
 */
package com.appdisco.mnm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdisco.mnm.dao.RoleDao;
import com.appdisco.mnm.model.Role;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.RoleService
 * @file	: RoleService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 4:03:00
 * </PRE>
 */
@Service
public class RoleService extends BaseService {
	@Autowired
	private RoleDao roleDao;
	
	public Role getRole(long role) {
		return roleDao.get(role);
	}
	
	public Role insertRole(Role role) {
		return roleDao.insert(role);
	}
	
	public boolean updateRole(Role role) {
		return roleDao.update(role);
	}
	
	public boolean removeRole(long id) {
		return roleDao.delete(id);
	}
	
}

/**
 * Project		: MileNMile
 * FileName		: UserService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 4:01:47
 */
package com.appdisco.mnm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdisco.mnm.common.dto.SearchOps;
import com.appdisco.mnm.dao.UserDao;
import com.appdisco.mnm.model.Role;
import com.appdisco.mnm.model.User;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.UserService
 * @file	: UserService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 4:01:47
 * </PRE>
 */
@Service
public class UserService extends BaseService {
	@Autowired 
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	public User createUser(User user) {
		return userDao.insert(user);
	}
	
	public boolean updateUser(User user) {
		return userDao.update(user);
	}
	
	public User getUser(int id) {
		return userDao.get(id);
	}
	
	public List<User> getUsers(SearchOps search) {
		return userDao.get(search);
	}
	
	public List<User> getUsersByRole(Role role, int page, int size) {
		SearchOps search = new SearchOps("role", String.valueOf(role.getId()), page, size);
		return this.getUsers(search);
	}
	
	public boolean updateRole(int id, int role) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("role", role);
		return userDao.update(id, params);
	}
	
	public boolean emailActivation(User user) {
		
		return false;
	}
}

/**
 * Project		: MileNMile
 * FileName		: EndUserDaoMybatis.java
 * Package		: com.appdisco.mnm.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 8:09:15
 */
package com.appdisco.mnm.dao.mybatis;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.EndUserDao;
import com.appdisco.mnm.model.EndUser;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.EndUserDaoMybatis
 * @file	: EndUserDaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 8:09:15
 * </PRE>
 */
@Repository
public class EndUserDaoMybatis extends BaseDaoMybatis<Long, EndUser> implements EndUserDao {
	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public Boolean isValidUser(Long id, Integer low_role) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("low_role", low_role);
		return getSqlSessionSEL().selectOne(getKey("chkValidUser"), param);
	}

	/**
	 * @param username
	 * @return
	 */
	@Override
	public Boolean isValidUser(String username, Integer low_role) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("low_role", low_role);
		return getSqlSessionSEL().selectOne(getKey("chkValidUserByUsername"), param);
	}

	/**
	 * @param username
	 * @return
	 */
	@Override
	public Boolean isValidUser(String username, String phone_no, Integer low_role) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("phone_no", phone_no);
		param.put("low_role", low_role);
		
		return getSqlSessionSEL().selectOne(getKey("chkValidUserByPhone"), param);
	}

	/**
	 * @param id
	 * @param password
	 * @return
	 */
	@Override
	public Boolean chkPwd(Long id, String password, Integer low_role) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("password", password);
		param.put("low_role", low_role);
		Boolean ret = getSqlSessionSEL().selectOne(getKey("chkPwdById"), param);
		return ret == null ? false : ret;
	}

	/**
	 * @param id
	 * @param password
	 * @return
	 */
	@Override
	public EndUser chkPwd(String username, String password, Integer low_role) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("password", password);
		param.put("low_role", low_role);
		EndUser ret = getSqlSessionSEL().selectOne(getKey("chkPwdByUsername"), param);
		return ret;
	}
	
	@Override
	public String getUsername(String phone_no, Integer low_role) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("phone_no", phone_no);
		param.put("low_role", low_role);
		return getSqlSessionSEL().selectOne(getKey("getUsernameByPhone"), param);	
	}
}

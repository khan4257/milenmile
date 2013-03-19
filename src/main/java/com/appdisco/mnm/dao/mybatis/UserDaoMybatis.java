/**
 * Project		: MileNMile
 * FileName		: UserDaoMybatis.java
 * Package		: com.appdisco.mnm.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 3:59:36
 */
package com.appdisco.mnm.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.UserDao;
import com.appdisco.mnm.model.User;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.UserDaoMybatis
 * @file	: UserDaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 3:59:36
 * </PRE>
 */
@Repository
public class UserDaoMybatis extends BaseDaoMybatis<Integer, User> implements UserDao {
	
}

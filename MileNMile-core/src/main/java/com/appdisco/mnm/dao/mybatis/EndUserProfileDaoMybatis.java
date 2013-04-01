/**
 * Project		: MileNMile
 * FileName		: EndUserProfileDao.java
 * Package		: com.appdisco.mnm.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 11. 오후 3:18:30
 */
package com.appdisco.mnm.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.EndUserProfileDao;
import com.appdisco.mnm.model.EndUserProfile;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.EndUserProfileDao
 * @file	: EndUserProfileDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 11. 오후 3:18:30
 * </PRE>
 */
@Repository
public class EndUserProfileDaoMybatis extends BaseDaoMybatis<Long, EndUserProfile> implements EndUserProfileDao {

}

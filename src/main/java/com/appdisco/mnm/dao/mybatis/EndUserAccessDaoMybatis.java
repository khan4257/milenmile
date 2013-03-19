/**
 * Project		: MileNMile
 * FileName		: EndUserAccessDaoMybatis.java
 * Package		: com.appdisco.mnm.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 12:07:58
 */
package com.appdisco.mnm.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.EndUserAccessDao;
import com.appdisco.mnm.model.EndUserAccess;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.EndUserAccessDaoMybatis
 * @file	: EndUserSessionDaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 12:07:58
 * </PRE>
 */
@Repository
public class EndUserAccessDaoMybatis extends BaseDaoMybatis<String, EndUserAccess> implements EndUserAccessDao {
	
}

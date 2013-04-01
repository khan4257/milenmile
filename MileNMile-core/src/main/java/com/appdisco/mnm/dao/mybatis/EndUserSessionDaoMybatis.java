/**
 * Project		: MileNMile
 * FileName		: EndUserSessionDaoMybatis.java
 * Package		: com.appdisco.mnm.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 15. 오후 12:07:58
 */
package com.appdisco.mnm.dao.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.EndUserSessionDao;
import com.appdisco.mnm.model.EndUserSession;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.EndUserSessionDaoMybatis
 * @file	: EndUserSessionDaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 15. 오후 12:07:58
 * </PRE>
 */
@Repository
public class EndUserSessionDaoMybatis extends BaseDaoMybatis<String, EndUserSession> implements EndUserSessionDao {
	
	/**
	 * @param access_id
	 * @return
	 */
	public boolean expireSession(String access_id) { 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("access_id", access_id);
		
		int updatedRow = getSqlSessionUPT().update(getKey("expireSession"), params);
		return updatedRow > 0;
	}

	/**
	 * @return
	 */
	@Override
	public boolean clearAllExpiredSession() {
		int deletedRow = getSqlSessionUPT().delete(getKey("clearAllExpiredSession"));
		return deletedRow > 0;
	}
}

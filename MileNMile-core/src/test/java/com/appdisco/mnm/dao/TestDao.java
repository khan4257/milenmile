/**
 * Project		: MileNMile
 * FileName		: TestDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 27. 오후 5:07:20
 */
package com.appdisco.mnm.dao;

import org.junit.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appdisco.mnm.dao.mybatis.support.SqlSessionDaoSupport;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.TestDao
 * @file	: TestDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 27. 오후 5:07:20
 * </PRE>
 */
@Repository
public class TestDao extends SqlSessionDaoSupport {
	static String KEY = "EndUserTest";
	
	@Transactional
	public void clearEndUserTestData() {
		getSqlSessionUPT().delete(getKey("clearEndUserSession"));
		getSqlSessionUPT().delete(getKey("clearEndUserAccess"));
		getSqlSessionUPT().delete(getKey("clearEndUserProfile"));
		getSqlSessionUPT().delete(getKey("clearEndUser"));
	}
	
	public String getKey(String key) {
		return KEY + "." + key;
	}
	
	@Test
	public void test() {
		getKey("clearEndUser");
	}
}

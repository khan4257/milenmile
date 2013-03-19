/**
 * Project		: MileNMile
 * FileName		: GlobalDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 7. 오전 11:37:04
 */
package com.appdisco.mnm.dao;

import com.appdisco.mnm.common.dto.SearchOps;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.GlobalDao
 * @file	: GlobalDao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 7. 오전 11:37:04
 * </PRE>
 */
public interface GlobalDao {
	public <VO> VO get(Class<VO> cls, SearchOps search);
}

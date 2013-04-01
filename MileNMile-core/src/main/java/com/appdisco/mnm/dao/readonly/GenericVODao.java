/**
 * Project		: MileNMile
 * FileName		: GenericVODao.java
 * Package		: com.appdisco.mnm.dao.readonly
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 11. 오후 3:19:49
 */
package com.appdisco.mnm.dao.readonly;

import java.util.List;

import com.appdisco.mnm.common.dto.SearchOps;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.readonly.GenericVODao
 * @file	: GenericVODao.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 11. 오후 3:19:49
 * </PRE>
 */
public interface GenericVODao<PK, T> {
	public T get(PK id);
	public List<T> get(SearchOps search);
	public Long count(SearchOps search);
	public Long count();
}

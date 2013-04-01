/**
 * Project		: MileNMile
 * FileName		: GenericDao.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 7:37:02
 */
package com.appdisco.mnm.dao;

import java.util.List;
import java.util.Map;

import com.appdisco.mnm.common.dto.SearchOps;

/**
 * <PRE>
 * The Interface GenericDao.
 * 
 * package	: com.appdisco.mnm.dao
 *
 * @param <PK> the generic type
 * @param <T> the generic type
 * @class	: GenericDao
 * @file	: GenericDao.java
 * @brief	:
 * @author	: KHAN
 * @date	: 2013. 3. 6 오후 5:12:27
 * </PRE>
 */
public interface GenericDao<PK, T> {
	
	/**
	 * Insert.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T insert(T entity);
	
	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public boolean update(T entity);
	
	/**
	 * Update.
	 *
	 * @param id the id
	 * @param params the params
	 * @return true, if successful
	 */
	public boolean update(PK id, Map<String, Object> params);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean delete(PK id);
	
	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T get(PK id);
	
	/**
	 * Gets the.
	 *
	 * @param search the search
	 * @return the list
	 */
	public List<T> get(SearchOps search);
	
	/**
	 * Gets the all.
	 *
	 * @param search the search
	 * @return the all
	 */
	public List<T> getAll(SearchOps search);
	
	/**
	 * Count all.
	 *
	 * @return the long
	 */
	public Long countAll();
	
	/**
	 * Count.
	 *
	 * @param serarch the serarch
	 * @return the long
	 */
	public Long count(SearchOps serarch);

	/**
	 * Gets the some VO.
	 *
	 * @param <VO> the generic type
	 * @param cls the cls
	 * @param search the search
	 * @return the vo
	 */
	public <VO> VO get(Class<VO> cls, SearchOps search);
}

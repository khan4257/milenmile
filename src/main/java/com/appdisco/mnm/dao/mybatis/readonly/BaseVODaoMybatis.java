/**
 * Project		: MileNMile
 * FileName		: BaseDaoMybatisReadOnly.java
 * Package		: com.appdisco.mnm.dao.mybatis.readonly
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 11. 오후 3:55:11
 */
package com.appdisco.mnm.dao.mybatis.readonly;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdisco.mnm.common.dto.SearchOps;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.readonly.BaseDaoMybatisReadOnly
 * @file	: BaseDaoMybatisReadOnly.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 11. 오후 3:55:11
 * </PRE>
 */
public class BaseVODaoMybatis<PK, T> extends SqlSessionDaoSupport {
	
	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	/** The model. */
	private String model;
	
	/**
	 * Instantiates a new base dao mybatis read only.
	 */
	public BaseVODaoMybatis() {
    	ParameterizedType t = (ParameterizedType)getClass().getGenericSuperclass();
        Type type = t.getActualTypeArguments()[1];
        Class<?> cls = (Class<?>) type;
        this.model = cls.getSimpleName();
	}
	
	/**
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	protected String getModelName() {
		return model;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	protected String getKey(String key) {
		return model + "." + key;
	}
	
	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T get(PK id) {
		return getSqlSession().selectOne(getKey("get"), id);
	}
	
	/**
	 * Gets the.
	 *
	 * @param search the search
	 * @return the list
	 */
	public List<T> get(SearchOps search) {
		return getSqlSession().selectOne(getKey("getList"), search);
	}
	
	/**
	 * Count.
	 *
	 * @param search the search
	 * @return the long
	 */
	public Long count(SearchOps search) {
		return getSqlSession().selectOne(getKey("count"), search);
	}
	
	/**
	 * Count.
	 *
	 * @return the long
	 */
	public Long count() {
		return getSqlSession().selectOne(getKey("countAll"));
	}
}

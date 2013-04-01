/**
 * Project		: OpenSNS
 * FileName		: BaseDaoMybatis.java
 * Package		: com.khan.opensns.dao.mybatis
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 4. 오후 3:42:12
 */
package com.appdisco.mnm.dao.mybatis;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdisco.mnm.common.dto.SearchOps;
import com.appdisco.mnm.dao.mybatis.support.SqlSessionDaoSupport;

/**
 * <PRE>
 * @class	: com.khan.opensns.dao.mybatis.BaseDaoMybatis
 * @file	: BaseDaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 4. 오후 3:42:12
 * </PRE>
 */
public class BaseDaoMybatis<PK, T> extends SqlSessionDaoSupport {

	/** The global key. */
	private String GLOBAL_KEY = "Global.";

	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/** The model. */
	private String model;

	/**
	 * Instantiates a new base dao mybatis.
	 */
	public BaseDaoMybatis() {
		ParameterizedType t = (ParameterizedType) getClass().getGenericSuperclass();
		Type type = t.getActualTypeArguments()[1];
		Class<?> cls = (Class<?>) type;
		this.model = cls.getSimpleName();
	}

	public BaseDaoMybatis(String model) {
		this.model = model;
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

	protected String getGlobalKey(String key) {
		return GLOBAL_KEY + key;
	}

	/**
	 * Insert.
	 * 
	 * @param entity
	 *            the entity
	 * @return the t
	 */
	public T insert(T entity) {
		getSqlSessionUPT().insert(getKey("ins"), entity);
		return entity;
	}

	/**
	 * Update.
	 * 
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 */
	public boolean update(T entity) {
		int updatedRow = getSqlSessionUPT().update(getKey("upt"), entity);
		return updatedRow > 0;
	}

	public boolean update(PK id, Map<String, Object> params) {
		params.put("id", id);
		int updatedRow = getSqlSessionUPT().update(getKey("uptById"), params);
		return updatedRow > 0;
	}

	/**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	public boolean delete(PK id) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("model", transferTB(getModelName()));
		params.put("field", "id");
		params.put("value", id);
		int deletedRow = getSqlSessionUPT().delete(getGlobalKey("del"), params);
		return deletedRow > 0;
	}

	/**
	 * Gets the.
	 * 
	 * @param id
	 *            the id
	 * @return the t
	 */
	public T get(PK id) {
		return getSqlSessionSEL().selectOne(getKey("getFromId"), id);
	}

	/**
	 * Get List.
	 * 
	 * @param search
	 *            the search
	 * @return the list
	 */
	public List<T> get(SearchOps search) {
		return getSqlSessionSEL().selectList(getKey("getList"), search);
	}

	/**
	 * Get All List.
	 * 
	 * @param search
	 *            the search
	 * @return the list
	 */
	public List<T> getAll(SearchOps search) {
		return getSqlSessionSEL().selectList(getKey("getAllList"), search);
	}

	/**
	 * Count all.
	 * 
	 * @return the long
	 */
	public Long countAll() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("model", transferTB(getModelName()));
		return (Long) getSqlSessionSEL().selectOne(getGlobalKey("cnt"), params);
	}

	/**
	 * Count.
	 * 
	 * @param serarch
	 *            the serarch
	 * @return the long
	 */
	public Long count(SearchOps search) {
		return (Long) getSqlSessionSEL().selectOne(getGlobalKey("cnt"), search);
	}

	/**
	 * Gets the some VO.
	 * 
	 * @param <VO>
	 *            the generic type
	 * @param cls
	 *            the cls
	 * @param search
	 *            the search
	 * @return the vo
	 */
	public <VO> VO get(Class<VO> cls, SearchOps search) {
		return getSqlSessionSEL().<VO> selectOne(getGlobalKey("get_" + cls.getSimpleName()), search);
	}

	public Map<String, Object> getOneToMap(SearchOps search) {
		return getSqlSessionSEL().selectOne(getGlobalKey("getOneToMap"), search);
	}

	public List<Map<String, Object>> getListToMap(SearchOps search) {
		return getSqlSessionSEL().selectList(getGlobalKey("getListToMap"), search);
	}

	private static String transferTB(String model) {
		char[] cModel = model.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean addUnderbar = false;
		for (char c : cModel) {
			if (c >= 'A' && c <= 'Z') {
				if (addUnderbar) {
					sb.append("_");
					addUnderbar = false;
				}

				c += 32;
			} else if (c >= 'a' && c <= 'z') {
				addUnderbar = true;
			}

			sb.append(c);
		}

		return sb.toString();
	}
}

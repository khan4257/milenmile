/**
 * Project		: MileNMile
 * FileName		: SqlSessionDaoSupport.java
 * Package		: com.appdisco.mnm.dao
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 19. 오후 4:26:38
 */
package com.appdisco.mnm.dao.mybatis.support;

import static org.springframework.util.Assert.notNull;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.DaoSupport;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.SqlSessionDaoSupport
 * @file	: SqlSessionDaoSupport.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 19. 오후 4:26:38
 * </PRE>
 */
public class SqlSessionDaoSupport extends DaoSupport {

	/** The SQL session update. */
	private SqlSession sqlSessionUPT;
	
	/** The SQL session select. */
	private SqlSession sqlSessionSEL;

	/** The external SQL session. */
	private boolean externalSqlSession;


	/**
	 * Sets the SQL session factory update.
	 *
	 * @param sqlSessionFactoryUPT the new SQL session factory update
	 */
	@Resource(name="sqlSessionFactoryUPT")
	public final void setSqlSessionFactoryUPT(SqlSessionFactory sqlSessionFactoryUPT) {
		if (!this.externalSqlSession) {
			this.sqlSessionUPT = new SqlSessionTemplate(sqlSessionFactoryUPT);
		}
	}

	/**
	 * Sets the SQL session factory select.
	 *
	 * @param sqlSessionFactorySEL the new SQL session factory select
	 */
	@Resource(name="sqlSessionFactorySEL")
	public final void setSqlSessionFactorySEL(SqlSessionFactory sqlSessionFactorySEL) {
		if (!this.externalSqlSession) {
			this.sqlSessionSEL = new SqlSessionTemplate(sqlSessionFactorySEL);
		}
	}

	/**
	 * Sets the SQL session template update.
	 *
	 * @param sqlSessionUPT the new SQL session template update
	 */
	@Resource(name="sqlSessionUPT")
	public final void setSqlSessionTemplateUPT(SqlSessionTemplate sqlSessionUPT) {
		this.sqlSessionUPT = sqlSessionUPT;
		this.externalSqlSession = true;
	}
	
	/**
	 * Sets the SQL session template select.
	 *
	 * @param sqlSessionSEL the new SQL session template select
	 */
	@Resource(name="sqlSessionSEL")
	public final void setSqlSessionTemplateSEL(SqlSessionTemplate sqlSessionSEL) {
		this.sqlSessionSEL = sqlSessionSEL;
		this.externalSqlSession = true;
	}

	/**
	 * Gets the SQL session sel.
	 *
	 * @return the SQL session sel
	 */
	public final SqlSession getSqlSessionSEL() {
		return this.sqlSessionSEL;
	}
	
	/**
	 * Gets the SQL session update.
	 *
	 * @return the SQL session update
	 */
	public final SqlSession getSqlSessionUPT() {
		return this.sqlSessionUPT;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void checkDaoConfig() {
		notNull(this.sqlSessionUPT, "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
		notNull(this.sqlSessionSEL, "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
	}
}

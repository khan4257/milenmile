/**
 * Project		: MileNMile
 * FileName		: EndUserVODaoMybatis.java
 * Package		: com.appdisco.mnm.dao.mybatis.readonly
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 13. 오후 3:50:21
 */
package com.appdisco.mnm.dao.mybatis.readonly;

import org.springframework.stereotype.Repository;

import com.appdisco.mnm.dao.readonly.EndUserVODao;
import com.appdisco.mnm.model.vo.EndUserVO;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.dao.mybatis.readonly.EndUserVODaoMybatis
 * @file	: EndUserVODaoMybatis.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 13. 오후 3:50:21
 * </PRE>
 */
@Repository
public class EndUserVODaoMybatis extends BaseVODaoMybatis<Long, EndUserVO> implements EndUserVODao {

}

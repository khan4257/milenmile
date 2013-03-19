/**
 * Project		: MileNMile
 * FileName		: VO.java
 * Package		: com.appdisco.mnm.model.vo
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 7. 오후 12:15:17
 */
package com.appdisco.mnm.model.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.vo.VO
 * @file	: VO.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 7. 오후 12:15:17
 * </PRE>
 */
public interface VO extends Serializable {
	public VO fromMap(Map<String, Object> map);
}

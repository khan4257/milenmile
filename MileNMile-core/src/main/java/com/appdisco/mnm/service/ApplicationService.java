/**
 * Project		: MileNMile
 * FileName		: ApplicationService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 27. 오후 2:24:31
 */
package com.appdisco.mnm.service;

import org.springframework.stereotype.Service;

import com.appdisco.mnm.common.ApiException;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.ApplicationService
 * @file	: ApplicationService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 27. 오후 2:24:31
 * </PRE>
 */
@Service
public class ApplicationService extends BaseService {
	
	/** TODO
	 * Gets the new version.
	 *
	 * @param locale the locale
	 * @return the new version
	 */
	public String getNewVersion() throws ApiException {
		return null;
	}
}

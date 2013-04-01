/**
 * Project		: MileNMile
 * FileName		: AdsService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 12:10:26
 */
package com.appdisco.mnm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;
import com.appdisco.mnm.common.code.ApiErrorMessages;
import com.appdisco.mnm.common.dto.SearchOps;
import com.appdisco.mnm.common.utils.IdGenerator;
import com.appdisco.mnm.dao.AdsDao;
import com.appdisco.mnm.model.Ad;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.AdsService
 * @file	: AdsService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 12:10:26
 * </PRE>
 */
public class AdsService extends BaseService {
	
	@Autowired
	private AdsDao adsDao;
	
	/**
	 * Creates the ad.
	 *
	 * @param u_id the u_id
	 * @param cost the cost
	 * @param bid the bid
	 * @param type the type
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the ad
	 * @throws ApiException the api exception
	 */
	public Ad createAd(int u_id, int cost, int bid, int type, Date startDate, Date endDate) throws ApiException {
		Ad ad = new Ad();
		ad.setId(IdGenerator.getUUID());
		ad.setSecret(IdGenerator.getSecretCode());
		ad.setU_id(u_id);
		ad.setCost(cost);
		ad.setBid(bid);
		ad.setType(type);
		ad.setStartDate(startDate);
		ad.setEndDate(endDate);
		ad.setApproval(0);
		ad.setReg_date(new Date());
		
		try {
			return adsDao.insert(ad);
		} catch (DataAccessException e) {
			log.error("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
	
	/**
	 * Update ad.
	 *
	 * @param id the id
	 * @param params the params
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean updateAd(String id, Map<String, Object> params) throws ApiException {
		try {
			return adsDao.update(id, params);
		} catch (DataAccessException e) {
			log.error("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
	
	/**
	 * Update ad.
	 *
	 * @param ad the ad
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean updateAd(Ad ad) throws ApiException {
		try {
			return adsDao.update(ad);
		} catch (DataAccessException e) {
			log.error("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
	
	/**
	 * Delete ad.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean deleteAd(String id) throws ApiException {
		try {
			return adsDao.delete(id);
		} catch (DataAccessException e) {
			log.error("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
	
	/**
	 * Gets the ad.
	 *
	 * @param search the search
	 * @return the ad
	 * @throws ApiException the api exception
	 */
	public List<Ad> getAd(SearchOps search) throws ApiException {
		try {
			return adsDao.get(search);
		} catch (DataAccessException e) {
			log.error("DataAccessException", e);
		throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
	
	/**
	 * Gets the ad all.
	 *
	 * @param page the page
	 * @param size the size
	 * @return the ad all
	 * @throws ApiException the api exception
	 */
	public List<Ad> getAdAll(int page, int size) throws ApiException {
		SearchOps search = new SearchOps();
		search.setLimit(page, size);
		return getAd(search);
	}
	
	
}

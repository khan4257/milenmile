/**
 * Project		: MileNMile
 * FileName		: MessageService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 5:24:38
 */
package com.appdisco.mnm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.code.ApiCode;
import com.appdisco.mnm.common.code.ApiErrorMessages;
import com.appdisco.mnm.common.utils.messages.AndroidPushMessage;
import com.appdisco.mnm.common.utils.messages.SendMessageAndroidPush;
import com.appdisco.mnm.common.utils.messages.SendMessageSMS;
import com.appdisco.mnm.dao.EndUserAccessDao;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.MessageService
 * @file	: MessageService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 5:24:38
 * </PRE>
 */

@Service
public class MessageService extends BaseService {
	
	/** The android push. */
	@Autowired
	private SendMessageAndroidPush androidPush;
	
	/** The sms push. */
	@Autowired
	private SendMessageSMS smsPush;
	
	/** The end user access dao. */
	@Autowired 
	private EndUserAccessDao endUserAccessDao;
	
	/**
	 * Push message.
	 *
	 * @param id the id
	 * @param type the type
	 * @param sender the sender
	 * @param content the content
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean pushMessage(Long id, int type, String sender, String content) throws ApiException {
		return pushMessage(getPushKey(id), type, sender, content);
	}
	
	/**
	 * Push message.
	 *
	 * @param target the target
	 * @param type the type
	 * @param sender the sender
	 * @param content the content
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean pushMessage(String target, int type, String sender, String content) throws ApiException {
		AndroidPushMessage pushMessage = new AndroidPushMessage();
		pushMessage.setContent(content);
		pushMessage.setSender(sender);
		pushMessage.setType(type);
		pushMessage.setTarget(target);
		
		return androidPush.sendMessage(pushMessage);
	}
	
	/**
	 * Push message.
	 *
	 * @param type the type
	 * @param sender the sender
	 * @param content the content
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean pushMessageToAll(int type, String sender, String content) throws ApiException {
		return pushMessageToAll(getAllPushKeys(), type, sender, content);
	}
	
	/**
	 * Push message.
	 *
	 * @param targets the targets
	 * @param type the type
	 * @param sender the sender
	 * @param content the content
	 * @return true, if successful
	 * @throws ApiException the api exception
	 */
	public boolean pushMessageToAll(List<String> targets, int type, String sender, String content) throws ApiException {
		AndroidPushMessage pushMessage = new AndroidPushMessage();
		pushMessage.setContent(content);
		pushMessage.setSender(sender);
		pushMessage.setType(type);
		pushMessage.setTargets(targets);
		
		return androidPush.sendMessageAll(pushMessage);
	}
	
	/**
	 * Gets the all push keys.
	 *
	 * @return the all push keys
	 * @throws ApiException the api exception
	 */
	private List<String> getAllPushKeys() throws ApiException {
		try {
			return endUserAccessDao.getAllPushKeys();
		} catch (DataAccessException e) {
			log.warn("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
	
	/**
	 * Gets the push key.
	 *
	 * @param id the id
	 * @return the push key
	 * @throws ApiException the api exception
	 */
	private String getPushKey(Long id) throws ApiException {
		try {
			return endUserAccessDao.getPushKey(id);
		} catch (DataAccessException e) {
			log.warn("DataAccessException", e);
			throw new ApiException(ApiCode.DB_ERROR, getMessage(ApiErrorMessages.DB_ERROR), e);
		}
	}
}

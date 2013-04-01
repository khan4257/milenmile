/**
 * Project		: MileNMile
 * FileName		: SendMessageSMS.java
 * Package		: com.appdisco.mnm.common.utils.messages
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 3:27:02
 */
package com.appdisco.mnm.common.utils.messages;

import org.springframework.stereotype.Service;

import com.appdisco.mnm.common.ApiException;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.utils.messages.SendMessageSMS
 * @file	: SendMessageSMS.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 3:27:02
 * </PRE>
 */
@Service
public class SendMessageSMS implements SendMessage<ClientMessage> {

	/**
	 * @param message
	 * @return
	 * @throws ApiException
	 */
	@Override
	public boolean sendMessage(ClientMessage message) throws ApiException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param message
	 * @return
	 * @throws ApiException
	 */
	@Override
	public boolean sendMessageAll(ClientMessage message) throws ApiException {
		// TODO Auto-generated method stub
		return false;
	}

}

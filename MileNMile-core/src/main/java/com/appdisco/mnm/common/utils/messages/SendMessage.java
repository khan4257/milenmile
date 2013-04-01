/**
 * Project		: MileNMile
 * FileName		: SendMessage.java
 * Package		: com.appdisco.mnm.common.utils.messages
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 3:21:28
 */
package com.appdisco.mnm.common.utils.messages;

import com.appdisco.mnm.common.ApiException;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.utils.messages.SendMessage
 * @file	: SendMessage.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 3:21:28
 * </PRE>
 */
public interface SendMessage<T extends ClientMessage> {
	public boolean sendMessage(T message) throws ApiException;
	public boolean sendMessageAll(T message) throws ApiException;
}

/**
 * Project		: MileNMile
 * FileName		: ClientMessage.java
 * Package		: com.appdisco.mnm.common.utils.messages
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 3:23:22
 */
package com.appdisco.mnm.common.utils.messages;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.utils.messages.ClientMessage
 * @file	: IMessage.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 3:23:22
 * </PRE>
 */
public class ClientMessage {
	
	/** The sender. */
	private String sender;
	
	/** The target. */
	private String target;
	
	/** The targets. */
	private List<String> targets;
	
	/** The content. */
	private String content;
	
	/** The type. */
	private Integer type;
	
	
	/**
	 * @return sender
	 */
	public String getSender() {
		return sender;
	}
	/**
	 * @param sender Set to sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	/**
	 * @return target
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * @param target Set to target
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * @return target
	 */
	public List<String> getTargets() {
		return targets;
	}
	/**
	 * @param target Set to target
	 */
	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content Set to content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}

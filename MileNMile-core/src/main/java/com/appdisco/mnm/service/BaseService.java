/**
 * Project		: MileNMile
 * FileName		: BaseService.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 26. 오후 8:10:33
 */
package com.appdisco.mnm.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.multipart.MultipartFile;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.common.BaseUnit;
import com.appdisco.mnm.common.code.ApiCode;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.BaseService
 * @file	: BaseService.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 26. 오후 8:10:33
 * </PRE>
 */
public abstract class BaseService extends BaseUnit {

	/** The mail engine. */
	@Autowired 
	private MailEngine mailEngine;
	
	/** The mail message. */
	@Autowired
	private SimpleMailMessage mailMessage;
	
	// 메일 발송
    /**
	 * Send email message.
	 *
	 * @param model the model
	 * @param subject the subject
	 * @param locale the locale
	 * @param mailTemplet the mail templet
	 */
	protected void sendEmailMessage(Map<String, Serializable> model, String subject, Locale locale, String mailTemplet) {
    	
    	log.debug("sending email to user [" + model.get("email") + "]...");
        
    	mailMessage.setSubject(subject);
        mailMessage.setTo(String.valueOf(model.get("email")));
        
        log.debug("sended mail : " + mailMessage.toString());
        
        // Reset template by language
        String template = null;
        if (locale != null)
        	template = locale.getLanguage() + "/" + mailTemplet;
        else 
        	template = mailTemplet;
        
        mailEngine.sendMessage(mailMessage, template, model);
    }
    
    /**
     * Upload file.
     *
     * @param dir the dir
     * @param filename the filename
     * @param file the file
     * @throws ApiException the api exception
     */
    public void uploadFile(String dir, String filename, MultipartFile file) throws ApiException {
    	File tmp = new File(dir, filename);
		
		try {
			log.warn("imgDir = " + tmp.getAbsolutePath());
			tmp.createNewFile();
			file.transferTo(tmp);
		} catch (IllegalStateException e) {
			log.warn("IllegalStateException", e);
			throw new ApiException(ApiCode.ETC_ERROR);
		} catch (IOException e) {
			log.warn("IOException", e);
			throw new ApiException(ApiCode.ETC_ERROR);
		}
    }
}

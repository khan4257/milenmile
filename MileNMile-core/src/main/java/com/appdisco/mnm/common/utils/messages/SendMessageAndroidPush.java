/**
 * Project		: MileNMile
 * FileName		: SendMessageAndroidPush.java
 * Package		: com.appdisco.mnm.common.utils.messages
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 21. 오후 4:16:24
 */
package com.appdisco.mnm.common.utils.messages;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.appdisco.mnm.common.ApiException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;


/**
 * <PRE>
 * @class	: com.appdisco.mnm.common.utils.messages.SendMessageAndroidPush
 * @file	: SendMessageAndroidPush.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 21. 오후 4:16:24
 * </PRE>
 */
@Service
public class SendMessageAndroidPush implements SendMessage<AndroidPushMessage> {

	@Value(value="${push.android.gcm.key}")
	private String PUSH_API_KEY;
	
	/**
	 * @param message
	 * @return
	 * @throws ApiException
	 */
	@Override
	public boolean sendMessage(AndroidPushMessage pushMessage) throws ApiException {
		Sender sender = new Sender(PUSH_API_KEY);
		
		Message.Builder message = new Message.Builder();
		message.collapseKey("1");
		
		//TODO Generate and adding push Message Data.
		message.addData("content", pushMessage.getContent());
		message.addData("sender", pushMessage.getSender());
		message.addData("type", pushMessage.getType().toString());
		
		
		try {
			Result result = sender.send(message.build(), pushMessage.getTarget(), 5);
			System.out.println("result : " + result.toString());
			return true;
		} catch (UnsupportedEncodingException e) {
			throw new ApiException(e);
		} catch (IOException e) {
			throw new ApiException(e);
		}
	}

	/**
	 * @param message
	 * @return
	 * @throws ApiException
	 */
	@Override
	public boolean sendMessageAll(AndroidPushMessage pushMessage) throws ApiException {
		Sender sender = new Sender(PUSH_API_KEY);
		
		Message.Builder message = new Message.Builder();
		message.collapseKey("1");
		
		//TODO Generate and adding push Message Data.
		message.addData("content", pushMessage.getContent());
		message.addData("sender", pushMessage.getSender());
		message.addData("type", pushMessage.getType().toString());
		
		try {
			MulticastResult result = sender.send(message.build(), pushMessage.getTargets(), 5);
			System.out.println("result : " + result.toString());
			return true;
		} catch (UnsupportedEncodingException e) {
			throw new ApiException(e);
		} catch (IOException e) {
			throw new ApiException(e);
		}
	}
	
	public static void main(String[] args) {
		SendMessageAndroidPush sendMessage = new SendMessageAndroidPush();
		sendMessage.PUSH_API_KEY = "AIzaSyAq9hoC7hVXys_sOH1FtW5ueinh1Kwmxyk";
		
		List<String> targets = new ArrayList<String>();
		
//		targets.add("APA91bFl7bWnPQlPsm-cgBrYubwzVEwxzGAxm9L4SSnVboEZ1_oXwlgc8LCUhatCZ1jWPr849jg8UDLixbAZQ4gjqL5kx-4-4K3f5Hh5ZPe6SuLCXFI5N_-RK-hRasJiDSZrkaO5-V2ZR7e2Rvny1_2xBWFSWCm2dg");
		String p = "APA91bEqoekV2lzMxvYZzWrumMockNm7S27dMSmxZo_TipQ-wIi0F0kKdIIR31ceF3X8-bM3DVkOIiFTKI4mgSFoltEQwdoHgj_f5r5Vx0uv6uqWtIrKBdJMGezqHl7pkKUEDLoqga-kC0THQK8cQPU8AB0JQr8sng";
		System.err.println("pushkey length=" + p.length());
		targets.add("APA91bEqoekV2lzMxvYZzWrumMockNm7S27dMSmxZo_TipQ-wIi0F0kKdIIR31ceF3X8-bM3DVkOIiFTKI4mgSFoltEQwdoHgj_f5r5Vx0uv6uqWtIrKBdJMGezqHl7pkKUEDLoqga-kC0THQK8cQPU8AB0JQr8sng");
//		targets.add("APA91bEjtdfsDonRprmhNL6KtCpjC5UkiOkbzHFKmyzmXe3f-vonWVseKH3FgQKE6Z5uz6pzEuzOfgOJAKBjXOuna64Xnz3MlC4kYWragMY5jOW0QOwQfwYNwG3zEN8Oh4GRKc9J0d-O_1Z8ZTseZXyNTF_XUmJy1g");
//		targets.add("APA91bE4frpVP8A3hZoeRovWfllHxXghlbb9fumimEzqC4_-9MlPUfLteSvINeUd5NiJrQJnVukFP6gErunW5x3k4jHjKqOwhKo6vzBJtvNbf-yjFmAKHjx-GRFf7rkRGOIovdLgxuMncYo0x1Ftt9p8TffbTYnEAg");
		
		AndroidPushMessage pushMessage = new AndroidPushMessage();
		pushMessage.setSender("milenmile@gmail.com");
		pushMessage.setContent("S 왜안가");
		pushMessage.setType(1);
		
		pushMessage.setTargets(targets);
		
		
		try {
			sendMessage.sendMessageAll(pushMessage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

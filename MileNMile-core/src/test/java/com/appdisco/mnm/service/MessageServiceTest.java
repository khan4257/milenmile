/**
 * Project		: MileNMile
 * FileName		: PushServiceTest.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 22. 오후 2:22:38
 */
package com.appdisco.mnm.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appdisco.mnm.model.vo.EndUserVO;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.PushServiceTest
 * @file	: PushServiceTest.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 22. 오후 2:22:38
 * </PRE>
 */
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/context-root.xml", 
		"file:src/main/webapp/WEB-INF/spring/context-dao_mybatis.xml",
		"file:src/main/webapp/WEB-INF/spring/context-service.xml",  
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
)
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceTest {
	
	static String PUSH_KEY_S = "APA91bFl7bWnPQlPsm-cgBrYubwzVEwxzGAxm9L4SSnVboEZ1_oXwlgc8LCUhatCZ1jWPr849jg8UDLixbAZQ4gjqL5kx-4-4K3f5Hh5ZPe6SuLCXFI5N_-RK-hRasJiDSZrkaO5-V2ZR7e2Rvny1_2xBWFSWCm2dg";
	static String PUSH_KEY_NOTE = "APA91bEqoekV2lzMxvYZzWrumMockNm7S27dMSmxZo_TipQ-wIi0F0kKdIIR31ceF3X8-bM3DVkOIiFTKI4mgSFoltEQwdoHgj_f5r5Vx0uv6uqWtIrKBdJMGezqHl7pkKUEDLoqga-kC0THQK8cQPU8AB0JQr8sng";
	static String PUSH_KEY_LTE2 = "APA91bEATEBKTZq_Tz_RMuCp6qCKPnip-tz1HsbMd10oDLX8E0yc9rgo2AbsgiEjxsSFWkj2yAPPyZyAb2xXVP8Gtw51uF6W0JEthhqmrpjcwtByCUi3iHYvAkokpTy11LW_0REjQoN5";
	static String PUSH_KEY_NOTE2 = "APA91bE4frpVP8A3hZoeRovWfllHxXghlbb9fumimEzqC4_-9MlPUfLteSvINeUd5NiJrQJnVukFP6gErunW5x3k4jHjKqOwhKo6vzBJtvNbf-yjFmAKHjx-GRFf7rkRGOIovdLgxuMncYo0x1Ftt9p8TffbTYnEAg";
	

	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private EndUserService endUserService;
	
	private Map<String, String> map = new HashMap<String, String>();
//	private long endUserId;
	
//	@Before
//	public void setup() throws Exception {
//		endUserId = createAccount().getId();
//		map = createSession();
//	}
	
	@After
	public void clear() throws Exception {
//		removeSession();
	}
	
	@Test
	public void sendPushTest() throws Exception {
////		assertTrue(messageService.pushMessage(PUSH_KEY_S, 1, "milenmile@chocopepper.com", "단일 푸시 서비스 테스트입니당"));
//		assertTrue(messageService.pushMessage(PUSH_KEY_NOTE, 1, "milenmile@chocopepper.com", "단일 푸시 서비스 테스트입니당"));
//		assertTrue(messageService.pushMessage(PUSH_KEY_LTE2, 1, "milenmile@chocopepper.com", "단일 푸시 서비스 테스트입니당"));
//		assertTrue(messageService.pushMessage(PUSH_KEY_NOTE2, 1, "milenmile@chocopepper.com", "단일 푸시 서비스 테스트입니당	"));
	}
	
	@Test
	public void sendPushAllTest() throws Exception {
//		List<String> targets = new ArrayList<String>();
//		targets.add(PUSH_KEY_S);
//		targets.add(PUSH_KEY_NOTE);
//		targets.add(PUSH_KEY_LTE2);
////		targets.add(PUSH_KEY_NOTE2);
//		assertTrue(messageService.pushMessageToAll(targets, 1, "milenmile@chocopepper.com", "단체 푸시 서비스 테스트입니당"));
	}
	
//	@Test
//	public void sendPushTest2() throws Exception {
//		assertTrue(messageService.pushMessage(endUserId, 1, "milenmile@gmail.com", "단일 푸시 서비스 테스트"));
//	}
//	@Test
//	public void sendPushAllTest2() throws Exception {
//		assertTrue(messageService.pushMessageToAll(1, "milenmile@gmail.com", "단체 푸시 서비스 테스트"));
//	}
	
	/**
	 * Creates the account.
	 *
	 * @return the end user
	 * @throws Exception the exception
	 */
	public EndUserVO createAccount() throws Exception {
		EndUserVO endUserVO = endUserService.createAccount("msgtest1@test.com", "test", "test", "01012345678", 1985, 1, false, false, Locale.KOREAN);
//		assertTrue(endUser.getId() > 0);
		return endUserVO;
	}
	
	public Map<String, String> createSession() throws Exception {
		return endUserService.login("msgtest1@test.com", "test", "asdf", PUSH_KEY_NOTE, Locale.KOREAN);
	}
	
	public void removeSession() throws Exception {
		endUserService.deleteAllEndUserInfo(map.get("session"), map.get("access"));
	}
}

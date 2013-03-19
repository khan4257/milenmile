/**
 * Project		: MileNMile
 * FileName		: RoleServiceTest.java
 * Package		: com.appdisco.mnm.service
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 7. 오후 1:14:52
 */
package com.appdisco.mnm.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appdisco.mnm.common.ApiException;
import com.appdisco.mnm.model.EndUser;

/**
 * <PRE>
 * @class	: com.appdisco.mnm.service.RoleServiceTest
 * @file	: RoleServiceTest.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 7. 오후 1:14:52
 * </PRE>
 */
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/context-root.xml", 
		"file:src/main/webapp/WEB-INF/spring/context-dao_mybatis.xml",
		"file:src/main/webapp/WEB-INF/spring/context-service.xml",  
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
)
@RunWith(SpringJUnit4ClassRunner.class)
public class EndUserServiceTest {

	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	/** The end user service. */
	@Autowired
	private EndUserService endUserService;

	/** The end user. */
	private EndUser endUser;
	
	/**
	 * End user test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void endUserTest() throws Exception {
		endUser = createAccount();
		
		chkPassword(endUser.getId(), endUser.getUsername(), endUser.getPassword());
		
		String newPwd = "test1";
		updatePassword(endUser.getId(), endUser.getPassword(), newPwd);
		endUser.setPassword(newPwd);
		
		chkPassword(endUser.getId(), endUser.getUsername(), endUser.getPassword());
		
		
	}
	
	/**
	 * Creates the account.
	 *
	 * @return the end user
	 * @throws Exception the exception
	 */
	public EndUser createAccount() throws Exception {
		EndUser endUser = endUserService.createAccount("test1@test.com", "test", "test", "01012345678", "testestestestestestees", 1985, 1, false, false, Locale.KOREAN);
		assertTrue(endUser.getId() > 0);
		return endUser;
	}
	
	/**
	 * Update password.
	 *
	 * @param id the id
	 * @param password the password
	 * @param newPwd the new pwd
	 * @throws Exception the exception
	 */
	public void updatePassword(Long id, String password, String newPwd) throws Exception {
		assertTrue(endUserService.updatePassword(id, password, newPwd, Locale.KOREAN));
	}
	
	/**
	 * Chk password.
	 *
	 * @param id the id
	 * @param username the username
	 * @param password the password
	 */
	public void chkPassword(Long id, String username, String password) {
		Long[] ids = new Long[]{id, -1l};
		String[] usernames = new String[] {username, "asdf"};
		String[] passwords = new String[] {password, "asdf"};
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				boolean result = false;
				boolean result2 = false;
				try {
					result = endUserService.chkPwd(ids[i], passwords[j]);
				} catch (ApiException e) {
					result = false;
				}
				try {
					result2 = endUserService.chkPwd(usernames[i], passwords[j]) != null;
				} catch (ApiException e) {
					result2 = false;
				}
				
				if (i == 0 && j == 0) {
					assertTrue(result);
					assertTrue(result2);
				} else {
					assertFalse(result);
					assertFalse(result2);
				}
			}
		}
	}
	
	public void updateProfile(Long id, boolean isMarried, boolean haveCar, String job, String loc, String profile) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		param.put("isMarried", isMarried);
		param.put("haveCar", haveCar);
		param.put("job", job);
		param.put("loc", loc);
		param.put("profile", profile);
	}
}

/**
 * Project		: OpenSNS
 * FileName		: ApiTest.java
 * Package		: com.khan.opensns.test.api
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 13. 오전 11:39:41
 */
package com.appdisco.mnm.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;

import com.appdisco.mnm.dao.EndUserAccessDao;
import com.appdisco.mnm.dao.EndUserDao;
import com.appdisco.mnm.dao.EndUserProfileDao;
import com.appdisco.mnm.dao.EndUserSessionDao;
import com.appdisco.mnm.model.EndUser;

/**
 * <PRE>
 * @class	: com.khan.opensns.test.api.ApiTest
 * @file	: ApiTest.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 13. 오전 11:39:41
 * </PRE>
 */
public class EndUserControllerTest extends AbstractControllerTest {

	long testUserId = -1l;
	String access = "";
	String session = "";
	
	@Autowired
	private EndUserDao endUserDao;
	@Autowired
	private EndUserProfileDao endUserProfileDao;
	@Autowired
	private EndUserSessionDao endUserSessionDao;
	@Autowired
	private EndUserAccessDao endUserAccessDao;
	
	@Test
	public void userTest() throws Exception {
		long id = createAccountTest("test2@test.com", "test", "test user", "0123456789012345678901234567890123456789", "01098765432", 1980, 1, false, false);
		loginTest("test2@test.com", "test", "0123456789012345678901234567890123456789", "push_key");

		getProfileFailTest(id);
		getProfileTest(id);
		updateProfileFailTest(id, true, true, "일", "지역", "Profile Test", "C:\\Users\\KHAN\\tear.png");
		updateProfileTest(id, true, true, "일", "지역", "Profile Test", "C:\\Users\\KHAN\\tear.png");
		getProfileTest(id);
	}
	
	@After
	public void clear() {
		endUserProfileDao.delete(testUserId);
		endUserSessionDao.delete(session);
		endUserAccessDao.delete(access);
		endUserDao.delete(testUserId);
	}
	
	public Long createAccountTest(String username, String password, String name, String device_id, String phone_no, int birth_year, int gender, boolean is_married, boolean have_car) throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setMethod("PUT");
		request.setRequestURI(getUrl("createAccount"));
		request.addParameter("username", username );
		request.addParameter("password", password);
		request.addParameter("name", name);
		request.addParameter("device_id", device_id);
		request.addParameter("phone_no", phone_no);
		request.addParameter("birth_year", String.valueOf(birth_year));
		request.addParameter("gender", String.valueOf(gender));
		request.addParameter("is_married", String.valueOf(is_married));
		request.addParameter("have_car", String.valueOf(have_car));
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");

		service(request, response);
				
		JSONObject obj = new JSONObject(response.getContentAsString());
		
		testUserId = findIdFromResponse(obj);
		
		assertThat(testUserId > 0, is(true));
		
		return testUserId;
	}
	
	public String loginTest(String username, String password, String device_id, String push_key) throws Exception {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.setMethod("POST");
		request.setRequestURI(getUrl("login"));
		request.addParameter("username", username);
		request.addParameter("password", password);
		request.addParameter("device_id", device_id);
		request.addParameter("push_key", push_key);
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");
		
		service(request, response);
		
		JSONObject obj = new JSONObject(response.getContentAsString());
		
		access = findAccessIdFromResponse(obj, "access");
		
		session = findAccessIdFromResponse(obj, "session");

		assertThat(access, not(""));
		assertThat(session, not(""));
		
		return access;
	}
	
	public String findAccessIdFromResponse(JSONObject jsonObject, String key) {
		
		try {
			Object obj = jsonObject.getJSONObject("body").getJSONArray("list").get(0);
			if (obj instanceof JSONObject) {
				return ((JSONObject) obj).getString(key);
			} else {
				return "";
			}
		} catch (JSONException je) {
			log.error("json exception", je);
			return "";
		} catch (Exception e) {
			log.error("exception", e);
			return "";
		}
	}
	
	public EndUser getEndUser(Long id) throws Exception {
		return endUserDao.get(id);
	}
	
	public void getProfileTest(Long id) throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.setMethod("POST");
		request.setRequestURI(getUrl("profile", 1, access));
		
		request.addParameter("id", String.valueOf(id));
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");
		
		service(request, response);
	}
	
	public void getProfileFailTest(Long id) throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.setMethod("POST");
		request.setRequestURI(getUrl("profile", 1, "asdf"));
		
		request.addParameter("id", String.valueOf(id));
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");
		
		serviceFail(request, response);
	}

	public void updateProfileTest(Long id, boolean isMarried, boolean haveCar, String job, String loc, String profile, String profile_img) throws Exception {

		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		File imgFile = new File(profile_img);
		InputStream is = new FileInputStream(imgFile);
		
		MockMultipartFile file = new MockMultipartFile("profile_img", is);
		
		request.setMethod("PUT");
		request.setRequestURI(getUrl("profile", 1, access));

		request.addParameter("id", String.valueOf(id));
		request.addParameter("isMarried", String.valueOf(isMarried));
		request.addParameter("haveCar", String.valueOf(haveCar));
		request.addParameter("job", job);
		request.addParameter("loc", loc);
		request.addParameter("profile", profile);
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");
		request.addFile(file);
		
		service(request, response);
	}
	
	public void updateProfileFailTest(Long id, boolean isMarried, boolean haveCar, String job, String loc, String profile, String profile_img) throws Exception {
		
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		File imgFile = new File(profile_img);
		InputStream is = new FileInputStream(imgFile);
		
		MockMultipartFile file = new MockMultipartFile("profile_img", is);
		
		request.setMethod("PUT");
		request.setRequestURI(getUrl("profile", 0, access));

		request.addParameter("id", String.valueOf(id));
		request.addParameter("isMarried", String.valueOf(isMarried));
		request.addParameter("haveCar", String.valueOf(haveCar));
		request.addParameter("job", job);
		request.addParameter("loc", loc);
		request.addParameter("profile", profile);
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");
		request.addFile(file);
		
		serviceFail(request, response);
	}
	
	public void signOut(Long id) throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		
		request.setMethod("POST");
		request.setRequestURI(getUrl("signOut", 1, access));
		request.addParameter("id", String.valueOf(id));
		request.addParameter("country_type", "KR");
		request.addParameter("language", "ko");
		
		service(request, response);
	}

	protected String getUrl(String url) {
		return getUrl(url, 1, true, null);
	}

	protected String getUrl(String url, int version, String access_id) {
		return getUrl(url, version, false, access_id);
	}
	/**
	 * @param url
	 * @return
	 */
	@Override
	protected String getUrl(String url, int version, boolean isNonLogin, String access_id) {
		if (isNonLogin) {
			return "/api/enduser/" + version + "/" + url + ".json";
		} else {
			return "/api/enduser/" + version + "/" + access_id + "/" + url + ".json";
		}
	}
}

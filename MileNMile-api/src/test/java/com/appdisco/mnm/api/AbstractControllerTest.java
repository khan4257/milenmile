/**
 * Project		: OpenSNS
 * FileName		: AbstractControllerTest.java
 * Package		: com.khan.opensns.controllers.api
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 2. 19. 오후 12:16:11
 */
package com.appdisco.mnm.api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.DispatcherServlet;

import com.appdisco.mnm.test.mock.MockWebApplication;
import com.appdisco.mnm.test.mock.MockWebApplicationContextLoader;

/**
 * <PRE>
 * @class	: com.khan.opensns.controllers.api.AbstractControllerTest
 * @file	: AbstractControllerTest.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 2. 19. 오후 12:19:32
 * </PRE>
 */
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/spring/context-root.xml", 
		"file:src/main/webapp/WEB-INF/spring/context-dao_mybatis.xml",
		"file:src/main/webapp/WEB-INF/spring/context-service.xml",  
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		}, 
		loader = MockWebApplicationContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@MockWebApplication(name = "/")
public abstract class AbstractControllerTest {

	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/** The servlet. */
	@Autowired
	private DispatcherServlet servlet;

	/**
	 * Gets the url.
	 * 
	 * @param url
	 *            the url
	 * @return the url
	 */
	protected abstract String getUrl(String url, int version, boolean isNonLogin, String access_id);

	/**
	 * Service.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws Exception
	 *             the exception
	 */
	public void service(MockHttpServletRequest req, MockHttpServletResponse res) throws Exception {
		log.info("\nURL : " + req.getRequestURL().toString());
		servlet.service(req, res);

		log.info("\nResponse : " + formattedJson(res.getContentAsString()));

		assertThat(res.getStatus(), is(200));
	}

	/**
	 * Service.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws Exception
	 *             the exception
	 */
	public void serviceFail(MockHttpServletRequest req, MockHttpServletResponse res) throws Exception {
		log.info("\nURL : " + req.getRequestURL().toString());
		try {
			servlet.service(req, res);
		} catch (Exception e) {
			
		}
		log.info("\nResponse : " + formattedJson(res.getContentAsString()));

		assertThat(res.getStatus(), not(200));
	}
	
	public int findIdFromResponse(JSONObject jsonObject) {
		try {
			Object obj = jsonObject.getJSONObject("body").getJSONArray("list").get(0);
			if (obj instanceof JSONObject) {
				return ((JSONObject) obj).getInt("id");
			} else {
				return -1;
			}
		} catch (JSONException je) {
			log.error("json exception", je);
			return -1;
		} catch (Exception e) {
			log.error("exception", e);
			return -1;
		}
	}
	
	
	static String TAB_STR = "    ";
	public static String formattedJson(String jsonString) {
		StringBuilder sb = new StringBuilder();
		
		char[] ch = jsonString.toCharArray();
		
		int tab = 0;
		for (int idx = 0; idx < ch.length; idx++) {
			char c = ch[idx];
			switch (c) {
			case '{':
			case '[':
				tab++;
				sb.append(c);
				if (idx + 1 < ch.length) {
					if (ch[idx+1] != c + 2) {
						sb.append("\n");
						for (int i = 0; i < tab; i++)
							sb.append(TAB_STR);
					}
				}
				break;
			case '}':
			case ']':
				tab--;
				if (idx - 1 >= 0) {
					if (ch[idx-1] != c - 2) {
						sb.append("\n");
						for (int i = 0; i < tab; i++)
							sb.append(TAB_STR);
					}	
				}
				sb.append(c);
				break;
			case ',':
				sb.append(c).append("\n");
				for (int i = 0; i < tab; i++)
					sb.append(TAB_STR);
				break;
			default:
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
}

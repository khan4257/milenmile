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

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appdisco.mnm.model.Role;

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
public class RoleServiceTest {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RoleService roleService;

	private Role role;
	
	@Test
	public void roleTest() throws Exception {
		insertRole();
		getRole(false);
		updateRole();
		getRole(false);
		deleteRole();
		getRole(true);
	}
	
	public void insertRole() throws Exception {
		role = new Role();
		role.setId(1);
		role.setName("SUPER_ADMIN");
		role.setDescription("Super Administrator");
		
		role = roleService.insertRole(role);
		log.info(role.toString());
		assertTrue(role.getId() > 0);
	}
	
	public void updateRole() {
		role.setName("SUPER_ADMIN");
		role.setDescription("Super Admin Test");
		
		assertTrue(roleService.updateRole(role));
	}
	
	public void getRole(boolean isFailed) {
		Role role = roleService.getRole(this.role.getId());
		
		if (!isFailed)
			assertTrue(this.role.equals(role));
		else
			assertFalse(this.role.equals(role));
	}
	
	public void deleteRole() {
		assertTrue(roleService.removeRole(role.getId()));
	}
}

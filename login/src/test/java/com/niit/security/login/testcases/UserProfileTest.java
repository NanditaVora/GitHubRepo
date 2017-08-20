package com.niit.security.login.testcases;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.security.login.backend.entities.UserProfile;
import com.niit.security.login.backend.model.UserProfileDAO;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=com.niit.security.login.backend.DBConfig.class)
public class UserProfileTest extends TestCase {

	@Autowired
	UserProfileDAO userProfileDAO;
	
	public void testGetAllUsers() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testSaveUser() {
		//fail("Not yet implemented");
		System.out.println("Saving User");
		UserProfile user = new UserProfile();
		user.setLoginID("nandita");
		user.setPassword("nandita@123");
		user.setEmail("nandita@gmail.com");
		System.out.println(userProfileDAO.toString());
		userProfileDAO.saveUser(user);
	}

	public void testGetUserById() {
	//	fail("Not yet implemented");
	}

}

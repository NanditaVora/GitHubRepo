package com.niit.security.login.backend.model;

import java.util.List;
 

import com.niit.security.login.backend.entities.UserProfile;

public interface UserProfileDAO {

	List<UserProfile> getAllUsers();

	UserProfile saveUser(UserProfile user);

	UserProfile getUserById(int id);

	UserProfile login(UserProfile user);
	
}

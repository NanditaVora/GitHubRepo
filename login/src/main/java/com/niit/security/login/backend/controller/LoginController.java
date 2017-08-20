package com.niit.security.login.backend.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.security.login.backend.entities.UserProfile;
import com.niit.security.login.backend.model.UserProfileDAO;

@RestController
public class LoginController {

	@Autowired
	UserProfileDAO userProfileDAO;
	
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody UserProfile user,HttpSession session)
	{
			userProfileDAO.saveUser(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping("/getallusers")
	public  ResponseEntity<List<UserProfile>> getAllUsers(){
		List<UserProfile> users = userProfileDAO.getAllUsers();
		System.out.println(users);
		if(users.isEmpty())
			return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
			else
			return new ResponseEntity<List<UserProfile>>(users,HttpStatus.OK);
 
	}
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserProfile user,HttpSession session){
		UserProfile loggedinuser = userProfileDAO.login(user);
		if(loggedinuser==null)
		{
			Error error = new Error("Invalid Username / Password... Please try again !!");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		else{
			session.setAttribute("loggedinuser", loggedinuser);
			return new ResponseEntity<UserProfile>(loggedinuser,HttpStatus.OK);
			
		}
	}
	@RequestMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		UserProfile user = (UserProfile)session.getAttribute("loggedinuser");
		if(user==null){
			Error error=new Error("Unauthorized User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		session.removeAttribute("loggedinuser");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}

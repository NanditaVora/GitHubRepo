package com.niit.security.login.backend.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.security.login.backend.entities.UserProfile;

//@Repository
public class UserProfileDAOImpl implements UserProfileDAO {

	public UserProfileDAOImpl(SessionFactory sessionFactory){
		System.out.println("Creating DAO IMPL");
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<UserProfile> getAllUsers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserProfile");
		List<UserProfile> users=query.list();
		System.out.println(users);
		session.close();
		return users;
	}

	public UserProfile saveUser(UserProfile user) {
	
		System.out.println("Saving User");
		Session session=sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
		return user;
		
	}

	public UserProfile getUserById(int userid) {
		Session session=sessionFactory.openSession();
		 
		UserProfile user=(UserProfile)session.get(UserProfile.class, userid);
		session.close();
		return user; 
	}

	public UserProfile login(UserProfile user) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from UserProfile where loginid=? and password=?");
		query.setString(0,user.loginID);
		query.setString(1, user.password);
		UserProfile loggedinuser = (UserProfile)query.uniqueResult();
		return loggedinuser;
	}

}

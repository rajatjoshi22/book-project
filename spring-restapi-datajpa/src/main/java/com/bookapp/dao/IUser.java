package com.bookapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.User;
@Repository
public interface IUser extends JpaRepository<User, String> {
	
	@Query("from User u where u.loginId like:loginId and u.password like:password" )
	public User userLogin(String loginId,String password);
}

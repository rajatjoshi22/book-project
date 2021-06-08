package com.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.IUser;
import com.bookapp.exceptions.UserAlreadyExistException;
import com.bookapp.exceptions.UserNotFoundException;
import com.bookapp.model.User;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	IUser userRepository;
	@Override
	public void userSignup(User user) {
		// TODO Auto-generated method stub
		User user1=userRepository.findById(user.getLoginId()).orElse(null);
		if(user1!=null) {
			throw new UserAlreadyExistException("User Already Exist!!!!");
		}
		userRepository.save(user);
	}

	@Override
	public User userLogin(String loginId, String password) {
		// TODO Auto-generated method stub
		User user=userRepository.userLogin(loginId, password);
		if(user==null) {
			throw new UserNotFoundException("Invalid login credentials!!!");
		}
		return user;
	}

	@Override
	public User getUserById(String loginId) {
		// TODO Auto-generated method stub
		return userRepository.findById(loginId).orElseThrow(()->new UserNotFoundException("Invalid loginId!!!!!!"));
	}

	@Override
	public void savePassword(String loginId, String password) {
		// TODO Auto-generated method stub
		  User user=userRepository.findById(loginId).get();
		  user.setPassword(password);
		  userRepository.save(user);
	}

}

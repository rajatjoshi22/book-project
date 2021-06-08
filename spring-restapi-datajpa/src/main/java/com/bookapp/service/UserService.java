package com.bookapp.service;

import com.bookapp.exceptions.UserAlreadyExistException;
import com.bookapp.exceptions.UserNotFoundException;
import com.bookapp.model.User;

public interface UserService {
public void  userSignup(User user) throws UserAlreadyExistException;
public User userLogin(String loginId,String password) throws UserNotFoundException;
public User getUserById(String loginId);
public void savePassword(String loginId,String password);
}

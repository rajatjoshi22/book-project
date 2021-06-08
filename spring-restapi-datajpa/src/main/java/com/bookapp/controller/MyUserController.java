package com.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.User;
import com.bookapp.service.UserService;

@RestController
public class MyUserController {
 
	@Autowired
	UserService userService;
	
	
	@PostMapping("/User")
	public ResponseEntity<String> userSignup(User user){
		HttpStatus status=HttpStatus.ACCEPTED;
		HttpHeaders headers=new HttpHeaders();
		headers.add("message","One User Signup!!!!");
		userService.userSignup(user);
		return ResponseEntity.status(status).headers(headers).body("User Signup Successfull!!!");
	}
	
   @GetMapping("/User")
   public ResponseEntity<User> userLogin(@RequestParam("loginId")String loginId,@RequestParam("password")String password){
	   HttpStatus status=HttpStatus.ACCEPTED;
	   HttpHeaders headers=new HttpHeaders();
	   headers.add("message", "User Logging in!!!!!");
	   User user1=userService.userLogin(loginId,password);
	   return ResponseEntity.status(status).headers(headers).body(user1);
   }
   
   @GetMapping("/user-by-id")
   public ResponseEntity<User> userById(@RequestParam("loginId")String loginId){
	   HttpStatus status=HttpStatus.ACCEPTED;
	   HttpHeaders headers=new HttpHeaders();
	   headers.add("message", "getting one user details!!!!!");
	   User user=userService.getUserById(loginId);
	   return ResponseEntity.status(status).headers(headers).body(user);
   }
   
   
   @PutMapping("/User")
   public ResponseEntity<String> passwordUpdate(User user){
	   HttpStatus status=HttpStatus.ACCEPTED;
	   HttpHeaders headers=new HttpHeaders();
	   headers.add("message", "Updating User!!!!!");
	   userService.savePassword(user.getLoginId(), user.getPassword());
	   return ResponseEntity.status(status).headers(headers).body("Password Updated Successfully!!!!!");
   }
   
}

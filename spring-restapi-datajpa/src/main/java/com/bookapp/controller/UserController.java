package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookapp.model.Book;
import com.bookapp.model.User;
import com.bookapp.service.BookService;
import com.bookapp.service.UserService;

//@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginform";
	}
	
	
	@PostMapping("/login")
	public String adminPage(@ModelAttribute User user,ModelMap model) {
		if(user.getLoginId().equals("admin")&& user.getPassword().equals("admin1234")) {
			model.addAttribute("user",user);
			return "adminpage";
		}
		User loggeduser=userService.userLogin(user.getLoginId(),user.getPassword());
			List<Book> bookList=bookService.getAllBooks();
			model.addAttribute("bookList",bookList);
			model.addAttribute("user",loggeduser);
			return "userpage";
		
	}
	
	@GetMapping("/signupForm")
	public String signupForm() {
		return "usersignup";
	}
	
	@PostMapping("/signup")
	public String userSignup(@ModelAttribute User user,Model model) {
		userService.userSignup(user);
//		if(result==0) {
//			model.addAttribute("message","User already Exist!!!Plzz login");
//			return "loginform";
//		}
		model.addAttribute("message","SignUp Successfull!!!");
		return "loginform";
	}
	
	@GetMapping("/forgottenpassword")
	public String getloginId() {
		return "passwordform";
	}
	
	@PostMapping("/resetpassword")
	public String resetPassword(@ModelAttribute User user,Model model) {
		User loggeduser=userService.getUserById(user.getLoginId());
		if(loggeduser==null) {
			model.addAttribute("message","Invalid login Id");
			return "passwordform";
		}
		model.addAttribute("user",loggeduser);
		return "resetpasswordform";
	}
	
	@PostMapping("/savePassword")
	public String savePassword(@ModelAttribute User user,Model model) {
		userService.savePassword(user.getLoginId(), user.getPassword());
		model.addAttribute("message","Password updated Successfully!!!!");
		return "loginform";
	}
}

package com.bookapp.exceptions;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;

//@ControllerAdvice
@SessionAttributes("message")
public class GlobalExceptionHandler {
@ExceptionHandler(UserNotFoundException.class)
public String handleuserException(UserNotFoundException e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "loginform";
}
@ExceptionHandler(BookNotFoundException.class)
public String handlebookException(BookNotFoundException e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "redirect:/";
}
@ExceptionHandler(SQLException.class)
public String handleOtherException(SQLException e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "signupForm";
}

@ExceptionHandler(BookIdNotFoundException.class)
public String handleIdException(BookIdNotFoundException e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "adminpage";
}

@ExceptionHandler(UserAlreadyExistException.class)
public String handleuserAlreadyException(UserAlreadyExistException e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "loginform";
}

@ExceptionHandler(BookAlreadyExistException.class)
public String BookAlreadyException(UserAlreadyExistException e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "adminpage";
}


@ExceptionHandler(Exception.class)
public String handleOtherException(Exception e,Model model)
{
	model.addAttribute("message",e.getMessage());
	return "redirect:/";
}
}

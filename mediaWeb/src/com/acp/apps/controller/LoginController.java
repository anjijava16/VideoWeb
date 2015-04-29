package com.acp.apps.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acp.apps.form.LoginForm;
import com.acs.apps.validate.ValidateUser;

@Controller
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("input.action")
	public String getRes(HttpServletRequest req) {
		return "login";
	}
	
	@RequestMapping("login.action")
	public String getValidateUser(LoginForm loginForm,BindingResult result,HttpServletRequest request){
        loginForm.setUserName(request.getParameter("userName"));
        loginForm.setPassword(request.getParameter("password"));
		String validate_message=ValidateUser.validateUser(loginForm, result);
	   return "selectSongs";
	}

}

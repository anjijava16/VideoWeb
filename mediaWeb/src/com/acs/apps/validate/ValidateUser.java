package com.acs.apps.validate;

import org.springframework.validation.Errors;

import com.acp.apps.form.LoginForm;

public class ValidateUser {

	public static String VALIDATION_INVALID_USERNAME="Please Enter userName";
	public static String VALIDATION_INVALID_PASSWORD="Please Enter password";
	
	public static String validateUser(LoginForm loginForm,Errors errors){
		String VALID_MESSAGE=" ";
		String userName=loginForm.getUserName();
		String password=loginForm.getPassword();
		
      if(userName==null||userName.trim().length()==0){
    	  errors.rejectValue("userName", "validation.invalid.userid",VALIDATION_INVALID_USERNAME);
    	  VALID_MESSAGE= VALIDATION_INVALID_USERNAME;
      }
      else  if(password==null||password.trim().length()==0){
    	  errors.rejectValue("password", "validation.invalid.password", VALIDATION_INVALID_PASSWORD);
    	  VALID_MESSAGE= VALIDATION_INVALID_PASSWORD;
      }
      else{
    	  VALID_MESSAGE=" "; 
      }
		return VALID_MESSAGE;
	}
}

package com.flickr.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtils {

	public static String setEncryptPassword(String password){
		PasswordEncoder pe= new BCryptPasswordEncoder();
		
		return pe.encode(password);
		
	}
	
	
}

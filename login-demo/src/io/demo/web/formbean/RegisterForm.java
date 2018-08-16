package io.demo.web.formbean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private final String id = generateId();
	
	private Map errors = new HashMap<>();
	
	public boolean validate() {
		
		boolean result = true;
		
		// username cannot be null, and 3-12 characters
		if (username==null || username.trim().equals("")) {
			result = false;
			errors.put("username", "username cannot be empty..");
		} else {
			if (!username.matches("[A-Za-z0-9]{3,12}")) {
				result = false;
				errors.put("username", "username need to be 3-12 characters..");
			}
		}
		
		// password cannot be null, and 6-20 characters
		if (password==null || password.trim().equals("")) {
			result = false;
			errors.put("password", "password cannot be empty..");
		} else {
			if (!password.matches("[A-Za-z0-9]{6,20}")) {
				result = false;
				errors.put("password", "username need to be 6-20 characters..");
			}
		}
		
		// password2 cannot be null, and same as password
		if (password2==null || password2.trim().equals("")) {
			result = false;
			errors.put("password2", "confirmed password cannot be empty..");
		} else {
			if (!password2.trim().equals(password)) {
				result = false;
				errors.put("password2", "confirmed password is different..");
			}
		}
		
		// email cannot be null, and follow format
		if (email==null || email.trim().equals("")) {
			result = false;
			errors.put("email", "email cannot be empty..");
		} else {
			if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
				result = false;
				errors.put("email", "invalid email format..");
			}
		}
		
		return result;
	}
	
	public static String generateId() {
		return UUID.randomUUID().toString();
	}
	
	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

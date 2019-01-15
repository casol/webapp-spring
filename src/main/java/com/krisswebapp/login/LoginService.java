package com.krisswebapp.login;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("Kriss") && password.equals("dummy");
	}

}
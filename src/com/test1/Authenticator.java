package com.test1;

public interface Authenticator {

	public void authen(String userId, String userPwd) throws UserException;
	
}

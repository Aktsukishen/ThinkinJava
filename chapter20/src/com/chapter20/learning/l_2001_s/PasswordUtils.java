package com.chapter20.learning.l_2001_s;

import java.util.List;

public class PasswordUtils {
	
	@UseCase(id=47,description="Password must contain at least one numeric")
	public boolean validatePassword(String password){
		return (password.matches("\\w*\\d\\w*"));
	}

	@UseCase(id=48)
	public String enccryPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id=49,description="New password can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords,String passwords){
		return !prevPasswords.contains(passwords);
	}
}

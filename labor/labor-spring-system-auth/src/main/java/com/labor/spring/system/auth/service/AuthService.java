package com.labor.spring.system.auth.service;

import java.util.Set;

import com.labor.spring.auth.entity.FingerprintOnline;
import com.labor.spring.auth.entity.User;

public interface AuthService {
	
	public User validateNameAndCode(
					String name, String code, String cfmd5, String rememberme);
	public User validateNameAndPassword(
					String name, String saltpwdmd5, String cfmd5, String rememberme, String timestamp);
	public FingerprintOnline createOnline(
					Long userId, 
					String userName, 
					String authCode,
					String authValue, 
					String authType, 
					String fpValue, 
					String fpType, 
					String rememberme);
//	public FingerprintOnline updateOnlineAuthcode(String authValue, String authType);

//	public FingerprintOnline updateOnlineAccessed(String authCode);

//	public FingerprintOnline findOnline(String authValue, String authType);
	
	public FingerprintOnline findOnlineByAuthValue(String authValue);
	
	public void deleteOnline(String authValue, String authType);
	
	
	

	

}

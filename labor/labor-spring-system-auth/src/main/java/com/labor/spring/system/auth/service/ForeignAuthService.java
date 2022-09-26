package com.labor.spring.system.auth.service;

import java.util.Set;

import com.labor.spring.auth.entity.FingerprintOnline;
import com.labor.spring.auth.entity.User;

/***
 * login a user
 * @author Administrator
 *
 */
public interface ForeignAuthService {
	
//	//create login user;
//	public FingerprintOnline createOnline(String fpType,
//								String fpValue,
//								String authType,
//								String authValue,
//								String accountType, 
//								String accountValue);
	
	//delete login user
	public void deleteOnline(String authValue);
	
//	public FingerprintOnline findOnlineByAuthValue(String authValue);

	//update token
	public FingerprintOnline fecthNewAuthValueByOld(String authValue);
	
	//access token by auth_code
	public FingerprintOnline fetchAuthValueByAuthCode(String authCode);
    
	public User findUserByAuthValue(String authValue);
	
	public Set<String> generateUserPermissions(Long userid, String username, String type);

}

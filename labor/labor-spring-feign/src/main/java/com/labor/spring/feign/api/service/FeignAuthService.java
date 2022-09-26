package com.labor.spring.feign.api.service;

import java.util.HashMap;
import java.util.Set;

import com.labor.spring.feign.auth.UserVO;


public interface FeignAuthService {
	
	public String getTokenCache(String key);
	public String setTokenCache(String key, String token);
	
	public UserVO findLoginCache(String accessToken);
	public UserVO findLoginCacheCurrent();
	public UserVO getLoginCacheCurrent();
	
	public UserVO fetchLoginCache(String accessToken);
	public UserVO fetchLoginCacheCurrent();
	
	public Set<String> fetchUserPermissionsCurrent();
	public Set<String> findUserPermissionsCurrent();
	
//	public User findUser(String accessToken);
//	public User fetchUser(String accessToken);
	public HashMap<String, String> fetchLoginUser(String accessToken);
	public String fetchUserToken(String type,String code);
	
	public boolean isCurrentUserOrSuperUser(Long userid, String useruuid);
	
//	public String create(
//					String clientKey,
//					String clientUuid,
//					String type,
//					String code,
//					String name);

	public void delete(String accessToken);
	public void deleteCache();
}

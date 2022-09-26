package com.labor.spring.feign.api.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.labor.common.constants.CommonConstants;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.base.BaseRestController;
import com.labor.spring.bean.ClientRegistered;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultStatus;
import com.labor.spring.constants.WebConstants;
import com.labor.spring.feign.api.AuthFeignClient;
import com.labor.spring.feign.api.service.FeignAuthService;
import com.labor.spring.feign.auth.AuthCacheService;
import com.labor.spring.feign.auth.AuthConstants;
import com.labor.spring.feign.auth.UserVO;
import com.labor.spring.util.IgnorePropertiesUtil;
import com.labor.spring.util.RequiresPermissionsUtil;
import com.labor.spring.util.WebUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/feign/auth")
public class FeignAuthRestController extends BaseRestController{

	@Autowired
	private FeignAuthService feignAuthService;
	
	@Autowired
	private AuthFeignClient authFeignClient;


	/*****
	 * not safe, disabled. login must be done in auth pages;
	 */
//	@ApiOperation("login by cellphone")
//	@RequestMapping(value = {"/logins/cellphone"}, method = RequestMethod.POST)
//	public Result loginByCellPhone(
//					@RequestParam(value="client-key", required=false)String clientKey,
//					@RequestParam(value="client-uuid", required=true)String clientUuid,
//					@RequestParam(value="name", required=true)String name,
//					@RequestParam(value="code", required=true)String code
//					
//			) {
//		HashMap<String, String> ret = null;
//		
////		String clientKey = ClientRegisted.CLIENTKEY_DEFAULT;
////		String clientUuid = "d10e0baa65b43c58d477adcf89e0798a";
////		String type = "sms";
////		String code = "123456";
////		String name = "17655554344";
//		String authCode = null;
//		String accessToken = null;
//		LogManager.getLogger().debug("******create*****");
//		if (StringUtil.isEmpty(clientKey)) {
//			clientKey = baseProperties.getContextName();
//		}
//		String key = feignAuthService.create(clientKey, clientUuid, AuthConstants.LOGINTYPE_CELLPHONE, code, name);
//
//		LogManager.getLogger().debug("******create*****[{}]",key);
//		accessToken = feignAuthService.getTokenCache(key);
//		LogManager.getLogger().debug("get access token from cache key[{}] and token[{}]",key,accessToken);
//		
//		if (StringUtil.isEmpty(accessToken)){
//			return Result.failure(ResultStatus.FAILURE_LOGIN_ACCOUNT_NOTEXIST); 
//		}
//		
//		ret = save2cookie(accessToken);
//		
//		return Result.success(ret);
//	}
	
	@ApiOperation("loggout")
	@RequestMapping(value = {"/logins"}, method = RequestMethod.DELETE)
	public Result logout() {
		String accessToken = WebUtil.getRequest(WebConstants.KEY_ACCESSTOKEN);
		if (StringUtil.isEmpty(accessToken)) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL); 
		}
		feignAuthService.delete(accessToken);
		
		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, "loggout",0);
		
		return Result.success();
	}
	
	//called by rest template , auth code will not return to the pages.
	@ApiOperation("callback url registed in auth return a key for access token saved in cache. authCacheService.getTokenCache(key)")
	@ApiImplicitParam(name="auth-code",value="auth-code",dataType="String", paramType = "path")
	@RequestMapping(value = {"/logins/users/tokens/keys"}, method = RequestMethod.POST)
	public Result requestUserToken(
					@RequestParam(value="auth-code") String authCode) {
	
		String ret = null;
		String accessToken = feignAuthService.fetchUserToken("request-token",authCode);
		if (StringUtil.isEmpty(accessToken)){
			return Result.failure(ResultStatus.FAILURE_LOGIN_ACCOUNT_NOTEXIST);
		}	
		if (!StringUtil.isEmpty(accessToken)) {		
			//dont return the token but the key.
			//save token in cache; client can get the token from the cache. 
			ret = TokenUtil.generateUUID();
			feignAuthService.setTokenCache(ret, accessToken);
			
			//TODO: here: save remote user info to local, if necessary.
			//---->feignAuthService.fetchLoginUser(accessToken);

			
			LogManager.getLogger().debug("save access token to cache key[{}] and token[{}]",ret,accessToken);
			return Result.success(ret);
		} else {
			return Result.failure(ResultStatus.FAILURE_LOGIN_ACCOUNT_NOTEXIST);
		}
		
	}

	
	//initial all the permissions to the auth system by the client key(name) using the feign interface;.
	@RequestMapping(value = {"/permissions/init2auth"}, method = RequestMethod.GET)
	public Result init2auth() {
		Set<String> permissions = new HashSet<String>();
		String clientKey = baseProperties.getContextName();
		if (!StringUtil.isEmpty(clientKey)) {
			List<String> list = WebConstants.RESTCONTROLLER_PAKAGES;
			for (int i=0;i<list.size();i++) {
				String packagename = list.get(i);
				Set<String> perms = RequiresPermissionsUtil.scanRequiresPermissionsValueFromRestController(packagename);
				if (perms!=null&&perms.size()>0) {
					permissions.addAll(perms);
				}
			}
			authFeignClient.updatePermissions(clientKey, permissions);
		}	
		return Result.success(permissions.size());
	}
//	@RequestMapping(value = {"/users"}, method = RequestMethod.PUT)
//	public Result refreshUser(
//					@RequestParam(value = "access-token", required = false) String accessToken) {
//		User ret = null;
//		if (StringUtil.isEmpty(accessToken)) {
//			accessToken = WebUtil.getRequest(WebConstants.KEY_ACCESSTOKEN);
//		}
//		if (StringUtil.isEmpty(accessToken)) {
//			return Result.failure(ResultStatus.FAILURE_PARAM_NULL); 
//		}
//		User remoteuser = feignAuthService.fetchUser(accessToken);
//		if (remoteuser==null) {
//			return null;
//		}
//		//update local user info;
//		User localuser = userService.findByName(remoteuser.getName());
//		
//		if (localuser!=null){
//			remoteuser.setId(localuser.getId());		
//			BeanUtils.copyProperties(remoteuser,localuser,IgnorePropertiesUtil.getNullPropertyNames(remoteuser));
//
//			ret = userService.update(localuser);
//		} else {		
//
//			ret = userService.create(remoteuser.getName(), remoteuser.getSno(), "", remoteuser.getCellPhone(), remoteuser.getWeixin(), remoteuser.getEmail(), "", remoteuser.getUuid(), CommonConstants.ACTIVE);
//		}
//
//        return Result.success(ret);
//	}
	
	@RequestMapping(value = {"/logins/users/current"}, method = RequestMethod.GET)
	public Result findUserCurrent(
					@RequestParam(value="fetch", required=false) String fetch) {
		UserVO ret = null;
		if (StringUtil.isEqualedTrimLower("true", fetch)) {
			ret = feignAuthService.fetchLoginCacheCurrent();
		} else {
			ret = feignAuthService.findLoginCacheCurrent();
		}
		return Result.success(ret);
	}
	
	@RequestMapping(value = {"/logins/users/permissions/current"}, method = RequestMethod.GET)
	public Result findUserPermissionsCurrent(
					@RequestParam(value="fetch", required=false) String fetch) {
		Set<String> ret = null;
		
		if (StringUtil.isEqualedTrimLower("true", fetch)) {
			ret = feignAuthService.fetchUserPermissionsCurrent();
		} else {
			ret = feignAuthService.findUserPermissionsCurrent();
		}
		return Result.success(ret);
		
	}
	
	@RequestMapping(value = {"/logins/cache"}, method = RequestMethod.DELETE)
	public Result deleteCache() {
		feignAuthService.deleteCache();
		return Result.success();
	}
	
	
	
	
	
	
	/*********************
	 * for common use
	 */

//	private HashMap<String, String> save2cookie(String accessToken) {
//		HashMap<String, String> ret = null;
//
//		UserVO lc = feignAuthService.findLoginCache(accessToken);
//		if (lc==null) {
//			return ret; 
//		}
//		
//		//save to cookie
////		String sessionid = WebUtil.getSessionId();
//		//subject.login will save sessionid to cookie
////		WebUtil.setCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME, sessionid);	
//		
//		if (StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER, lc.getUserName())){
//			//super user cookie expired in 10 minutes.
//    		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, accessToken,600);
//		} else {
//    		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, accessToken);
//		}	
//		
//		//return to response
//		ret = new HashMap<String, String>();
//		ret.put(WebConstants.KEY_ACCESSTOKEN, accessToken);
////		ret.put(ShiroHttpSession.DEFAULT_SESSION_ID_NAME, sessionid);
//		
//		LogManager.getLogger().debug("login return query value: [{}]", 
////															ShiroHttpSession.DEFAULT_SESSION_ID_NAME + "=" + sessionid + "&"+
//																	 WebConstants.KEY_ACCESSTOKEN + "=" + accessToken);
//		return ret;
//	}
	

}

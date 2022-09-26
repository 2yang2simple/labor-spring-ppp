package com.labor.spring.system.auth.controller.local;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.beust.jcommander.ParameterException;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.auth.entity.FingerprintOnline;
import com.labor.spring.auth.entity.User;
import com.labor.spring.bean.ClientInfo;
import com.labor.spring.bean.ClientRegistered;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultStatus;
import com.labor.spring.constants.WebConstants;
import com.labor.spring.core.service.SysconfigServiceIntf;
import com.labor.spring.util.WebUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/rest/sso")
public class SSORestController extends AuthBaseRestController{
	
	@Autowired
	private SysconfigServiceIntf sysconfigService;
	
	@ApiOperation("return a key for access token saved in cache. authCacheService.getTokenCache(key)")
	@ApiImplicitParam(name="hm",value="login data",dataType="hashmap", paramType = "body")
    @RequestMapping(value = {"/passwords"}, method = RequestMethod.POST)
	public Result loginByValidatingNameAndPassword(
					HttpServletRequest request,
					HttpServletResponse response,
					@RequestBody HashMap<String, String> hm) {
    	String authValue = TokenUtil.generateUUID();
    	String authType = WebConstants.AUTH_TYPE_SAVEDIN_COOKIES;
		String name = (String)hm.get("name");
		String saltpwdmd5 = (String)hm.get("saltpwdmd5");
		String timestamp = (String)hm.get("timestamp");
		String cfmd5 = (String)hm.get("cfmd5");
		String rememberme = (String)hm.get("rememberme");
		String clientKey = (String)hm.get("clientKey");

		//update client info
		//token saved in cookie of the auth side, client should share the same domain, 
		//so no need to register the client info to grant the privellege.

		
    	Result ret = executeLoginByValidatingNameAndPassword(name,saltpwdmd5,timestamp,cfmd5,rememberme,authValue,authType);
    	if (ResultStatus.SUCCESS.code()==ret.getCode()) {
    		
    		/**************************************************
			 * ************************************************
			 * callback to confirm the login , and the client will save the token
			 * ************************************************
			 */
    		//the auth-code of sso can be accessed directly, no need to callback;
//    		String authCode = StringUtil.safeToString(ret.getData());
//			if (!StringUtil.isEmpty(authCode)) {			
//				RestTemplate restT = new RestTemplate();     
//		        String url = ci.getCallback4AccessToken() + "?auth-code=" + authCode;
//		        url = TokenUtil.addTimestampTokenUrl(url,ci.getSecret());
//		        ret = restT.postForObject(url, null, Result.class);
//			}
			
			//token saved in cookie of the auth pages. 
			//client web url should be in the same domain
			/**********************************************
			 * super user cookie expired in 10 minutes.
			 * super user cookie expired in 10 minutes.
			 * super user cookie expired in 10 minutes.
			 * super user cookie expired in 10 minutes.
			 */
    		if (StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER, name)){
        		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, authValue,600);
    		} else {
        		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, authValue);
    		}
  			
    	}
		return ret; 
	}
	
    //login, request for token, response auchcode
    @RequestMapping(value = {"/codes"}, method = RequestMethod.POST)
	public Result loginByValidatingNameAndCode(
					HttpServletRequest request,
					HttpServletResponse response,
					@RequestBody HashMap<String, String> hm) {
		String name = (String)hm.get("name");
		String code = (String)hm.get("code");
		String cfmd5 = (String)hm.get("cfmd5");
		String rememberme = (String)hm.get("rememberme");
		String clientKey = (String)hm.get("clientKey");
		LogManager.getLogger().debug("name:"+name+"|code:"+code);
		
    	String authValue = TokenUtil.generateUUID();
    	String authType = WebConstants.AUTH_TYPE_SAVEDIN_COOKIES;
    	Result ret = executeLoginByValidatingNameAndCode(name,code,cfmd5,rememberme,authValue,authType);
    	if (ResultStatus.SUCCESS.code()==ret.getCode()) {
    		if (StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER, name)){
    			
    			/**********************************************
    			 * super user cookie expired in 10 minutes.
    			 * super user cookie expired in 10 minutes.
    			 * super user cookie expired in 10 minutes.
    			 * super user cookie expired in 10 minutes.
    			 */
        		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, authValue,600);
    		} else {
        		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, authValue);
    		}
    	}
		return ret; 
	}
    //request for token
    @RequestMapping(value = {"/cfmd5"}, method = RequestMethod.POST)
	public Result loginByCookie(
					HttpServletRequest request,
					HttpServletResponse response,
					@RequestParam(value="cfmd5", required=true) String cfmd5) {

    	FingerprintOnline fo = executeLoginByCookie(cfmd5);
		return Result.success(fo); 
	}
    
	//logout 
    @RequestMapping(value = {""}, method = RequestMethod.DELETE)
	public Result logoutByCookie(
					HttpServletRequest request,
					HttpServletResponse response) {
    	//logout session and shiro
//		WebUtil.setSessionAttribute(WebConstants.KEY_USER, null);
//		WebUtil.setSessionAttribute(WebConstants.KEY_FP, null);
//		WebUtil.setSessionAttribute(WebConstants.KEY_PERMISSION, null);
//		Subject subject = SecurityUtils.getSubject();
//		subject.logout();
		//logout cookies
    	String authValue = WebUtil.getCookie(WebConstants.KEY_ACCESSTOKEN);
    	String authType = WebConstants.AUTH_TYPE_SAVEDIN_COOKIES;
    	executeDelete(authValue, authType);
		WebUtil.setCookie(WebConstants.KEY_ACCESSTOKEN, "loggedout");
		return Result.success(); 
	}

//    //return online user inf by authcode 
//  	@RequestMapping(value = {"/access"}, method = RequestMethod.GET)
//  	public Result accessByOnetimeCode(
//  					HttpServletRequest request,
//  					HttpServletResponse response,
//  					@RequestParam(value="authcode", required=true) String authcode) {
//  		User user = accessByOnetimeCode(authcode);
//  		if (user!=null) {
//  	  		LogManager.getLogger().info("access user:"+((user==null)?"null":user.getName())+"|IP:"+WebUtil.getIpAddress(request));
//  		}
//  		return Result.success(user);
//  	}
}



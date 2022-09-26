package com.labor.spring.system.auth.controller.foreign;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.labor.common.exception.ParameterException;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.auth.entity.FingerprintOnline;
import com.labor.spring.auth.entity.User;
import com.labor.spring.auth.service.PermissionServiceIntf;
import com.labor.spring.auth.service.UserServiceIntf;
import com.labor.spring.bean.ClientInfo;
import com.labor.spring.bean.ClientRegistered;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultStatus;
import com.labor.spring.constants.WebConstants;
import com.labor.spring.core.service.SysconfigServiceIntf;
import com.labor.spring.feign.auth.AuthConstants;
import com.labor.spring.system.auth.service.AuthServiceImpl;
import com.labor.spring.system.auth.service.ForeignAuthService;

import cn.hutool.core.lang.Validator;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/rest/foreign")
public class ForeignAuthRestController {

	@Autowired
	protected ForeignAuthService foreignAuthService;	
	@Autowired
	private UserServiceIntf userService;	
	@Autowired
	private PermissionServiceIntf perService;
	
	/*****
	 * not safe, disabled. 
	 * not safe, dont use api to login. 
     * login must be done in auth pages to avoid transferring the name and password
	 */

//	@ApiOperation("Login a user")
//	@ApiImplicitParams({
//	@ApiImplicitParam(name="client-key",value="client name",dataType="String", paramType = "query"),
//	@ApiImplicitParam(name="client-uuid",value="client uuid",dataType="String", paramType = "query"),
//	@ApiImplicitParam(name="type",value="authetication type: sms/weixin",dataType="String", paramType = "query"),
//	@ApiImplicitParam(name="code",value="sms code or weiixn passcode",dataType="String", paramType = "query"),
//	@ApiImplicitParam(name="name",value="sms or weixin name",dataType="String", paramType = "query")})
//	@RequestMapping(value = {"/logins"}, method = RequestMethod.POST)
//	public Result login(
//					@RequestParam(value="client-key", required=true)String clientKey,
//					@RequestParam(value="client-uuid", required=true)String clientUuid,
//					@RequestParam(value="type", required=true)String type,
//					@RequestParam(value="code", required=true)String code,
//					@RequestParam(value="name", required=true)String name) {
//		
//		LogManager.getLogger().debug("--auth-login---"+name);
//		
//		String ret = null;
//		
//		//update client info
//		String clientinfo = sysconfigService.findValueByKey(ClientRegisted.getPrefix()+clientKey);
//		ClientRegisted.putClientInfo(clientinfo);
//		
//		ClientInfo ci = ClientRegisted.getClientInfo(clientKey);
//		if (ci==null) {
//			throw new ParameterException("client not registed.");
//		}
//
//		FingerprintOnline fo = null;
//
//		//administrator login
//		if (StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER, name)) {
//			
//			fo = foreignAuthService.createOnline(ci.getFpType(), clientUuid, ci.getAuthType(), TokenUtil.generateUUID(), AuthConstants.LOGINTYPE_NAME, name);
//			
//		} else if (StringUtil.isEqualedTrimLower(type, AuthConstants.LOGINTYPE_CELLPHONE)) {
//			//name is the cellphone number
//			//code is the number sent to cellphone, also stored in db;
//			//validate the code and name
//			if(!Validator.isMobile(name)){
//				return Result.failure(ResultStatus.FAILURE_PARAM_INVALID);
//			}
//			//create a account by cellphone
//			fo = foreignAuthService.createOnline(ci.getFpType(), clientUuid, ci.getAuthType(), TokenUtil.generateUUID(), type, name);
//		
//			
//			
//    	} else if (StringUtil.isEqualedTrimLower(type, AuthConstants.LOGINTYPE_WEIXIN)) {
//    		//name is the weixin number
//    		
//    		//code is the sessionkey, openid etc something weixin returned
//    		
//    		//validate the code and name
//    	} else if (StringUtil.isEqualedTrimLower(type, AuthConstants.LOGINTYPE_EMAIL)) {
//    		//name is the email
//    		
//    		//code is the code received by email
//    		
//    		//validate the code and name
//    		if(!Validator.isEmail(name)){
//				return Result.failure(ResultStatus.FAILURE_PARAM_INVALID);
//			}
//    	} else {
//    		return Result.failure(ResultStatus.FAILURE_PARAM_INVALID.code(),"type error.");
//    	}
//		
//		/**************************************************
//		 * ************************************************
//		 * callback to confirm the login , and save token on client
//		 * ************************************************
//		 */
//		if (fo!=null&&!StringUtil.isEmpty(fo.getAuthCode())) {
//			LogManager.getLogger().debug("--auth-login---"+3);
//			
//			//administrator can not login on the app;
//			if (StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER,fo.getUserName())
//					&&!StringUtil.isEqualedTrimLower(WebConstants.AUTH_TYPE_SAVEDIN_COOKIES,ci.getAuthType())){
//				foreignAuthService.deleteOnline(fo.getAuthValue());
//				LogManager.getLogger().trace("Administrator can only be logged on from the WEB client. [{}]",fo.getAuthValue());
//				return Result.failure(ResultStatus.FAILURE_LOGIN_ADMIN_FORBID);
//			}
//			
//			RestTemplate restT = new RestTemplate();     
//	        String url = ci.getCallback4AccessToken() + "?auth-code=" + fo.getAuthCode();
//	        url = TokenUtil.addTimestampTokenUrl(url,ci.getSecret());
//	        Result result = restT.postForObject(url, null, Result.class);
//	        
//	        LogManager.getLogger().debug("--auth-login---"+url);
//	        if (result.getCode() == ResultStatus.SUCCESS.code()) {			
//	        	String accessTokenKey = (String) result.getData();
//	        	LogManager.getLogger().debug("--auth-login---"+accessTokenKey);
//	        	if (!StringUtil.isEmpty(accessTokenKey)) {
//	        		return Result.success(accessTokenKey);
//	        	}
//	        }
//	        LogManager.getLogger().debug("--auth-login---"+6);
//		}
//		//return auth-code
////		if (fo!=null&&!StringUtil.isEmpty(fo.getAuthCode())) {
////	        ret =  fo.getAuthCode();
////		}
//		
//		return Result.success(ret);
//	}
	
	@ApiOperation("Loggout a user")
	@ApiImplicitParam(name="code",value="access-token",dataType="String", paramType = "query")
	@RequestMapping(value = { "/logins" }, method = RequestMethod.DELETE)
	public void logout(
					@RequestParam(value = "code", required = true) String code) {
		foreignAuthService.deleteOnline(code);
	}
	
	@ApiOperation("Find a login user")
	@ApiImplicitParam(name="code",value="access-token",dataType="String", paramType = "query")
  	@RequestMapping(value = {"/logins/users"}, method = RequestMethod.GET)
  	public Result findLoginUser(
  					@RequestParam(value = "code", required = true) String code) {
  		User ret = null;
  		ret = foreignAuthService.findUserByAuthValue(code);
  		if (ret!=null) {
  			ret.setPwdmodify(null);
  			ret.setGoogleSecretKey(null);
  		}
  		return Result.success(ret);
  	}
  	
	@ApiOperation("Fetch a user access-token")
	@ApiImplicitParams({
	@ApiImplicitParam(name="type",value="request-token,refresh-token",dataType="String", paramType = "query"),
	@ApiImplicitParam(name="code",value="auth-code,access-token",dataType="String", paramType = "query")})
	@RequestMapping(value = { "/logins/users/tokens" }, method = RequestMethod.POST)
	public Result fetchLoginUserToken(
					@RequestParam(value = "type", required = true) String type,
					@RequestParam(value = "code", required = true) String code) {

		String ret = null;
		FingerprintOnline fo = null;
		if (StringUtil.isEqualedTrimLower(type, "request-token")) {
			fo = foreignAuthService.fetchAuthValueByAuthCode(code);
		} else if (StringUtil.isEqualedTrimLower(type, "refresh-token")) {
			fo = foreignAuthService.fecthNewAuthValueByOld(code);
		} 
		if (fo != null) {
			ret = fo.getAuthValue();
		}
		return Result.success(ret);
	}
	
	@ApiOperation("Update permissions by type")
	@ApiImplicitParams({
	@ApiImplicitParam(name="client-key",value="client name",dataType="String", paramType = "query"),
	@ApiImplicitParam(name="permissions",value="permissions list",dataType="String", paramType = "query")})
	@RequestMapping(value = { "/permissions/{client-key}" }, method = RequestMethod.PUT)
	public Result updatePermissions(
				@PathVariable(value="client-key") String clientKey, 
				@RequestBody Set<String> permissions) {
		
		if (StringUtil.isEmpty(clientKey)) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"client key is null");
		}
		
//		String perType = sysconfigService.findValueByKey(PREFIX_PERMISSION_TYPE+type);
		String perType = ClientRegistered.getName(clientKey);
		if (StringUtil.isEmpty(perType)) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"permission type not exist");
		}
		
		if (permissions==null||permissions.size()==0) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"permissions is null");
		}
		
		perService.updateByType(permissions, perType);
		
		return Result.success();
	}
	
	@ApiOperation("Find user permissions")
	@ApiImplicitParams({
	@ApiImplicitParam(name="client-key",value="client name",dataType="String", paramType = "query"),
	@ApiImplicitParam(name="uuid",value="user uuid",dataType="String", paramType = "query")})
	@RequestMapping(value = { "/permissions/{client-key}/{uuid}" }, method = RequestMethod.GET)
	public Result findPermissions(
				@PathVariable(value="client-key") String clientKey, 
				@PathVariable(value="uuid") String uuid) {
		
		if (StringUtil.isEmpty(clientKey)) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"client key is null");
		}
		
//		String perType = sysconfigService.findValueByKey(PREFIX_PERMISSION_TYPE+type);
		String perType = ClientRegistered.getName(clientKey);
		if (StringUtil.isEmpty(perType)) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"permission type not exist");
		}
		
		if (StringUtil.isEmpty(uuid)) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"uuid is null");
		}
		User user = userService.findByUuid(uuid);
		if (user==null) {
			return Result.failure(ResultStatus.FAILURE_PARAM_NULL.code(),"user not exist");
		}
		
		Set<String> permissions  = foreignAuthService.generateUserPermissions(user.getId(), user.getName(), perType);
		
		return Result.success(permissions);
	}
}

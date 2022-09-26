package com.labor.spring.system.auth.controller.local;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.labor.common.constants.CommonConstants;
import com.labor.common.util.QRCodeUtil;
import com.labor.common.util.RSAUtil;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.auth.entity.FingerprintOnline;
import com.labor.spring.auth.entity.User;
import com.labor.spring.auth.service.FingerprintServiceIntf;
import com.labor.spring.auth.service.UserServiceIntf;
import com.labor.spring.base.BaseRestController;
import com.labor.spring.bean.Result;
import com.labor.spring.bean.ResultStatus;
import com.labor.spring.constants.WebConstants;
import com.labor.spring.util.WebUtil;
import com.labor.spring.core.service.SysconfigConstants;
import com.labor.spring.system.auth.service.AuthService;

@RestController
public class AuthBaseRestController extends BaseRestController{
	
	@Autowired
	protected AuthService authService;		
	@Autowired
	protected UserServiceIntf userService;	



/**************************************************************
 * protected action
 */

    /***
     * validate the google code, create a online user , return the authorization code
     * @param name
     * @param code
     * @param cfmd5
     * @param rememberme
     * @param authValue
     * @param authType
     * @return
     */
    protected Result executeLoginByValidatingNameAndCode(
    				String name, String code,
    				String cfmd5, String rememberme,
    				String authValue, String authType) {
    	String ret = null;
		
		//1 validating
		User loginuser = authService.validateNameAndCode(name, code, cfmd5, rememberme);
		if (loginuser==null){
			return Result.failure(ResultStatus.FAILURE_LOGIN); 
		}
		if (!CommonConstants.ACTIVE.equals(loginuser.getStatus())
				&&!StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER,loginuser.getName())){
			return Result.failure(ResultStatus.FAILURE_LOGIN_ACCOUNT_CLOSED); 
		}
		//2, create online, the auth-code of sso can be accessed directly, no need to callback;
		FingerprintOnline fo = authService.createOnline(
									loginuser.getId(),loginuser.getName(), 
									WebConstants.STATUS_LOGIN_ACCESSED,authValue, authType,
									cfmd5, WebConstants.FP_TYPE_CANVAS,
									rememberme);
		//3, return authorization code
		if (fo!=null) {
			ret = fo.getAuthCode();
		}
		return Result.success(ret); 
    }
    
    /***
     * validate the password, create a online user , return the authorization code
     * @param name
     * @param saltpwdmd5
     * @param timestamp
     * @param cfmd5
     * @param rememberme
     * @param authValue
     * @param authType
     * @return
     */
    protected Result executeLoginByValidatingNameAndPassword(
    				String name,  String saltpwdmd5, String timestamp,
    				String cfmd5, String rememberme,
    				String authValue, String authType) {
    	String ret = null;	
		//1 validating
		User loginuser = authService.validateNameAndPassword(name, saltpwdmd5, cfmd5, rememberme, timestamp);
		if (loginuser==null){
			return Result.failure(ResultStatus.FAILURE_LOGIN); 
		}
		if (!CommonConstants.ACTIVE.equals(loginuser.getStatus())
				&&!StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER,loginuser.getName())){
			return Result.failure(ResultStatus.FAILURE_LOGIN_ACCOUNT_CLOSED); 
		}
		//2, create online
		FingerprintOnline fo = authService.createOnline(
									loginuser.getId(),loginuser.getName(), 
									WebConstants.STATUS_LOGIN_ACCESSED,authValue, authType,
									cfmd5, WebConstants.FP_TYPE_CANVAS,
									rememberme);
		//3, return authorization code
		if (fo!=null) {
			ret = fo.getAuthCode();
		}
		return Result.success(ret); 
    }
    
//    /***
//     * refresh the authcode of a online user, 
//     * if failed, return a user login before;
//     * @param cfmd5
//     * @param authValue
//     * @param authType
//     * @return
//     */
//    protected FingerprintOnline executeUpdateAuthcode(String cfmd5, String authValue, String authType) {
//    	FingerprintOnline ret = null;
//    	//1,update authcode if online exist;
//    	FingerprintOnline fo = authService.updateOnlineAuthcode(authValue, authType);
//    	
//    	//2,return the authorization code;
//		if (fo!=null) {
//			ret = new FingerprintOnline();
//			ret.setAuthCode(fo.getAuthCode());
//			
//		//3, if online not exist, find a user login before and return the user name;
//		} else {
//			User user = userService.findFirstByValueAndType(cfmd5, WebConstants.FP_TYPE_CANVAS);
//			if (user!=null) {
//				ret = new FingerprintOnline();
//				ret.setUserName(user.getName());
//				ret.setDescription(user.getDescription());
//			}
//		}
//		return ret; 
//    }
  	
	  /***
	  * login by token saved in cookie
	  * if failed, return a user login before;
	  * @param cfmd5
	  * @param authValue
	  * @param authType
	  * @return
	  */
	 protected FingerprintOnline executeLoginByCookie(String cfmd5) {
	 	FingerprintOnline ret = null;
    	String authValue = WebUtil.getCookie(WebConstants.KEY_ACCESSTOKEN);
    	String authType = WebConstants.AUTH_TYPE_SAVEDIN_COOKIES;
    	
	 	//1,update authcode if online exist;
	 	FingerprintOnline fo = authService.findOnlineByAuthValue(authType);
	 	
	 	//2,return the authorization code;
			if (fo!=null&&StringUtil.isEqualedTrimLower(WebConstants.STATUS_LOGIN_ACCESSED, fo.getAuthCode())) {
				ret = new FingerprintOnline();
				ret.setAuthCode(WebConstants.STATUS_LOGIN_ACCESSED);
				
			//3, if online not exist, find a user login before and return the user name;
			} else {
				User user = userService.findFirstByValueAndType(cfmd5, WebConstants.FP_TYPE_CANVAS);
				if (user!=null) {
					ret = new FingerprintOnline();
					ret.setUserName(user.getName());
					ret.setDescription(user.getDescription());
				}
			}
			return ret; 
	 } 
    
    
    /**
     * delete the online user
     * @param authValue
     * @param authType
     */
    protected void executeDelete(String authValue, String authType) {
		authService.deleteOnline(authValue, authType);
    }
    
//    /***
//     * for sso login, access user info one time after login
//     * @param authcode
//     * @return
//     */
//    protected User accessByOnetimeCode(String authcode) {
//  		User ret = null;
//  		FingerprintOnline fo = authService.updateOnlineAccessed(authcode);
//  		if (fo!=null) {
//  			ret = userService.findById(fo.getUserId());
//  		}
//  		if (ret!=null) {
//  			ret.setPwdmodify(null);
//  			ret.setGoogleSecretKey(null);
//  		}
//  		return ret;
//  	}
//    
//    /***
//     * for client login, token saved in app or somewhere, 
//     * request with token in header, validating the token, 
//     * return the granted fields of the user.
//     * @param authValue
//     * @param authType
//     * @return
//     */
//    protected User accessByToken(String authValue, String authType){
//  		User ret = null;
//  		FingerprintOnline fo = authService.findOnline(authValue,authType);
//  		if (fo!=null) {
//  			ret = userService.findById(fo.getUserId());
//  		}
//  		if (ret!=null) {
//  			//validate token authorization, return the granted fields of the user;
//  			//token saved in a table with the information of the granted fields
//  			// authValue --- name --- phone --- email ---ext..
//  			ret.setPwdmodify(null);
//  			ret.setGoogleSecretKey(null);
//  		}
//  		//TODO: under construction, token should be validating the authorised fields
//  		return null;
//  	}
}



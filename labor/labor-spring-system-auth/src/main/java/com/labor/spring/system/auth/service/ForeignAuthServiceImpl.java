package com.labor.spring.system.auth.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labor.common.constants.CommonConstants;
import com.labor.common.exception.PermissionException;
import com.labor.common.exception.ServiceException;
import com.labor.common.util.StringUtil;
import com.labor.common.util.TokenUtil;
import com.labor.spring.auth.entity.Fingerprint;
import com.labor.spring.auth.entity.FingerprintOnline;
import com.labor.spring.auth.entity.Permission;
import com.labor.spring.auth.entity.Role;
import com.labor.spring.auth.entity.User;
import com.labor.spring.auth.service.FingerprintServiceIntf;
import com.labor.spring.auth.service.PermissionServiceIntf;
import com.labor.spring.auth.service.RoleServiceIntf;
import com.labor.spring.auth.service.UserServiceIntf;
import com.labor.spring.bean.ResultStatus;
import com.labor.spring.constants.WebConstants;
import com.labor.spring.feign.auth.AuthConstants;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ObjectUtil;

@Service
public class ForeignAuthServiceImpl implements ForeignAuthService {
	
	@Autowired
	private UserServiceIntf userService;
	@Autowired
	private FingerprintServiceIntf fpService;
	@Autowired
	private PermissionServiceIntf perService;	
	@Autowired
	private RoleServiceIntf roleService;
	
//	@Override
//	@Transactional
//	public FingerprintOnline createOnline(String fpType,
//										String fpValue,
//										String authType,
//										String authValue,
//										String accountType, 
//										String accountValue) {
//		FingerprintOnline ret = null;
//		//must have 
//		//client_type(fptype) and client_uuid(fp_value) 
//		//authType(web or app) and authValue(token)
//		//accountType (weixin,cellphone,email) and accountValue
//		LogManager.getLogger().debug("--createOnline--"+0);
//		if (StringUtil.isEmpty(fpType)
//				||StringUtil.isEmpty(fpValue)
//				||StringUtil.isEmpty(authType)
//				||StringUtil.isEmpty(authValue)
//				||StringUtil.isEmpty(accountType)
//				||StringUtil.isEmpty(accountValue)) {
//			
//			throw new ServiceException(ResultStatus.FAILURE_PARAM_NULL.msg());
//		}
//		LogManager.getLogger().debug("--createOnline--"+1);
//		//find or create user
//		String cellPhone=null;
//		String weixin=null;
//		String email=null;
//		String name=null;
//		User user = null;
//
//		if (StringUtil.isEqualedTrimLower(AuthConstants.LOGINTYPE_NAME, accountType)) {
//			name = accountValue;
//			user = userService.findByName(name);
//			LogManager.getLogger().debug("--createOnline--name");
//			
//		} else if (StringUtil.isEqualedTrimLower(AuthConstants.LOGINTYPE_CELLPHONE, accountType)) {
//			cellPhone = accountValue;
//			user = userService.findByCellPhone(cellPhone);
//			LogManager.getLogger().debug("--createOnline--cellPhone");
//			
//		} else if (StringUtil.isEqualedTrimLower(AuthConstants.LOGINTYPE_WEIXIN, accountType)) {
//			weixin = accountValue;
//			user = userService.findByWeixin(weixin);
//			LogManager.getLogger().debug("--createOnline--weixin");
//			
//		} else if (StringUtil.isEqualedTrimLower(AuthConstants.LOGINTYPE_EMAIL, accountType)) {
//			email = accountValue;
//			user = userService.findByEmail(email);
//			LogManager.getLogger().debug("--createOnline--email");
//			
//		} else {
//			throw new ServiceException("account type error.");
//		}
//		
//		LogManager.getLogger().debug("--createOnline--"+2);
//		
//		//cannot create a administrator
//		if (ObjectUtil.isEmpty(user)&&!StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER, name)) {
//			user = userService.create(name, null, null, cellPhone, weixin, email, null, null, CommonConstants.ACTIVE);
//			LogManager.getLogger().debug("--createOnline--xxx");
//		}	
//		if (ObjectUtil.isEmpty(user)) {
//			LogManager.getLogger().debug("--createOnline--ttt");
//			throw new ServiceException("create user error.");
//		}
//		if (StringUtil.isEmpty(user.getStatus())
//				|| !StringUtil.isEqualedTrimLower(user.getStatus(), CommonConstants.ACTIVE)) {
//			LogManager.getLogger().debug("--createOnline--getStatus");
//			throw new PermissionException("auth account is closed.");
//		}
//		LogManager.getLogger().debug("--createOnline--"+5);
//		
//		//find or create fingerprint
//		Fingerprint fp = fpService.create(fpValue, fpType);
//		if(fp==null) {
//			throw new ServiceException("fingerprint create error.");
//		}
//		LogManager.getLogger().debug("--createOnline--"+3);
//		if(!CommonConstants.ACTIVE.equals(fp.getStatus())) {
//			fp.setStatus(CommonConstants.ACTIVE);
//			fpService.update(fp.getId(), fp, true);
//		}	
//		LogManager.getLogger().debug("--createOnline--"+4);
//
//		//create user fingerprint
//		userService.createUserFingerprint(fp.getValue(), fp.getType(), fp.getId(), user.getId(), CommonConstants.INACTIVE);
//
//		LogManager.getLogger().debug("--createOnline--"+6);
//		//create fingerprint online
//		FingerprintOnline fo = new FingerprintOnline();
//		fo.setUserId(user.getId());
//		fo.setUserName(user.getName());
//		fo.setFpId(fp.getId());
//		fo.setFpValue(fpValue);
//		fo.setFpType(fpType);
//		String authCode = TokenUtil.generateUUID();
//		fo.setAuthCode(authCode);
//		fo.setAuthType(authType);
//		fo.setAuthValue(authValue);
//		ret = fpService.saveOnline(user.getId(),fpType,fpValue,authType,authValue,fo,true);
//		return ret;
//	}
	
//	@Override
//	public FingerprintOnline findOnlineByAuthValue(String authValue) {
//		FingerprintOnline ret = null;
//		ret = fpService.findFoByAuthValue(authValue);
//		return ret;
//	}
	
	@Override
	public User findUserByAuthValue(String authValue) {
		User ret = null;
		FingerprintOnline fo = null;
		fo = fpService.findFoByAuthValue(authValue);
		if (fo!=null
				//fingerprint online should be accessed. once request token by auth code
				&&StringUtil.isEqualedTrimLower(WebConstants.STATUS_LOGIN_ACCESSED, fo.getAuthCode())) {
			ret = userService.findById(fo.getUserId());
		}
		if (ret!=null) {
			ret.setPwdmodify(null);
			ret.setGoogleSecretKey(null);
		}
		return ret;
	}
	
	@Override
	@Transactional
	public void deleteOnline(String authValue) {
		fpService.deleteOnlineByAuthValue(authValue);
	}

	@Override
	@Transactional
	public FingerprintOnline fecthNewAuthValueByOld(String authValue) {
		FingerprintOnline ret = null;
		FingerprintOnline fo = fpService.findFoByAuthValue(authValue);
    	if (fo!=null&&fo.getUserId()!=null&&fo.getUserId()>0&&fo.getUserName()!=null) {
    		String newAuthValue = TokenUtil.generateUUID();
    		fo.setAuthValue(newAuthValue);
    		ret = fpService.saveOnline(null,null,null,null,authValue, fo, true);
    	}
		return ret;
	}

	@Override
	@Transactional
	public FingerprintOnline fetchAuthValueByAuthCode(String authCode) {
		FingerprintOnline ret = null;
		if (StringUtil.isEmpty(authCode)
				||StringUtil.isEqualedTrimLower(
						WebConstants.STATUS_LOGIN_ACCESSED, authCode)) {
			return ret;
		}
		FingerprintOnline fo = fpService.findFoByAuthCode(authCode);
		if (fo==null) {
			return ret;
		}
		//set token disposable;
		fo.setAuthCode(WebConstants.STATUS_LOGIN_ACCESSED);
		ret = fpService.saveOnline(null,null,null,fo.getAuthType(),fo.getAuthValue(),fo, true);
		return ret;
	}

	@Override
	public Set<String> generateUserPermissions(Long userid, String username, String type){
		
		Set<String> ret = new HashSet<String>();
		List<Permission> list = null;
		// if login by superuser. return all the permissions
		boolean issuperuser = false;
		int size;
		if (StringUtil.isEqualedTrimLower(WebConstants.USERNAME_SUPER, username)) {
			//return allpass
			ret.add(WebConstants.PERMISSIONS_ALLPASS);
			//return all active permissions
//			list = perService.findListByStatus(CommonConstants.ACTIVE,type);
			// if permission is null, then init permission from the package class;
//			if (list != null && list.size() == 0) {
//				perService.initialization();	
//				list = perService.findListByStatus(CommonConstants.ACTIVE,type);
//			}
			issuperuser = true;
		} else {
			list = perService.findListByUserid(userid,type);
		}
		if (list != null) {
			size = list.size();
			for (int i = 0; i < size; i++) {
				Permission p = (Permission) list.get(i);
				if (StringUtil.isEqualedTrimLower(p.getStatus(), CommonConstants.ACTIVE)) {
					ret.add(p.getCode());
				}
			}
		}
		// if not superuser, add common permissions of common user.
		if (!issuperuser) {
			Role r = roleService.findByNameAndStatus(WebConstants.ROLENAME_COMMONUSER, CommonConstants.ACTIVE);
			if (r != null && r.getId() > 0) {
				list = perService.findListByUserid(r.getId(),type);
				if (list != null) {
					size = list.size();
					for (int i = 0; i < size; i++) {
						Permission p = (Permission) list.get(i);
						ret.add(p.getCode());
					}
				}
			}
		}
		
		return ret;
	}
}

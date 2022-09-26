package com.labor.spring.system.auth;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.labor.common.constants.CommonConstants;
import com.labor.common.exception.ServiceException;
import com.labor.common.util.StringUtil;
import com.labor.spring.base.BaseHtmlController;
import com.labor.spring.core.AbstractCoreHtmlController;

public class AbstractAuthHtmlController extends AbstractCoreHtmlController{

	private final String FINGERPRINT_PREFIX = "00.fingerprint";
	private final String ROLE_PREFIX = "00.role";
	private final String USER_PREFIX = "00.user";
	private final String PROFILE_PREFIX = "01.profile";
	private final String SSO_PREFIX = "02.sso";


	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public String login(ModelMap map) {	
		map.addAttribute("message","");
		return "login";
	}
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
	public String logout(ModelMap map) {	
		map.addAttribute("message","");
		return "logout";
	}
	
	@RequestMapping(value = { "/sso/{page}"}, method = RequestMethod.GET)
	public String toSSOPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return SSO_PREFIX+"/"+page;
	}		
	@RequestMapping(value = { "/profile/{page}"}, method = RequestMethod.GET)
	public String toProfilePages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return PROFILE_PREFIX+"/"+page;
	}		
	
	@RequestMapping(value = { "/fingerprint/{page}" }, method = RequestMethod.GET)
	public String toFingerprintPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return FINGERPRINT_PREFIX + "/"+page;
	}
	
	@RequestMapping(value = { "/role/{page}" }, method = RequestMethod.GET)
	public String toRolePages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return ROLE_PREFIX + "/"+page;
	}		
	
	@RequestMapping(value = { "/user/{page}" }, method = RequestMethod.GET)
	public String toUserPages(ModelMap map,@PathVariable(value="page") String page) {	
		map.addAttribute("message","");
		return USER_PREFIX + "/"+page;
	}
	
	
}

package com.labor.spring.auth.controller.local;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labor.common.constants.CommonConstants;
import com.labor.spring.auth.entity.Permission;
import com.labor.spring.auth.service.PermissionServiceIntf;
import com.labor.spring.base.BaseProperties;
import com.labor.spring.bean.Result;



@RestController
@RequestMapping("/rest/permissions")
public class PermissionRestController {
	@Autowired
	private PermissionServiceIntf perService;
	@Autowired
	private BaseProperties baseProperties;
	
	@RequiresPermissions("permission")
	@RequestMapping(value = {"/initialization"}, method = RequestMethod.POST)
	public Result initialization() {
		Integer ret = perService.initialization();		
		return Result.success(ret.toString());
	}
	
	@RequiresPermissions("permission")
	@RequestMapping(value = {"/actived-list" }, method = RequestMethod.GET)
	public Result findListActived() {
		List<Permission> ret = perService.findListByStatus(CommonConstants.ACTIVE);		
		return Result.success(ret);
	}

}

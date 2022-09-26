package com.labor.spring.auth.service;

import java.util.List;
import java.util.Set;

import com.labor.spring.auth.entity.Permission;


public interface PermissionServiceIntf {

	public Integer initialization();
	public List<Permission> findListByStatus(String status);
	public List<Permission> findListByRoleid(Long roleid);
	public List<Permission> findListByUserid(Long userid);
	
	public List<Permission> findListByStatus(String status, String type);
	public List<Permission> findListByRoleid(Long roleid, String type);
	public List<Permission> findListByUserid(Long userid, String type);
	
	public Permission save(Permission permission);
	public void updateByType(Set<String> permissions, String type);

}

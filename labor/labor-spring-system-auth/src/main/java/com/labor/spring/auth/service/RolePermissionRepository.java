package com.labor.spring.auth.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.labor.spring.auth.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission,Long> {

    @Transactional
    @Modifying
	@Query(value = "delete from tbl_auth_rolepermission where role_id = ?1", nativeQuery = true)
	public void deleteByRoleid(Long roleid);
}

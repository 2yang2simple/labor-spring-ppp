package com.labor.spring.auth.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.labor.spring.auth.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    @Transactional
    @Modifying
	@Query(value = "delete from tbl_auth_userrole where user_id = ?1", nativeQuery = true)
	public void deleteByUserid(Long userid);
}

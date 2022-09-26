package com.labor.spring.auth.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.labor.spring.auth.entity.UserPassword;

public interface UserPasswordRepository  extends JpaRepository<UserPassword,Long> {

	public UserPassword findFirstByUseridOrderByIdDesc(Long userid);
}

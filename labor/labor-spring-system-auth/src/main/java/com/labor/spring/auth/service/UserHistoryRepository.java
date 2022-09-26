package com.labor.spring.auth.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labor.spring.auth.entity.UserHistory;


//JpaRepository<Entity,Primary Key Type>
public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {
	
	
}

package com.labor.spring.auth.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.labor.spring.auth.entity.Fingerprint;
import com.labor.spring.auth.entity.FingerprintOnline;

public interface FingerprintOnlineRepository  extends JpaRepository<FingerprintOnline,Long> {
	
	public FingerprintOnline findBySessionId(String sessionId);
	
	public FingerprintOnline findByAuthCode(String authCode);
	
	public FingerprintOnline findByFpValueAndFpType(String value,String type);
	
	public FingerprintOnline findByAuthValue(String value);
	
	public FingerprintOnline findByAuthValueAndAuthType(String value,String type);
	
	public FingerprintOnline findByUserIdAndFpTypeAndAuthType(Long userId,String fpType,String authType);
	
	public FingerprintOnline findByUserIdAndFpTypeAndFpValueAndAuthType(Long userId,String fpType,String fpValue,String authType);
	
	public List<FingerprintOnline> findByFpValueStartingWith(String value);
	
	public Page<FingerprintOnline> findByFpValueStartingWith(String value,Pageable pageable);
	
	@Modifying
	@Query(value = "DELETE FROM tbl_auth_fingerprintonline WHERE session_id = ?1 ", nativeQuery = true)
	public void deleteBySessionId(String sessionId);

	@Modifying
	@Query(value = "DELETE FROM tbl_auth_fingerprintonline WHERE auth_type = 'session' OR session_id IS NOT NULL ", nativeQuery = true)
	public void deleteOnlineSession();
	
	@Modifying
	@Query(value = "DELETE FROM tbl_auth_fingerprintonline WHERE auth_value = ?1 and auth_type = ?2 ", nativeQuery = true)
	public void deleteByAuthValueAndAuthType(String authValue,String authType);
	
	@Modifying
	@Query(value = "DELETE FROM tbl_auth_fingerprintonline WHERE auth_value = ?1 ", nativeQuery = true)
	public void deleteByAuthValue(String authValue);
	
	@Modifying
	@Query(value = "DELETE FROM tbl_auth_fingerprintonline WHERE fo_id = ?1 ", nativeQuery = true)
	public void deleteById(Integer id);
	
}

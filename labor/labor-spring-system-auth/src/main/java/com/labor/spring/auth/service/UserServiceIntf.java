package com.labor.spring.auth.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.labor.spring.auth.entity.Permission;
import com.labor.spring.auth.entity.Role;
import com.labor.spring.auth.entity.User;
import com.labor.spring.auth.entity.UserFingerprint;
import com.labor.spring.auth.entity.UserRole;

public interface UserServiceIntf {


    public User findById(Long id);
    public User findByUuid(String uuid);
    public User findByName(String name);
    public User findBySno(String sno);
    public User findByWeixin(String weixin);
    public User findByEmail(String email);
    public User findByCellPhone(String cellPhone);
    public User findByPwdmodify(String pwdmodify);
    
    public List<User> findList(Sort sort);
	public List<User> findListByNameStartingWith(String name);
	
    public Page<User> findList(Pageable pageable);
	public Page<User> findListByNameStartingWith(String name,Pageable pageable);
	public Page<User> findListByNameOrPhoneLike(String nameOrPhone,Pageable pageable);
	
    public User findFirstByValueAndType(String value, String type);
    
    public String checkExisted (User user);
    public String findPwdmd5(Long userid);
    public String findMaxSno();
    public String findSecretKey(String uuid);
    
    public User save(User user);
    public User update(User user);
    public User updateStatusByUuid(String uuid, String status);
    public User updatePasswordModifyCode(Long userid, String pwdmodify);
    public User create(String name, String sno, String googleSecretKey, String cellPhone, String weixin, String email, String pwdmd5, String uuid, String status);
    
    public String createPasswordModifyCode(String uuid);
    public String createPasswordSalt(String saltseed);
    public String createPasswordSaltByAccount(String account);
    public boolean createPassword(Long userid, String pwdmd5);
    public UserFingerprint createUserFingerprint(String value, String type,  Long fpid, 
    												Long userid, String rememberMe);
    
    public String createUserRoles(Long id, List<UserRole> list);
    
    public boolean validateUserPassword(Long userid, String salt, String saltpwdmd5);
    public boolean validateUserAuthcode(String uuid, String authcode);
    public boolean validateUserRememberme(Long userid, String fpValue, String fpType, String rememberMe);
}

package com.labor.spring.feign.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import com.labor.spring.feign.api.service.FeignAuthService;

@EnableJpaAuditing
@Component
public class AuthAuditorAware implements AuditorAware<String> {
	@Autowired
	@Lazy
	private FeignAuthService feignAuthService;
	/**
	 * current userid from login cache(cache,redis or session), 
	 * save to db createdby and lastupdatedby;
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		String ret = "";
		UserVO lc = feignAuthService.getLoginCacheCurrent();
		if (lc!=null) {
			ret = String.valueOf(lc.getUserId());
		}
		return Optional.of(ret);
	}
 
}

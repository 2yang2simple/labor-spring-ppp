package com.labor.spring;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.labor.spring.base.BaseProperties;
import com.labor.spring.bean.ClientInfo;
import com.labor.spring.bean.ClientRegistered;
import com.labor.spring.constants.WebConstants;
import com.labor.spring.core.GlobalInfo;
import com.labor.spring.core.service.SysconfigServiceIntf;

@Component
@Order(value = 10)
public class PPPStarterRunner implements ApplicationRunner {
	
	@Autowired
	private BaseProperties baseProperties;

	
	@Override
    public void run(ApplicationArguments args) throws Exception {
		LogManager.getLogger().info("*****PPPStarterRunner init service*****:");

		
		GlobalInfo.CONTEXT_PATH = baseProperties.CONTEXT_PATH;

		//registered client
		ClientRegistered.CLIENTKEY_DEFAULT = "ppp";

		ClientRegistered.putClientInfo(
				new ClientInfo(
						"ppp",
						WebConstants.FP_TYPE_CANVAS,
						WebConstants.AUTH_TYPE_SAVEDIN_COOKIES,
						"ad89f721e3da95b11378c52112eaa492",
						"http://localhost:8080/ppp/rest/feign/auth/logins/users/tokens/keys",
						"http://localhost:8080/ppp"));
    }
	
	
	
}

package com.labor.spring;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.labor.spring.core.service.SysconfigServiceIntf;

@Component
@Order(value = 1)
public class CoreStarterRunner implements ApplicationRunner {
	
	@Autowired
	private SysconfigServiceIntf sysconfigService;

	@Override
    public void run(ApplicationArguments args) throws Exception {
		LogManager.getLogger().info("*****CoreStarterRunner init service*****:");
		sysconfigService.initialization();

    }
	
	
	
}

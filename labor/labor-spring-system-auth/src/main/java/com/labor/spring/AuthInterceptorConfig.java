//package com.labor.spring;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.labor.spring.feign.auth.AuthInterceptor;
//import com.labor.spring.interceptor.TimestampTokenInterceptor;
//
//@Configuration
//public class AuthInterceptorConfig implements WebMvcConfigurer {
//	
//	@Bean
//	public AuthInterceptor authInterceptor() {
//	    return new AuthInterceptor();
//	}
//	@Bean
//	public TimestampTokenInterceptor timestampTokenInterceptor() {
//	    return new TimestampTokenInterceptor();
//	}
//	    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    	registry.addInterceptor(authInterceptor())
//    					.addPathPatterns("/rest/**")
//    					.excludePathPatterns("/") 
//    					.excludePathPatterns("/rest/foreign/logins/**") 
//    					.excludePathPatterns("/rest/foreign/permissions/**") 
//    					.excludePathPatterns("/rest/feign/auth/**") 
//    					.excludePathPatterns("/rest/core/samples/**") 
//    					.excludePathPatterns("/rest/profiles/**") 
//    					.excludePathPatterns("/rest/sso/**");
//						
//
//    	registry.addInterceptor(timestampTokenInterceptor())
//						.addPathPatterns("/rest/**")
//    					.excludePathPatterns("/rest/foreign/**") 
//    					.excludePathPatterns("/rest/feign/auth/**") ;	
//    }
//    
//
//}
package com.microservice.examples.smscclient.netflixzuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import brave.sampler.Sampler;

/**
 * 
 * FILE_NAME: LoggingFilter.java
 * 
 * MODULE DESCRIPTION: TODO, US/F/D
 *
 * @author egrgmsh, Date: Sep 1, 2020 11:26:54 AM 2020
 * 
 * @(c) COPYRIGHT 2020 Ericsson Inc. All Rights Reserved. Ericsson Inc.Proprietary.
 *
 */

@Component
public class LoggingFilter extends ZuulFilter {
	
	private static Logger LOG = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest httpReq = RequestContext.getCurrentContext().getRequest();
		LOG.info("request uri: >>" + httpReq.getRequestURI());
		LOG.info("request port : >>>>" + httpReq.getServerPort());
		return null;
	}
	@Override
	public String filterType() {
		//post
		//error
		return "pre";
	}
	@Override
	public int filterOrder() {
		return 1;
	}

}

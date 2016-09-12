package com.broadsoft.mapl.samplemicroservice.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.broadsoft.mapl.MaplTransactionId;

@Component
public class MaplTransactionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("INIT filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Inside Filter");
		if (HttpServletRequest.class.isAssignableFrom(request.getClass())) {
			HttpServletRequest req = (HttpServletRequest) request;
			String txnId = req.getHeader("MAPL_TXN_ID");
			txnId = MaplTransactionId.create(txnId);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("DESTROY");
	}
}
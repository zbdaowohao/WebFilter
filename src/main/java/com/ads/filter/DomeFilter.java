package com.ads.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="domeFilter",urlPatterns={"/index.jsp"}, dispatcherTypes = {DispatcherType.REQUEST}, initParams = {@WebInitParam(name = "initParam", value = "initFilter")})
public class DomeFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Filter destroy ...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Start filter doFilter ...");
		chain.doFilter(request, response);
		System.out.println("End filter doFilter ...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter init ...");
	}

}

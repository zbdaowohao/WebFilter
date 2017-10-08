package com.ads.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//http://127.0.0.1:8080/webFilter/filterChain.jsp
@WebFilter(filterName="secondFilterChain",urlPatterns="/filterChain.jsp")
public class SecondFilterChain implements Filter {

	@Override
	public void destroy() {
		System.out.println("SecondFilterChain destroy ...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Start secondFilterChain doFilter ...");
		chain.doFilter(request, response);
		System.out.println("End secondFilterChain doFilter ...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("SecondFilterChain init ...");
	}

}

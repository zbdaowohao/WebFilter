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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//过滤器访问异步的servelet需要配置DispatcherType.ASYNC，开启asyncSupported
@WebFilter(filterName="asynFilter",urlPatterns={"/asyncServlet"}, dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.ASYNC}, asyncSupported = true)
public class AsynFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Filter AsynFilter ...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Start asynFilter doFilter ...");
		chain.doFilter(request, response);
		System.out.println("End asynFilter doFilter ...");
		//转发到前台页面
		HttpServletRequest serRequest = (HttpServletRequest) request;
		//serRequest.getRequestDispatcher("async.jsp").forward(request, response);
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		servletResponse.sendRedirect("/async.jsp");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("AsynFilter init ...");
	}

}

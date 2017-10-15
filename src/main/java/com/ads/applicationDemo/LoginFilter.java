package com.ads.applicationDemo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用过滤器进行登录验证，进行字符集转换
 * 
 * @author Administrator
 * 
 */
//http://127.0.0.1:8080/webFilter/AppPage/success.jsp
@WebFilter(value = "/AppPage/*", initParams = {
		@WebInitParam(name = "passFilterUrl", value = "login.jsp/login/fail.jsp"),
		@WebInitParam(name = "charSet", value = "UTF-8") })
public class LoginFilter implements Filter {

	private FilterConfig filterConfig;
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		request.setCharacterEncoding(filterConfig.getInitParameter("charSet"));
		String userName = String.valueOf(request.getSession().getAttribute("userName"));
		String[] urlParam = request.getRequestURI().split("/");
		String url = urlParam[urlParam.length - 1];
		String passFilterUrl = filterConfig.getInitParameter("passFilterUrl");
		boolean filter = false;
		filter = passFilterUrl.indexOf(url) != -1;
		if (filter) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		if (!"null".equals(userName)) {
			arg2.doFilter(arg0, arg1);
		} else {
			HttpServletResponse respones = (HttpServletResponse) arg1;
			respones.sendRedirect(request.getContextPath() + "/AppPage/login.jsp");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		filterConfig = arg0;
	}

}

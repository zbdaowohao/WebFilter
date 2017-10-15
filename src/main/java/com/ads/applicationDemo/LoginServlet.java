package com.ads.applicationDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 5232555389404924942L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		if("zbdaowohao".equals(userName)&&"winkill".equals(password)){
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			resp.sendRedirect(req.getContextPath() + "/AppPage/success.jsp");
		}else{
			resp.sendRedirect(req.getContextPath() + "/AppPage/fail.jsp");
		}
	}
	
}

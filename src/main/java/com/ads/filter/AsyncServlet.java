package com.ads.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现异步的servelet需要开启asyncSupported
@WebServlet(asyncSupported = true, urlPatterns = "/asyncServlet")
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = -1032228288195997405L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Process(request, response);
	}
	
	private void Process(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Servlet执行开始，时间： " + new SimpleDateFormat("yyyy-dd-MM : hh:mm:ss").format(new Date()));
		//获取异步请求上下文，传入线程后可进行业务处理
		AsyncContext asyncContext = request.startAsync();
		new Thread(new Executor(asyncContext)).start();
		System.out.println("Servlet执行结束，时间： " + new SimpleDateFormat("yyyy-dd-MM : hh:mm:ss").format(new Date()));
	}
	
	public class Executor implements Runnable{
		
		private AsyncContext asyncContext;
		
		public Executor(AsyncContext asyncContext) {
			this.asyncContext = asyncContext;
		}

		@Override
		public void run() {
			asyncContext.getRequest();
			asyncContext.getResponse();
			//执行相关的复杂业务
			try {
				System.out.println("业务执行开始，时间： " + new SimpleDateFormat("yyyy-dd-MM : hh:mm:ss").format(new Date()));
				Thread.sleep(10*1000);
				System.out.println("业务执行结束，时间： " + new SimpleDateFormat("yyyy-dd-MM : hh:mm:ss").format(new Date()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

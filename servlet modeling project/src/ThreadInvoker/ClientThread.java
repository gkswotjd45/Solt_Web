package ThreadInvoker;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;

public class ClientThread extends Thread {
	
	private AddServlet servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	// 쓰레드를 만들 때 서블릿, request, repose를 가져와서 쓰레드가 실질적으로 실행 주체.
	public ClientThread(AddServlet servlet, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.servlet = servlet;
		this.request = request;
		this.response = response;
	}


	// 
	@Override
	public void run() {
		// 이쓰레드가 실행되면, 내가 받은 service 메소드를 실행시킴 이 메서드는 requset, response를 수행.
		servlet.service(request,response);
	}
}

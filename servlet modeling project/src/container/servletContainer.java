package container;

import ThreadInvoker.ClientThread;
import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;

// Tomcat(was)안에 Servlet Container 역할을 하는 클래스
public class servletContainer {
	//일반 자바프로그램이기 때문에 있는것 
	// Servlet Container는 가지고 있지 않음.
	public static void main(String[] args) { // 이게 메인 컨테이너임.
		
		// 1. 사용자의 요청사항을(request) 분석.
		// 어떤 서블릿을 실행하는지 알아내는 것. => Add servlet을 실행!\
		// 2.. Add 라는 서블릿에 instance 가 있는지 확인함.
		// Container안에 객체가 있는지 확인.
		
		// 3. 객체가 없기 때문에 Add Servlet를 찾아것 객체를 생성.
		AddServlet servlet = new AddServlet();
		
		// 4. Servlet instance가 생성되면 바로 당믕에 해당 서블릿의 
		// init()을 호출함. (시작한다는 의미 = 초기화의미)
		// 시블릿의 초기화를 담당.
		servlet.init(); 
		
		// 5. 클라이언트가 보내준 request내용을 기반으로 객체를 하나 생성함. [request 객체]
		// 당연히 이 객체에는 클라이언트가 보내준 데이터가 들어가 있음. (중요)
		HttpServletRequest request = new HttpServletRequest();
		
		// 6. 클라이언트에게 최종 결과를 보내주기 위해서 response 객체 하나를 만들어야 함.
		HttpServletResponse response = new HttpServletResponse();
		
		// 7. 클라이언트 요청을 실제로 처리하기 위해서 Thread가 있어야 함.
		ClientThread thread = new ClientThread(servlet,request,response); // 클라이언트가 올때마다 쓰레드를 생성.
		thread.start(); // 따라서 알아서 쓰레드가 (클라이언트 역할 수행할 수 있도록) 진행 함.
		// 이 쓰레드는 서블릿을 실행시켜 주어야 함.
		
		
	}
}

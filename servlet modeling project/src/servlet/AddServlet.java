package servlet;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;

//servelet(서블릿)이라고 불리는 이클래스는 
// 원래 특정 클래스를 상속해서 만들어야 함.
// 여기서 말한 특정클래스는 (httpServlet) - 이 클래스를 상속했으면 오버라이딩 메서드를 사용가능.
public class AddServlet {
	public void init() {
		// 서블릿안에는 기본적으로 있는 거
		// 시블릿의 instance 초기화를 담당.
		// 생성자를 하지 않고 여기서 함.
	}
	
	// 서비스 메서드의 인자 선언 후 request, response 인자를 가지고 와서 수행.
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 이 메서드는 이미 하는 일 정해져 있음.
		// 여기서 request 객체를 뒤적뒤적 뒤져서 클라이언트 요청방식이 어떤 방식인지 알아내야 함.
		// 만약 Get방식 이면 => doGet() 호출, post doPost 방식 이용
		
		// 만약 post방식이면,
		doGet(request,response);
		doPost(request,response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse respons) {
		
		// 여기에서 request에객체 response객체를 이용해서 입력처리와 로직처리 그리고 출력처리를 진행.!
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse respons) {
		
	}
}

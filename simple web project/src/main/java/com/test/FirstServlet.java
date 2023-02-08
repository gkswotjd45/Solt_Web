package com.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/myservlet")
/* myservlet 이름으로 클라이언트가 호출이 가능.*/	

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// 서블릿 초기화 수행.
    	// init() 목적을 servlet instance를 초기화하는데 목적이 있음.
    	System.out.println("init()가 호출되었어요..");
    }
    
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//    	// 서비스를 호출하면서 인자 2개를 넣어줌. req, res => 컨테이너에서 만들 request, response임.
//    	super.service(req, res);
//    } // 이미 하는일이 정해져 있어서 service메서드를 정의하지 않음.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 get방식으로 이 servlet을 호출하면 이 method가 호출됨.
		// 결과적으로 보았을 때 doGet() method가 호출 됨.
		// 클라이언트의 호출 url => http://127.0.0.1: 8080/sample/myservlet 
		// 위 주소를 통해 이 프로그램이 실행이 됨
		// 이 클래스 안에이 있는 doGet()이 호출 됨.
		
		// 여기에 코드를 작성하면 됨.
		
		//클라이언트가 호출했을 때 해야할 일을 여기에 작성하면 됨.
		// 프로그램 작성방식대로 작성해 봄.
		// 1. 입력을 받는다. 
		// 현재는 입력을 받을 것이 없어서 넘어감.
		// 2. 로직을 처리한다. (for문 while ,if문 분기)
		// 로직 처리도 넘어감.
		// 3. 출력 처리한다.
		
		// 1.내가 클라이언트에게 전달한 데이터가 어떤 데이터인지 설정부터 해야 함.
		response.setContentType("text/html; charset=UTF-8"); // html문서가 나감. (정해진 약속에 대한 표현) 
		// "text/json" "image/jpeg" 오타 주의! // 내가 줄 문자 형태는 유니코드임 //클라이언트가 받기 전에 사전에 설정되어 있어야함.
		// 2. 클라이언트에게 데이터를 전달하기 위해 Stream을 열어요.
		PrintWriter out = response.getWriter(); // 데이터 연결통로을 설정함. (뚫기)
		
		// 3. 통로가 열였으니. 이제 통로를 통해서 데이터를 전달.
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>이건 서블릿의 결과예요.. 소리없는 아우성. </body>");
		out.println("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
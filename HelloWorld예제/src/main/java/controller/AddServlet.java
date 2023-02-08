package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/sum")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 서블릿을 호출하려면 
		// http://127.0.0.1:8080/first/sum?num1=10&num2=20
		//1. 입력처리
		// Query String으로부터 데이터를 받으려.. 일단 기억해야하는 것은 입력받은 데이터는 문자열. 
		String num1 = request.getParameter("num1");//num1이라는 변수를 내가 받아본다는 의미. => 10
		String num2 = request.getParameter("num2"); // num2에 받은 값이 20이므로 => 20
		
		//get방식의 데이터를 받은 메서드 getParameter("안에 url의 키") 
		
		//2. 로직처리

		// 문자열을 정수로 바꿔주는 메서드를 통해 합을 구함.
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2); // 30
		
	
		//3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		// 응답결과를 반환하기위해 어떤 종류인지 명시 => html의 텍스트 형태 // "text/plain "일반적인 문자열" , 
		//문자 코드형식도 같이 명시. => 철자 및 형식이 틀리면 download창이 띄움. => 세미콜론 ; 
		// 3.2) 실제 결과 데이터를 전송하면 됨.
		// 3.3) 네트워크 통해서 전송해야 하기 때문에 stream을 열어서 데이터 전송.
		PrintWriter out = response.getWriter();
		// 클라이언트에게 저 결과톨로를 통해 데이터를 전달하는 기능.
		out.println("<html><head></head><body>"+sum+"</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST방식으로 넘겼으니. dopost 메서드 정의내려야 함.
//		 http://127.0.0.1:8080/first/sum 호출.
		//1. 입력처리
				// form으로부터 post방식의 데이터를 받으려.. 일단 기억해야하는 것은 입력받은 데이터는 문자열. 
				String num1 = request.getParameter("myNum1");//num1이라는 변수를 내가 받아본다는 의미. => 10
				String num2 = request.getParameter("myNum2"); // num2에 받은 값이 20이므로 => 20
				
				// form의 name 과 getparmeter("form.name과 일치")
				//get방식의 데이터를 받은 메서드 getParameter("안에 url의 키") 
				
				//2. 로직처리

				// 문자열을 정수로 바꿔주는 메서드를 통해 합을 구함.
				int sum = Integer.parseInt(num1) + Integer.parseInt(num2); // 30
				
			
				//3. 출력처리
				response.setContentType("text/html; charset=UTF-8");
				// 응답결과를 반환하기위해 어떤 종류인지 명시 => html의 텍스트 형태 // "text/plain "일반적인 문자열" , 
				//문자 코드형식도 같이 명시. => 철자 및 형식이 틀리면 download창이 띄움. => 세미콜론 ; 
				// 3.2) 실제 결과 데이터를 전송하면 됨.
				// 3.3) 네트워크 통해서 전송해야 하기 때문에 stream을 열어서 데이터 전송.
				PrintWriter out = response.getWriter();
				// 클라이언트에게 저 결과톨로를 통해 데이터를 전달하는 기능.
				out.println("<html><head></head><body>"+sum+"</body></html>");
				out.close();
	}

}

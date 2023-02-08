package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Helloworldservlet
 */
@WebServlet("/sayHello")
public class Helloworldservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Helloworldservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식으로 호출되면 결국에는 돌고돌아서 이 method가 Thread에 의해서 호출되는 것.
		//1. 클라이언트가 보내준 데이터를 받아요 => request 객체 이용.
		// 2. 로직처리를 해요 (DB처리 포함해서)
		// 3. 출력처리해요. => response 객체를 이용.
		// 3.1) 처리된 결과를 보내주기 전제.. 먼저 처리한 결과가 어떤 데이터인지를 먼저 알려줘야 함.
		response.setContentType("text/html; charset=UTF-8");
		// 응답결과를 반환하기위해 어떤 종류인지 명시 => html의 텍스트 형태 // "text/plain "일반적인 문자열" , 
		//문자 코드형식도 같이 명시. => 철자 및 형식이 틀리면 download창이 띄움. => 세미콜론 ; 
		// 3.2) 실제 결과 데이터를 전송하면 됨.
		// 3.3) 네트워크 통해서 전송해야 하기 때문에 stream을 열어서 데이터 전송.
		PrintWriter out = response.getWriter();
		// 클라이언트에게 저 결과톨로를 통해 데이터를 전달하는 기능.
		out.println("<html><head></head><body>안녕하세요.</body></html>");
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

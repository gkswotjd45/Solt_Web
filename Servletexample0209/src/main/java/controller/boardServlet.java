package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/board")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public boardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getSession(false); 의미 : 나(클라이언트)에게 기존에 할당된 세션 객체가 있으면 그거 주세요
		// 만약 없으면 만들지 말고 null을 리턴해주세요. -> 세션이 없다 => 로그인을 거치지 않음 파악이 가능.
		HttpSession session = request.getSession(false); // 세션을 주서서 오기.

		
		
		
		
		// 여기서 두가지 의 문제 발생. => 링크를 통해 들어오는 방식이므로 => 따라서 로그인한 사람만 접근하는것이 목적이었으나, 우연치 않게
		// 회원이 주소를 알고 접근이 가능
//		 허용되지 않은사람이 접속이 가능 //2. 아까 로그인한 사람이 게시판에 접근하는 것을 인지시켜야 함. 
		// 여기는 로그인한 사람만 들어올 수 있음.
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head></head>"); // 데이터를 내보내줌.
		out.println("<body>");
		if(session!=null) {
			String name = (String) session.getAttribute("loginName");
			out.println("<h2>"+name +"님 게시판에 오신걸을 환영합니다..</h2>");
			
		}else {
			out.println("<h1>로그인을 해야 사용할 수 있어요! 페이지 재설정 </h1>");
		}
	
		out.println("</body></html>");
		
		out.close();
		// 1. 입력 하고
		// 2. 로직 처리
		// 3. 결과 처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/myhobby")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력
		String [] data = request.getParameterValues("mycheck"); // check 박스는 여러개 값을 받는 형태이므로 배열형태로 타입을 지정.
		
		//2. 로직 처리
		
//		System.out.println(data);
		//3. 결과 처리 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 클라이언트에게 데이터 통로를 뚫을 때 사용.
		out.println("<html><head></head><body>");
		
		for(String tmp : data) {
			out.println("취미는 "+tmp+"입니다. <br>");
		};
		out.println("</body></html>");

		out.close();
	}

}

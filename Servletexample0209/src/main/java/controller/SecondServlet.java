package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력받기
		
		//2. 로직 처리.
		ServletContext context = this.getServletContext(); // 일단 레퍼런스를 확보.
		
		String name = (String)context.getAttribute("memberName"); // 이렇게 사용하면 에러 => 객체가 나오지만 최상위 타입 object로 나옴.
		// context안에는 어떤 형식으로 나올지 이름가지고는 모름 => 따라서 object로 출력.
		
		//3. 결과처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head>"); // 데이터를 내보내줌.
		out.println("<body>");
		out.println("가져온 이름은 :" + name);
		out.println("</body></html>");
		
		// 톰겟을 재기동시키면 자동으로 날아가서 -> 새롭게 컨테이너를 올리는다는 개념 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

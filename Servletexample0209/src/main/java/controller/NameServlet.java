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
 * Servlet implementation class NameServlet
 */
@WebServlet("/saveName")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		//1.입력처리
		String name = request.getParameter("userName");
		
		//2. 로직처리
		//servletContext를 가져와서 여기에 이름을 저장할 것임. => 컨테이너가 기동될 때 자동적으로 생성. (일단 reference를 가져와야 사용이 가능)
		ServletContext context= getServletContext();
		// servletㅊontext는 map 구조, key, value의 쌍으로 저장하는 구종.
		// 현제 서블릿을 가지고 있는 서블릿 context객체를 가지고 올 수 있음.
		
		context.setAttribute("memberName", name); // 컨텍스느튼 memberName이라는 이름을 가지고 받아온 name으로 설정.
		
		//3. 결과처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head>"); // 데이터를 내보내줌.
		out.println("<body>");
		out.println("<a href ='secondServlet'>두번째 서블릿 호출");
		out.println("</body></html>");
		
		
	}

}

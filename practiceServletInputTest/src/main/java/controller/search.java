package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import dao.BookDao;
import mybatis.MyBatiesConnectionFactory;

/**
 * Servlet implementation class search
 * http://127.0.0.1:8080/Input/booksearch.html
 */
@WebServlet("/mySearch")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		
		String data[] = request.getParameterValues("myradio");
		String keyword = request.getParameter("keyword");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		SqlSessionFactory factory = MyBatiesConnectionFactory.getSqlSessionFactory();
		
		BookDao dao = new BookDao(factory);
		out.println("<html><head> 키워드 검색결과입니다.</head><body>");	
		out.println("검색 가격" + data.toString());
		
		out.println("확인");
		
		List<HashMap<String, Object>> map = dao.selectBykeyworldHashMap(keyword);
		for(HashMap<String, Object> tent:map) {
			for(Object content:tent.values()) {
				out.println("<br>"+content+"<br>");
			}
		}
		out.println("</body></html>");
		
	}

}

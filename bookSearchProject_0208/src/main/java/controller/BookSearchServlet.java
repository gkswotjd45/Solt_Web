package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
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
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8"); // 입력값을 한글로 제대로 받을 수 있음.
		
		//1. 입력을 받아보기. // html과 매핑시켜야 함.
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		
		//2. 로직 처리. (데이터베이스 처리를 포함해서)
		// mybatis 세팅부타 하고 왔어요.
		// 2.1) sqlSessionFactory설정. (sqlmapConfig.xml)
		// 2.2) 연결정보를 따로 분리해서 설정. (driver.properties)
		// 2.3) sql을 실행하기 위한 mapper 설정.(sqlmap/Book.xml)
		
		// 마이바티스를 통해서 mapper를 통해서 파마미터를 전달해야 함
		
		// 클라이언트가 보내준 데이터를 이용해서 vo를를 생성.
		Book book = new Book();
		book.setBtitle(keyword);
		book.setBprice(Integer.parseInt(price));
		// 클라이언트를 각각 전달할 수 없어서 vo 객체를 만들어서 set()을 통해 파라미터를 담겨진 book 전닳.
		
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		//book.xml의 sql문을 실행시키기 위해 sql 세션을 뽑아냄.
		
		session.selectList("myBook.selectBookByKeyword",book); // vo가 여러개의 리스트 형태로 반환.
		//sql문에서 ("myBook" 안에있는 것에서 selectBookByKeyword 실행해.
		// 이렇게 수행하면 리
		
		List<Book> result = session.selectList("myBook.selectBookByKeyword",book); 
		// Array 안에 BookVo가 한 개씩 가지고 있는 상태.
		
		session.close();
		
		//3. 결과 출력.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><sbody>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<h3>검색키워드 :" + keyword + "</h3>");
		out.println("<h3>검색 가격 :" + price + "</h3>");
		out.println("<ul>");
		for(Book tmp : result) {
			out.println("<li>"+tmp.getBtitle()+","+tmp.getBprice()+ "</li>");
		}
		out.println("</ul></body></html>");
		out.close();
	}

}

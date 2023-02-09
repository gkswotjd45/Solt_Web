package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.mysql.cj.xdevapi.Result;

import mybatis.MyBatisConnectionFactory;
import vo.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String Id = request.getParameter("userID");
		String Pw = request.getParameter("userPW");
		
		Member member = new Member();
		member.setId(Id);
		member.setPassword(Pw);
		
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Member mem = sqlsession.selectOne("myMember.selectMember",member); 
		
		if(mem != null) { // 로그인이 성공하면, 
			//클라이언트 쓰레드가 서블릿 인스턴스 dopost() 수행되는데 세션을 할당받아 흔적을 남김
			// 서블릿 컨테이너에게 세션 객체를 요청.
			// request.getSession(true); 만약 기존의 세션객체가 있으면 그거 주세요.
			// 만약 기존에 할당 받은 세션객체가 없으면 만들어 주세요. => true에 의미. 
			HttpSession session = request.getSession(true); // 세션을 하나을 얻음
			
			// 이 세션 객체는 map 형태 => 오전에 서블릿 콘텍스트 형태와 동일
			session.setAttribute("loginName", mem.getName()); // 현재 로그인한 이름을 세션의 키값으로 부여함.
			
			
			
			
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		sqlsession.close();
		if(mem != null){
			// 로그인이 성공한 상태. => 이 사람에가만 링크(게시판)를 줌.
			out.println("<html><head></head><body>");
			out.println("<h4>"+mem.getName() + "이 "+mem.getId()+"으로 접속 로그인하셨습니다.</h4>");
			out.println("<a href='board'> 게시판 들어가기 </a>");
			out.println("</body></html>");
			
		
		} else {
			// 로그인
			out.println("<html><head></head><body>");
			out.println("<h4>"+Id+ "회원이 아닙니다.</h4>");
			out.println("</body></html>");
			
		}
		
		out.close();
		
		
		
	}

}

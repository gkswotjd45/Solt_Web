package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/newRegister")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		String mId = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		String checkpassword = request.getParameter("checkpassword");
		String mname = request.getParameter("mname");
		
		int result = 0; // 최종결과 값

		// 입력 받은 항목들이 모두 빈 형태가 아닐 경우에는 진행
		if( !(mId.trim().isEmpty()) && !(mpassword.trim().isEmpty()) 
				&& !(mname.trim().isEmpty()) && !(mname.trim().isEmpty()) ) {
			Member member = new Member();
			member.setMemberId(mId);
			member.setMemberPw(mpassword);
			member.setMemberName(mname);
			
			
			if(mpassword.equals(checkpassword)) { // 입력한 패스워드가 같은경우
				MemberService mService = new MemberService();
				result = mService.register(member); // 결과값 1
				response.setContentType("text/xml;charset=UTF-8");
				String last = new Gson().toJson(member); // 가입한 회원 정보를 결과값에 전달.
				response.getWriter().write(last);
			} else {
				System.out.println("쿼리문 실패");
			}
			
		}
		
//		System.out.println(mId);
//		System.out.println(mpassword);
//		System.out.println(checkpassword);
//		
		
	}

}

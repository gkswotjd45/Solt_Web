package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/findId")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String memberId = (String)request.getParameter("mid");
		
		Member member = new Member();
		member.setMemberId(memberId);
		
		MemberService service = new MemberService();
		member = service.findId(member); // Member의 ID값을 찾는 서비스를 수행.
		
		int result = 0;
		
		if(Objects.isNull(member) == false) { 
			result = 1; // 현재 아이디가 사용중임.
		}
		
		Gson gson = new Gson();
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("result", result);
		jsonObject.addProperty("memberId", memberId);
		
		String last = gson.toJson(jsonObject);
		response.getWriter().write(last);
		
		
//		
//		// 단일 객체로 전달방법.
//		PrintWriter out = response.getWriter();
//		out.print(result);
//		
		
	}

}

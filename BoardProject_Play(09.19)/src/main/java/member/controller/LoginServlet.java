	package member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import board.service.boardService;
import board.vo.Board;
import board.vo.boardList;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		ServletContext application = request.getServletContext();
		
		
		//서블릿은 mvc 패턴에서 컨트롤러 역할을 수행 (controller) 
		// model view controller의 약자.
		// model : 
		// 1. data model - 우리가 사용하는 데이터를 관리 (DB안의 있는 데이터) -> Vo(value Object)가 이 역할을 담당  
		// 2.business model - 로직처리 => service라는 클래스가 이 역할을 담당.
		// - 데이터베이스 처리를 들어 올 수 있음. => 이 데이터 베이스 처리는 DAO가 담당함.
		
		// View : 클라이언트로 직접 보이는 화면, 이벤트 값을 넣은 형태. HTMl, JSP "결과를 보여주고, 특정 이벤트를 일으켜 주는 역할"
		// Controller : View와 model을 연결해주는 역할하는 컨트롤러 => 중간자 역할. => 우리의 서블릿의 역할. => model에게 전달.
		// view로부터 사용자 데이터를 받아서, 그걸 Service에게 전달해서 로직처리 시키고, 로직처리된 결과를 모델로 부터 서비스로 부터 받아옴.
		// 그 결과를 보고 [이 결과을 보고 특정 view 선택(html, jsp)해서 그 view를 클라이언트에게 전달하도록 시키는 역할
		
		
		// 1. 입력받고
		request.setCharacterEncoding("UTF-8"); // 일단 설정 (한글이 있을 수 있음)
		String userID = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
		
		// 테이블을 생성한 후 vo를 만들고 데이터를 세팅해서 서비스에게 넘겨줄 준비를 함
		Member member = new Member();
		member.setMemberId(userID);
		member.setMemberPw(userPw);
		
		// 입력받은 데이터로 VO를 생성해요.
		// 원래는 데이터 베이슬 테이블을 기준으로 VO를 생성해야 하니 , 당연히 table이 있어야 함.
		// 따라서 데이터 베이스 부터 스키마 부터 생성.
	
		
		// 2. 로직처리
		
		//로직 처리를 하기 위해 service 객체를 생성해여. (비즈니스 로직처리 =>일반 자바클래스 처리)
		MemberService service = new MemberService();
		// 나중에 다수의 클라이언트 접속시 부하가 발생되므로 => 스프링으로 변환 수행.
		// 객체가 생성되었으면 일을 시킴 => 객체를 만들고 메서드를 수행.
		
		// 만약 로그인이 성공하면 VO안에 회원의 이름까지 포함해서 들고와요.
		// 만약 로그인이 실패하면, null을 리턴 받을 꺼임.
		
		Member result = service.login(member);
		// member라는 이름으로 세션을 vo자체로 저장시킴.
		
		// 미리 선언하면 값이 있는지 없는지를 파악.
		//List <boardList> reserveList = null;
		
		List<boardList> list = null;
		if(result != null) {
			boardService bservice = new boardService();
			list = bservice.getAllBoard(); // 모든 글을 당겨오기 처리하는 메서드를 서비스 클래스에서 가져오기. .
//			reserveList = new ArrayList<>(list); // 역순으로 차례대로 보여주기
//			Collections.reverse(reserveList);
		}	
	
		// 3. 출력처리
		if(result != null) {
			//로그인에 성공했어요.
			
			// 로그인의 성공한 흔적을 남겨놔애 돼요. => 
			// 세션은 서블릿에서 처리.(서비스는 일반자바클래스 작업 불가)
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result);
			
			
//			session.setAttribute("boardList", list);// 게시글의 형태는 세션의 크기는 점점 커져 서버쪽에서 부담을 줌.
			// 게시판 html페이지를 클라이언트에게 전송해요.
			// jsp 그 실체가 Servlet이예요.
			// html에서 -> servlet -> service -> dao -> service -> controller(이 servlet) -> JSp(다른 Servlet)에게 전달 -> client
			
			
			// controller(이 servlet) -> JSp(다른 Servlet)에게 전달 -> client
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			//하나의 서블릿이 내가 다른 서블릿을 호출하기 위해서 사용하는 RequestDispatcher 임 따라서 = 뒤에는 jsp에 해당함. (다른 서블릿에 전달)
			// jsp로 전달 (프로그램적인 요소, "회원ID + 접속해 주셔서 감사합니다."
			// 다음에 실행할 jsp가 이거다 라는 의미
			//application.setAttribute("AllList", list); // 서블릿 context에 저장.
			// jsp에게 리스트를 정보를 전달하기위해서는 세션 에서 보내는 형태 OR request방식으로 전달하는 방식이 존재.
			request.setAttribute("AllList", list); 
//			request.setAttribute("AllList", reserveList); // jsp에 잠깐 저장할 데이터 (1회성 데이터) 출력하기 위해서는 request 객체에 잠깐 붙여서 전달하는 방식이 효율적임.
			dispatcher.forward(request, response); // jsp가 request, response을 가지고 =>클라이언트에게 전달 함. 
			

		
		}else {
			// 로그인에 실패한 거임.
			// 오류 html페이지를 클라이언트에게 전송해요.
			
			//정적인 내용 페에지가 보여주면 됨 
			response.sendRedirect("loginFail.html");
			// 응답은 내가 보내줄 html을 명시하면 됨.
			// 클라이언트에게 응답을 할테 다시 접속하라고 얘기 하는 형태 메서드,
			// 브라우저로 다시 접속.
		}
	}

}

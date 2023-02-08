package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TextInputServlet
 */
@WebServlet("/inputText")
public class TextInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// field를 만들 수 있음.
	int count = 0; // 이 field는 client thread에 의해서 공유 됨, 초기값을 0으로 지정

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TextInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8"); // data를 얻어오기 전에 요청 파라미터 값의 문자 코딩을 변환
		// get방식은 처리방식과 다르기 때문에 위의 메서드가 있어도 필요가 없음. => 그래서 post방식에서는 명시해줘여 함. (한글처리)
		

		count += 1; // 진짜 공유되는지 확인도 할 겸 겸사겸사.
		// post방식으로 메서드가 호출될때 마다 count가 증가.
		// 1. 입력 받고
		String data = request.getParameter("userID");

		// 2. 로직 처리하고
		// 일단 없음.

		// 3. 출력처리하면 됨.
		// 3.1) content type 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 클라이언트에게 데이터 통로를 뚫을 때 사용.
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("<br><br>");
		out.println("이건 Get방식이예요");
		out.println("</body></html>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 크라이언트 요청을 처리히 하면 됨.
		// post방식일 경우.
		// 클라이언트로 부터 서블릿으로 전송된 문자데이터는 iso_8859_1 인코딩으로 되어 있음.
		// 그래서 기본적으로 한글처리가 안됨.
		// 인코딩을 바꿔서 한글처리를 해줘야 해요.
		request.setCharacterEncoding("UTF-8"); // data를 얻어오기 전에 요청 파라미터 값의 문자 코딩을 변환

		count += 1; // 진짜 공유되는지 확인도 할 겸 겸사겸사.
		// post방식으로 메서드가 호출될때 마다 count가 증가.
		// 1. 입력 받고
		String data = request.getParameter("userID");

		// 2. 로직 처리하고
		// 일단 없음.

		// 3. 출력처리하면 됨.
		// 3.1) content type 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 클라이언트에게 데이터 통로를 뚫을 때 사용.
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("</body></html>");

		out.close();

	}

}

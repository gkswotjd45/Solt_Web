package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.boardService;
import board.vo.Board;
import member.vo.Member;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/firstpost")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public boardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("newPost.jsp");
		//request.getAttribute("member");
		
		//dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		request.getAttribute("member");
		String title = request.getParameter("postTitle");
		String content = request.getParameter("postContent");
		
		
		
//		
//		List<Board> list = null;
//
//		
//		boardService bservice = new boardService();
////		list = bservice.getAllBoard(); // 모든 글을 당겨오기 처리하는 메서드를 서비스 클래스에서 가져오기. .
////		
////		if(list != null) {
////			response.sendRedirect("complete.html");
////		}else {
////			response.sendRedirect("loginFail.html");
////		}
////		
//////		
		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardContent(content);
//		board.setBoardAuthor(member.getMemberId());
		
		boardService service = new boardService();
		
	
		int result = service.putPost(board);
		
		if(result == 1) {
			response.sendRedirect("complete.html");
		}else {
			response.sendRedirect("loginFail.html");
		}

	}

}

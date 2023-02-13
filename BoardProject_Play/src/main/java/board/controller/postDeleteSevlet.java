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
import board.vo.boardList;

/**
 * Servlet implementation class postDeleteSevlet
 */
@WebServlet("/postDelete")
public class postDeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public postDeleteSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		System.out.println(session.getAttributeNames().toString());
		request.setCharacterEncoding("UTF-8");
		Board board = (Board) session.getAttribute("post"); // 현재 게시글 받아오기.

		boardService bservice = new boardService();
		int result = bservice.postDelete(board); // 게시글 삭제하기
		
		List<boardList> list  =bservice.getAllBoard();
		
		RequestDispatcher dispatcher;
		if (result == 1) {
			System.out.println("성공");
			request.setAttribute("AllList",list); // 업데이트 한 리스트도 같이 전달.
			dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
//			getServletContext().getInitParameter("context-param-name") ;
			dispatcher.forward(request, response);
		} else {
			System.out.println("실패");
			response.sendRedirect("loginFail.html");
		}

//		String postState = request.getParameter("postBoard");
//		if (postState.equals("postModify")) {
//			
//			
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("complete.html");
//			dispatcher.forward(request, response);
//		} else if (postState.equals("postDelete")) {
//			
//			
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.html");
//			dispatcher.forward(request, response);
//		}

	}

}

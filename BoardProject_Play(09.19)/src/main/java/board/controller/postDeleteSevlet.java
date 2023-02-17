package board.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

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

//		System.out.println(session.getAttributeNames().toString());
		request.setCharacterEncoding("UTF-8");
//		Board board = (Board) session.getAttribute("board"); // 현재 게시글 받아오기.
//
//		boardService bservice = new boardService();
//		int result = bservice.postDelete(board); // 게시글 삭제하기
//		
//		List<boardList> list  =bservice.getAllBoard();
//		
//		RequestDispatcher dispatcher;
//		if (result == 1) {
//			System.out.println("성공");
//			request.setAttribute("AllList",list); // 업데이트 한 리스트도 같이 전달.
//			dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
//
//			dispatcher.forward(request, response);
//		} else {
//			System.out.println("실패");
//			response.sendRedirect("loginFail.html");
//		}
		String postState = request.getParameter("postBoard"); // 버튼의 상태 유무.
		String boardNume = (String) request.getParameter("boardNum");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(boardNume));

		boardService bservice = new boardService();
		
		if (postState.equals("postDelete")) { // 삭제 버튼 누를 때. 수행 과정
		
			

			int result = bservice.postDelete(board); // 게시글 삭제하기

			List<boardList> list = bservice.getAllBoard();

			RequestDispatcher dispatcher;
			if (result == 1) {
				System.out.println("성공");
				request.setAttribute("AllList", list); // 업데이트 한 리스트도 같이 전달.
				dispatcher = request.getRequestDispatcher("loginSuccess.jsp");

				dispatcher.forward(request, response);
			} else {
				System.out.println("실패");
				response.sendRedirect("loginFail.html");
			}
			
		} else if (postState.equals("PostLike")) { // 좋아요 버튼 클릭시 수행 과정.
			int like = Integer.parseInt(board.getBoardLike());
			System.out.println(like);
			board.setBoardLike(Integer.toString(like++)); // 좋아요 1 추가
			// dao 작업 및 session 작업 수행.
			bservice.modifyPost(board);
			response.sendRedirect("complete.html");
		}

	}

}

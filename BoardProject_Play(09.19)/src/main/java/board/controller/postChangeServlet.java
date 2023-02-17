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

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import board.service.boardService;
import board.vo.Board;
import comment.vo.Comment;

/**
 * Servlet implementation class postChangeServlet
 */
@WebServlet("/postChange")
public class postChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public postChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String BoardNum = (String) request.getParameter("boardIndex");
		
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(BoardNum));
		
		boardService bservice = new boardService();
		board = bservice.getPost(board); // 현재 게시글 불러오기
		
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("modifyPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String Title = request.getParameter("postTitle"); // input에 입력한 값(postTitle)을 String 형태로 저장.
		String content = request.getParameter("postContent"); // 
		String pageIndex = (String) session.getAttribute("pageIndex");
		
		
		
//		System.out.println(pageIndex);
//		System.out.println(Title);
//		System.out.println(content);
		
		Board board = new Board();
		board.setBoardTitle(Title);
		board.setBoardContent(content);
		board.setBoardNum(Integer.parseInt(pageIndex));
		
		boardService bService = new boardService();
		int result = bService.modifyPost(board); // 게시글 수정하기.
		
		Board modfiy = bService.getPost(board); // 해당 게시글 다시 불러오기.
		

		if (result ==1) {
			System.out.println("완료");
			request.setAttribute("board", modfiy);
			//session.setAttribute("board", modfiy);
			RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
			dispatcher.forward(request, response);
		
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.html");
			dispatcher.forward(request, response);
		}
	
	}

}

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

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import board.service.boardService;
import board.vo.Board;
import board.vo.boardList;
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
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("postTitle");
		String content = request.getParameter("postContent");

		String id = ((Member) session.getAttribute("member")).getMemberId();

		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setBoardAuthor(id);

		boardService service = new boardService();

		int result = service.putPost(board); // 새글 저장하기

		int num = board.getBoardNum(); // 게시글 번호 저장

		if (result == 1) { // 새로운 게시글이 입력되었을 때. 리스트 다시 불러들여서 처음 리스트 나타내었던 곳으로 보여줌.
			List<boardList> list = null;
			boardService bservice = new boardService();
			list = bservice.getAllBoard(); // 게시글 다시 출력하기.
			request.setAttribute("AllList", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loginFail.html");
		}

	}

}

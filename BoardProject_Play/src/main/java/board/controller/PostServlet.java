package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import board.service.boardService;
import board.vo.Board;
import board.vo.boardList;
import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/current") // 현재 게시글 세부 내용
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession(true);
		// System.out.println(request.getParameter("page"));
		String pageIndex = request.getParameter("page");

		request.setAttribute("pageIndex", pageIndex);
		session.setAttribute("pageIndex", pageIndex); // pageIndex 값을 session에 전달.
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(pageIndex));

		boardService bservice = new boardService();
		board = bservice.getPost(board); // 현재 게시글 불러오기

		if (board != null) {
			// System.out.println(board.getBoardAuthor());

			session.setAttribute("board", board); // 게시글 1개를 session으로 전달.
			request.setAttribute("board", board); // 게시글 1개를 requst으로 전달.

			// 게시글이 정상적으로 호출이 되면 해당 게시글에 대한 댓글도 같이 가져오기
			Comment comments = new Comment();
			comments.setBoardNum(Integer.parseInt(pageIndex));
			// 해당 게시글에 맞는 댓글 테이블 불러오기

			List<Comment> commentlist = null;

			if (comments != null) {
				CommentService cservice = new CommentService();
				commentlist = cservice.getAllList(comments); // 모든 글을 당겨오기 처리하는 메서드를 서비스 클래스에서 가져오기. .

				if (commentlist != null) {
					System.out.println("댓글 있음");

//					request.setAttribute("Comment", commentlist);
					session.setAttribute("Comment", commentlist);
					RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
					dispatcher.forward(request, response);

					dispatcher = request.getRequestDispatcher("/postChange");
					dispatcher.forward(request, response);
				} else {
					// 해당 댓글 목록이 없는 경우.
					System.out.println("댓글이 없음");
					response.sendRedirect("loginFail.html");
				}
			} else { // 해당 게시글이 없는 경우
				System.out.println("게시글이 없음");
				response.sendRedirect("loginFail.html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession(true);
//		request.setCharacterEncoding("UTF-8");
////		
//		Object index = session.getAttribute("boardIndex");
//		System.out.println(index);
//		Member member = (Member)session.getAttribute("member");
//	
	}

}

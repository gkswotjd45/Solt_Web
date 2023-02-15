package comment.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.CompoundName;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.boardService;
import board.vo.Board;
import comment.service.CommentService;
import comment.vo.Comment;
import comment.vo.CommentList;
import member.vo.Member;

/**
 * Servlet implementation class CommentInputServlet
 */
@WebServlet("/commentInput")
public class CommentInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentInputServlet() {
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
		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("UTF-8");

		String Content = request.getParameter("commentContent");
		String pageIndex = (String) session.getAttribute("pageIndex");
		String currentId = ((Member)session.getAttribute("member")).getMemberId();
		Board board = (Board) session.getAttribute("board");
		
		System.out.println(currentId);
		System.out.println(Content);
		System.out.println(pageIndex);
		Comment comment = new Comment();

		comment.setCommentContent(Content);
		comment.setBoardNum(Integer.parseInt(pageIndex));
		comment.setCommentId(currentId);
		
		
		CommentService cservice = new CommentService();
		int result = cservice.inputComment(comment); // 댓글 삽입 수행
		
		boardService bservice = new boardService();

		

		if (result == 1) {
			
			int update = bservice.boardUpdate(board);//게시글의 댓글 수 증가.
			
			List<CommentList> commentlist = null; // 댓글 리스트를 업데이트
			commentlist = cservice.getAllList(comment);
			session.setAttribute("CommentList", commentlist);
			request.setAttribute("board", board);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
			dispatcher.forward(request, response);
			return;

		}else {
			response.sendRedirect("loginFail.html");
		}
		
		
//		if (result == 1) {
//			List<Comment> commentlist = null;
//			commentlist = cservice.getAllList(comment);
//			session.setAttribute("Comment", commentlist);
//			request.setAttribute("board", board);
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
//			dispatcher.forward(request, response);
//			return;
//
//		}else {
//			response.sendRedirect("loginFail.html");
//		}

	}

}

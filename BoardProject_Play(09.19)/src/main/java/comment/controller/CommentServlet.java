package comment.controller;

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
import comment.service.CommentService;
import comment.vo.Comment;
import comment.vo.CommentList;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/commentModify")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String commentNum = (String) request.getParameter("Commentnum"); // 해당 게시글에 대한 댓글 테이블의 댓글번호
		String boardIndex = (String) request.getParameter("boardIndex");// 현재 선택한 개시글 가져오기
		
//		System.out.println(commentNum);
//		System.out.println(boardIndex);
//		
		Comment comment = new Comment();
		comment.setBoardNum(Integer.parseInt(boardIndex));
		comment.setCommentNum(Integer.parseInt(commentNum));
		
		CommentService cService = new CommentService();
		comment =  cService.getComment(comment);
		//System.out.println(comment.getCommentContent());
		
		request.setAttribute("Comment", comment);
		//session.setAttribute("Comment", comment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modifyComment.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		String CommentContent = request.getParameter("CommentContent");
		System.out.println(CommentContent);
		
		String boardNum = request.getParameter("boardNum");
		String commentNum = request.getParameter("commentNum");
		
		Comment comment = new Comment();
		comment.setBoardNum(Integer.parseInt(boardNum));
		comment.setCommentNum(Integer.parseInt(commentNum));
		comment.setCommentContent(CommentContent);
		
		CommentService cService = new CommentService();
		int result = cService.updateComment(comment); // 댓글 업데이트
		
		List<CommentList> commentlist = null;
		commentlist = cService.getAllList(comment); // 댓글 업데이트 목록을 반영

		Board board = new Board();
		board.setBoardNum(Integer.parseInt(boardNum));
		
		boardService bService = new boardService();
		board = bService.getPost(board);
		
		if(result == 1) {
			request.setAttribute("Comment", comment);
			//session.setAttribute("Comment", comment);
			request.setAttribute("CommentList", commentlist);
			//session.setAttribute("CommentList", commentlist);
			request.setAttribute("board", board);
			RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect("loginFail.html");
			
		}
			
	}

}

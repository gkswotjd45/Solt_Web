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
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/commentDelete")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
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
		HttpSession session =  request.getSession(true);
		String commentIndex = request.getParameter("commentDelete");
		String boardIndex = request.getParameter("boardNum");
		
	
		
		Comment comment = new Comment();
		comment.setCommentNum(Integer.parseInt(commentIndex));
		comment.setBoardNum(Integer.parseInt(boardIndex));
		CommentService cService = new CommentService();
		
		int result = cService.commentDelete(comment); // 해당 댓글 삭제

		if(result == 1) {
			
			List<CommentList> commentlist = null;
			commentlist = cService.getAllList(comment);// 댓글 게시글을 currentpage에 업데이트를 수행.
			
			
			Board board = new Board();
			board.setBoardNum(Integer.parseInt(boardIndex));
			
			boardService bService = new boardService();
			int delete = bService.setPost(board);//게시글에 해당 댓글을 삭제.
			
			board = bService.getPost(board);
			
			request.setAttribute("CommentList", commentlist);
			request.setAttribute("board",board);
			RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		
		
	}

}

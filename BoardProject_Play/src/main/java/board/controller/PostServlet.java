package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import member.vo.Member;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/current")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		
		//System.out.println(request.getParameter("page"));
		String pageIndex = request.getParameter("page");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(pageIndex));
		
		boardService bservice = new boardService();
		board = bservice.getPost(board); // 현재 게시글 불러오기
		
		
		if(board != null) {
		System.out.println(board.getBoardAuthor());
		request.setAttribute("board", board);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("currentPage.jsp");
		dispatcher.forward(request, response);
		
		} else {
			response.sendRedirect("loginFail.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

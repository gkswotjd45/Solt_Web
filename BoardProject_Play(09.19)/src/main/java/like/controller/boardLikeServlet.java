package like.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.service.boardService;
import board.vo.Board;
import like.service.likeService;
import like.vo.likeBoard;

/**
 * Servlet implementation class boardLikeServlet
 */
@WebServlet("/boardLikeServlet")
public class boardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardLikeServlet() {
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
		
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("실행");
		
		String memberId = request.getParameter("mid");
		String boardId = request.getParameter("bid");
		likeBoard findlike = new likeBoard(); // 찾을 좋아요 VO
		
		Board board = new Board();
//		likeBoard likeBoard = new likeBoard();
		findlike.setLikememberId(memberId);
		findlike.setLikeBoarderNum(Integer.parseInt(boardId)); // 현재 좋아요 했는지 찾기 위해 setter() 저장.
		
		
		likeBoard resultlike = new likeBoard(); // 좋아요 결과 반환 Vo
		likeService cService = new likeService();
		resultlike = cService.getLikeSelect(findlike); // 현재 게시글 및 사용자에 대한 좋아요 여부 검색.
		
		int result = 0; // 최종결과 값.
		
		if(Objects.isNull(resultlike)) { // 검색했을 때 좋아요가 없으면 수행
			result = cService.setLike(findlike); // 좋아요 테이블에 1추가 
			System.out.println(result); // 결과값은 1로 반환
			
	
			board.setBoardNum(Integer.parseInt(boardId));
			
			boardService bService = new boardService();
			int likeUpdate = bService.setLikeUp(board); // 해당 게시글의 좋아요수 1개 증가.
			board = bService.getPost(board);
			if(likeUpdate == 1) {
				System.out.println("게시글 좋아요 업데이트 됨");
			}else {
				System.out.println("게시글 좋아요업데이트 안됨");
			}
			
			//게시글을 좋아요수 반영
		}else {
			System.out.println(result); // 만약 기존의 값이 있었다면 0으로 반환.
		}
		
		String like =  board.getBoardLike(); // 반영된 좋아요 개수도 같이 가져오기
		
		Gson gson = new Gson();
		
		JsonObject jsonObject = new  JsonObject();
		jsonObject.addProperty("result", result);
		jsonObject.addProperty("likeCount", like); // 현재 게시글의 좋아요 총합.

		String find = gson.toJson(jsonObject);
		response.getWriter().write(find);

	}

}

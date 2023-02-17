package board.service;

import java.util.List;

import com.mysql.cj.protocol.x.ReusableOutputStream;

import board.dao.boardDao;
import board.vo.Board;
import board.vo.boardList;

public class boardService {

	public List<boardList> getAllBoard() {
		// 로직처리애야 함.
		// 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면 됨.
		boardDao dao = new boardDao();
		List<boardList> list = dao.selectAll();
		// dao에게 일을 시키고 => 걔가 갖고 온거 컨트롤러에게 전달.
		
		return list;
	}

	public int putPost(Board board) {
		boardDao dao = new boardDao();
		int result = dao.newContent(board);
		return result;
	}

	public Board getPost(Board board) {
		boardDao dao = new boardDao();
		Board post = dao.getCurrentPost(board);
		return post;
	}

	public int modifyPost(Board board) {
		boardDao dao = new boardDao();
		int result = dao.modifyCurrentPost(board);
		return result;
	}

	public int postDelete(Board board) {
		boardDao dao = new boardDao();
		int result = dao.deleteCurrentPost(board);
		return result;
	}

	public int boardUpdate(Board board) { // 댓글 추가시 해당 게시글 댓글 수증가.
		boardDao dao = new boardDao();
		int result = dao.updateBoardPost(board);
		
		return result;
	}

	public int setLikeUp(Board board) {
		boardDao dao = new boardDao();
		int result = dao.updateLike(board);
		return result;
	}

	public int setPost(Board board) { // 댓글을 삭제시 해당 게시글 댓글 수 차감.
		
		boardDao dao = new boardDao();
		int result = dao.deleteCommentBoard(board);
		return result;
	}

}

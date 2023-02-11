package board.service;

import java.util.List;

import board.dao.boardDao;
import board.vo.Board;

public class boardService {



	public List<Board> getAllBoard() {
		// 로직처리애야 함.
		// 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면 됨.
		boardDao dao = new boardDao();
		List<Board> list = dao.selectAll();
		// dao에게 일을 시키고 => 걔가 갖고 온거 컨트롤러에게 전달.
		
		return list;
	}

}

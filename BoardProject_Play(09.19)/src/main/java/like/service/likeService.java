package like.service;

import like.dao.likeDao;
import like.vo.likeBoard;

public class likeService {

	public likeBoard getLikeSelect(likeBoard findlike) {
		likeDao dao = new likeDao();
		
		likeBoard Like = dao.selectLike(findlike);
	
		return Like;
	}

	public int setLike(likeBoard findlike) {
		
		likeDao dao = new likeDao();
		int boardLike = dao.setLike(findlike);
		
		return boardLike;
	
	}


}

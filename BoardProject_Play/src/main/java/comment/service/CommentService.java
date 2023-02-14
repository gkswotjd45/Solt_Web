package comment.service;

import java.util.List;

import comment.dao.commentDao;
import comment.vo.Comment;

public class CommentService {

	public List<Comment> getAllList(Comment comments) {
		commentDao dao = new commentDao();
		List<Comment> list = dao.selectAll(comments);
		
		return list;
	}

}

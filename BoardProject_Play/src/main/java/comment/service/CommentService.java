package comment.service;

import java.util.List;

import comment.dao.commentDao;
import comment.vo.Comment;
import comment.vo.CommentList;

public class CommentService {
	
	public List<CommentList> getAllList(Comment comments) {
		commentDao dao = new commentDao();
		List<CommentList> list = dao.selectAll(comments);
		
		return list;
	}
	
	

//	public List<Comment> getAllList(Comment comments) {
//		commentDao dao = new commentDao();
//		List<Comment> list = dao.selectAll(comments);
//		
//		return list;
//	}

	public int inputComment(Comment comment) {
		commentDao dao = new commentDao();
		int result = dao.insert(comment);
		
		return result;
	}

}

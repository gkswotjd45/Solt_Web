package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.boardList;
import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class commentDao {

	public List<Comment> selectAll(Comment comments) {
		
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		// sql세션을 MyBatisConnectionFactory.getSqlSessionFactory() [우리 공장내에서].
		// opensession()을 통해 가져옴.
		// book.xml의 sql문을 실행시키기 위해 sql 세션을 뽑아냄.
		// 공장에서 세션을 뽑아서 sql구문 수행.
		List<Comment> list = sqlsession.selectList("myCommentList.getList",comments);
		// 나에게 전달된

		sqlsession.close();

		return list;
	}

	
}

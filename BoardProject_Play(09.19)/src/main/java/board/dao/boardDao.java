package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import board.vo.boardList;
import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class boardDao {

	public List<boardList> selectAll() {
		// TODO Auto-generated method stub
		// 데이터 베이스 처리만 하면 되요.
		// my batis를 이용.
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		// sql세션을 MyBatisConnectionFactory.getSqlSessionFactory() [우리 공장내에서].
		// opensession()을 통해 가져옴.
		// book.xml의 sql문을 실행시키기 위해 sql 세션을 뽑아냄.
		// 공장에서 세션을 뽑아서 sql구문 수행.
		List<boardList> list = sqlsession.selectList("myList.getList");
		// 나에게 전달된

		sqlsession.close();

		return list;
	}

	public int newContent(Board board) {

		int result = 0; // 업데이트 받은 영향 받은 개수

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.insert("myBoard.putContent", board);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlsession.close();
		}
		// 세션이 갖고 있는 update 시킴.
		return result;

	}

	public Board getCurrentPost(Board board) {

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Board post = sqlsession.selectOne("myBoard.getCurrentPost", board);

		return post;
	}

	public int modifyCurrentPost(Board board) {
		int result = 0;

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.update("myBoard.modifyCurrentPost", board);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlsession.close();
		}
		return result;
	}

	public int deleteCurrentPost(Board board) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		try {
			result = sqlSession.delete("myBoard.deleteCurrentPost", board);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlSession.close();
		}
		return result;
	}

	public int updateBoardPost(Board board) { // 게시글 댓글 수 업데이트
		int result = 0;

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.update("myBoard.updateCommentBoard",board);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlsession.close();
		}
		return result;
	}

	public int updateLike(Board board) { // 게시글 좋아요 추가.
		int result = 0;

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.update("myBoard.updateLikeBoard",board);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlsession.close();
		}
		return result;
	}

	public int deleteCommentBoard(Board board) {
		
		int result = 0;

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.update("myBoard.updateDeleteComment",board);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlsession.close();
		}
		return result;
	}

}

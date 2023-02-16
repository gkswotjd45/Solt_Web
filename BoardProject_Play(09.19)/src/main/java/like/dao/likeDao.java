package like.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import like.vo.likeBoard;

public class likeDao {

	public likeBoard selectLike(likeBoard like) {
		int result = 0;
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		likeBoard boardLike = sqlsession.selectOne("mylike.selectLike", like);
		
		return boardLike;
	}

	public int setLike(likeBoard findlike) {
		int result = 0; // 업데이트 받은 영향 받은 개수

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.insert("mylike.inputLike", findlike);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit(); // update, delete 문은 커밋을 반드시 수행.
			sqlsession.close();
		}
		// 세션이 갖고 있는 update 시킴.
		return result;
		
	}

}

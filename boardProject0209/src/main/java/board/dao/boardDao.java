package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class boardDao {

	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		// 데이터 베이스 처리만 하면 되요.
		//my batis를 이용.
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		//sql세션을 MyBatisConnectionFactory.getSqlSessionFactory() [우리 공장내에서]. opensession()을 통해 가져옴.
		//book.xml의 sql문을 실행시키기 위해 sql 세션을 뽑아냄.
		// 공장에서 세션을 뽑아서 sql구문 수행.
		 List<Board> list= sqlsession.selectList("myBoard.allBoards");
		// 나에게 전달된 
		
		sqlsession.close();
		
		
		return list;
	}

}

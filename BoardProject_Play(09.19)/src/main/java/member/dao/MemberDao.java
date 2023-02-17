package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;


public class MemberDao {

	public Member select(Member member) {
		// 시용자의 데이터 베이스 처리를 수행.
		// mybatis를 이용해서 database 처리를 할 꺼예요.
		
		// mybatis를 사용하려면 sqlsesstion 이어야 함 => 얘가 있어야지 xml(mapper)에 있는 쿼리를 실행할 수 있음.
		// sqlsession은 누가 만들어 주나요? => sqlsessionFactory가 만들어 줌.
		// sqlsessionFactory가 있어야 함. => 특정 데이터베이스가 연결된 공장이 있어야 함. (이 공장을 만들려면 데이터베이스 연결정보와 같은
		// xml정보(config)를 줘서 이 공장을 만들어야 함.
		// 이 공장을 짓는 코드는 이미 어느정도 정해져 있음.
		
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		//sql세션을 MyBatisConnectionFactory.getSqlSessionFactory() [우리 공장내에서]. opensession()을 통해 가져옴.
		//book.xml의 sql문을 실행시키기 위해 sql 세션을 뽑아냄.
		
		Member result= sqlsession.selectOne("myMember.selectMember",member);
		// 나에게 전달된 
		
		sqlsession.close();
		
		return result;
	}

	public Member findId(Member member) {
		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Member user = sqlsession.selectOne("myMember.findId", member);
		
		sqlsession.close();
		return user;
	}

	public int register(Member member) {
		
		int result = 0;

		SqlSession sqlsession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		try {
			result = sqlsession.insert("myMember.memberRegister", member);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlsession.commit();
			sqlsession.close();
		}

		return result;
	}

}

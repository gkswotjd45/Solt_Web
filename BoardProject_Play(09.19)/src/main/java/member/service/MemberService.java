package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// 로그인이란 작업 (트랜잭션)처리를 진행
		// 하지만, 로그인은 작업은 별다른 로직처리가 할게 없음
		// data base처리가 사실 전부임.
		// database처리를 여거시 하나? 당연히 아님, DAO에서 함.
		MemberDao dao = new MemberDao();
		Member result = dao.select(member);
		
		//컨트롤러가 서비스에게 리턴함.
		return result;
	}

	public Member findId(Member member) {
		MemberDao dao = new MemberDao();
		Member user = dao.findId(member);
		return user;
	}

	public int register(Member member) {
		
		MemberDao dao = new MemberDao();
		int result =dao.register(member);
		return result;
	}

}

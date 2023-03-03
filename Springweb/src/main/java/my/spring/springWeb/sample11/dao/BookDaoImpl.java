package my.spring.springWeb.sample11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springWeb.sample11.vo.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	//객체 타입 찾아서 자동 주입.
	@Autowired
	private SqlSession session;
	
	@Override
	public int getBookCount() {
		
//		int count = session.selectOne("myBook.countBooks");
//		return count;
		return session.selectOne("myBook.countBooks");
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return session.selectList("myBook.selectAll");
	}

	@Override
	public List<Book> getSearchBooks(String keyword) {
		
		return session.selectList("myBook.selectBookByKeyword",keyword);
	}

	
}

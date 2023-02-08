package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BookDao {
 
	private SqlSessionFactory factory;
	
	public BookDao(SqlSessionFactory factory) {
		this.factory = factory;
	}
	
	public List<HashMap<String,Object>> selectBykeyworldHashMap(String keyword){
		
		 List<HashMap<String,Object>> list = null;
		 SqlSession session = factory.openSession();
		 
		 list = session.selectList("example.myBook.selectFindHashMap",keyword);
		
		return list;
	}
}

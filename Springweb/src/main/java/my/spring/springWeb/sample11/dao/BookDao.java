package my.spring.springWeb.sample11.dao;

import java.util.List;

import my.spring.springWeb.sample11.vo.Book;

public interface BookDao {
	
	int getBookCount();
	
	List<Book> getAllBooks();
	

	List<Book> getSearchBooks(String keyword);
}

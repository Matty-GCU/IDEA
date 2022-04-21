package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import po.Book;

@Repository("bookDao")
public interface BookDao {
	public List<Book> selectBookById(Integer id);
}

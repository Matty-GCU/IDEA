package dao;

import org.springframework.stereotype.Repository;
import po.Book;

import java.util.List;

@Repository("bookDao")
public interface BookDao {
	public List<Book> selectBookById(Integer id);
}

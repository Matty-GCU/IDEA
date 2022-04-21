package dao;

import org.springframework.stereotype.Repository;
import pojo.SelectBookShelfById;

import java.util.List;

@Repository("bookShelfDao")
public interface BookShelfDao {
	public List<SelectBookShelfById> selectBookShelfById(Integer id);
}

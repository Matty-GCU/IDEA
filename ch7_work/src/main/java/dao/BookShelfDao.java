package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.SelectBookShelfById;

@Repository("bookShelfDao")
public interface BookShelfDao {
	public List<SelectBookShelfById> selectBookShelfById(Integer id);
}

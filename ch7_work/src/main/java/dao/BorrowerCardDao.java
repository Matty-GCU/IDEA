package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import po.BorrowerCard;

@Repository("borrowerCardDao")
@Mapper
public interface BorrowerCardDao {
	public BorrowerCard selectBCardById(Integer i);
}

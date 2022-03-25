package textbook.chapter05.programming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class TransactionTemplateDao {
    
    @Autowired
    //依然使用之前配置好的JDBC模板
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private TransactionTemplate transactionTemplate;
    
    
    public String test() {
        return transactionTemplate.execute((status) -> {
                try {
                    String sql = "insert into users values(?, ?, ?)";
                    Object[] params = {1, "小吴", "男"};
                    jdbcTemplate.update(sql, params);
                    //再次添加相同数据，主键重复，会报错
                    jdbcTemplate.update(sql, params);
//                    transactionManager.commit(status);
                } catch (Exception e) {
//                    transactionManager.rollback(status);
                    return "主键重复，事务回滚";
                }
                return "执行成功，没有发生事务回滚";
        });
    }
}

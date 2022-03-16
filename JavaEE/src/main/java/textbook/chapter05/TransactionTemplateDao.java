package textbook.chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class TransactionTemplateDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TransactionTemplate transactionTemplate;
    
    String str;
    public String test() {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    String sql = "insert into users values(?, ?, ?)";
                    Object[] params = {1, "小吴", "男"};
                    jdbcTemplate.update("delete from users");
                    jdbcTemplate.update(sql, params);
                    //再次添加相同数据，主键重复，会报错
                    jdbcTemplate.update(sql, params);
//                    transactionManager.commit(status);
                } catch (Exception e) {
//                    transactionManager.rollback(status);
//                    e.printStackTrace();
                    str = "主键重复，事务回滚";
                }
                str = "执行成功，没有发生事务回滚";
                return null;
            }
        });
        return str;
    }
}

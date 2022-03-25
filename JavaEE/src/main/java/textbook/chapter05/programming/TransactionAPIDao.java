package textbook.chapter05.programming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class TransactionAPIDao {
    
    @Autowired
    //依然使用之前配置好的JDBC模板
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("myTransactionManager")
    private DataSourceTransactionManager dataSourceTransactionManager;
    
    public String test() {
        //默认事务定义
        TransactionDefinition definition = new DefaultTransactionDefinition();
        //
        TransactionStatus status = dataSourceTransactionManager.getTransaction(definition);
        try {
            String sql = "insert into users values(?, ?, ?)";
            Object[] params = {1, "小吴", "男"};
            jdbcTemplate.update("delete from users");
            jdbcTemplate.update(sql, params);
            //再次添加相同数据，主键重复，会报错
            jdbcTemplate.update(sql, params);
            //关键代码
            dataSourceTransactionManager.commit(status);
        } catch (Exception e) {
            //关键代码
            dataSourceTransactionManager.rollback(status);
            return "主键重复，事务回滚";
        }
        return "执行成功，没有发生事务回滚";
    }
    
}

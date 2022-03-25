package textbook.chapter05.declaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImplCh0503 implements TestDaoCh0503 {
    
    @Autowired  //自动装配该类型的Bean
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int update(String sql, Object... params) {
        return jdbcTemplate.update(sql, params);
    }
    
}

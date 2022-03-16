package textbook.chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImplCh05 implements DaoCh05 {
    
    @Autowired  //自动装配该类型的Bean
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int update(String sql, Object... params) {
        return jdbcTemplate.update(sql, params);
    }
    
    @Override
    public List<MyUser> query(String sql, Object[] params) {
        RowMapper<MyUser> rowMapper = new BeanPropertyRowMapper<>(MyUser.class);
        return jdbcTemplate.query(sql, rowMapper, params);
    }
}

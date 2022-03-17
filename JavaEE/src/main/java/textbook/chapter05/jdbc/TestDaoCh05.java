package textbook.chapter05.jdbc;

import java.util.List;

public interface TestDaoCh05 {
    
    int update(String sql, Object[] params);
    
//    与这样写相比，本质上没有区别
//    List<MyUser> query(String sql, Object[] params);
    List<MyUser> query(String sql, Object... params);
}

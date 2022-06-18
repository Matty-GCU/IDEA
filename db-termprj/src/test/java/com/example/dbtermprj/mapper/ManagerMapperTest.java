package com.example.dbtermprj.mapper;

import com.example.dbtermprj.entity.Manager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.example.dbtermprj.util.MyBatisUtils;

public class ManagerMapperTest {
    
    static ManagerMapper managerMapper;
    
    @BeforeAll
    static void start() {
        managerMapper = MyBatisUtils.getSqlSession().getMapper(ManagerMapper.class);
    }
    
    @Test
    void add() {
        System.out.println(managerMapper.add(new Manager(1, "管理员1", "男", 20, 10086, 1)));
    }
    
    @Test
    void delete() {
        System.out.println(managerMapper.deleteById(1));
    }
    
}

package com.example.dbtermprj.mapper;

import com.example.dbtermprj.entity.Part;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.example.dbtermprj.util.MyBatisUtils;

public class PartMapperTest {
    
    static PartMapper partMapper;
    
    @BeforeAll
    static void start() {
        partMapper = MyBatisUtils.getSqlSession().getMapper(PartMapper.class);
    }
    
    @Test
    void add() {
        System.out.println(partMapper.add(new Part(1, "零件1", "大号", 35, 1)));
    }
    
    
    
}

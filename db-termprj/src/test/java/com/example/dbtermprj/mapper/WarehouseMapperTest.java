package com.example.dbtermprj.mapper;

import com.example.dbtermprj.entity.Warehouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.example.dbtermprj.util.MyBatisUtils;

import java.util.List;

public class WarehouseMapperTest {
    
    static WarehouseMapper warehouseMapper;
    
    @BeforeAll
    static void start() {
        warehouseMapper = MyBatisUtils.getSqlSession().getMapper(WarehouseMapper.class);
    }
    
    @Test
    void add() {
        System.out.println(warehouseMapper.add(new Warehouse(1, "地址XXX", 1800)));
    }
    
    @Test
    void delete() {
        System.out.println(warehouseMapper.deleteById(1));
    }
    
    @Test
    void update() {
        System.out.println(warehouseMapper.updateById(new Warehouse(1, "地址YYY", 500)));
    }
    
    @Test
    void get() {
        System.out.println(warehouseMapper.getById(1));
        System.out.println();
        List<Warehouse> warehouses = warehouseMapper.getAll();
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
        }
    }
}

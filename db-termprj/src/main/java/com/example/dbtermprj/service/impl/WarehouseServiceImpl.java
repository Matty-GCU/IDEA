package com.example.dbtermprj.service.impl;

import com.example.dbtermprj.entity.Warehouse;
import com.example.dbtermprj.mapper.WarehouseMapper;
import com.example.dbtermprj.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    
    @Autowired
    WarehouseMapper warehouseMapper;
    
    @Override
    public Integer add(Warehouse warehouse) {
        return warehouseMapper.add(warehouse);
    }
    
    @Override
    public Integer deleteById(Integer id) {
        return warehouseMapper.deleteById(id);
    }
    
    @Override
    public Integer updateById(Warehouse warehouse) {
        return warehouseMapper.updateById(warehouse);
    }
    
    @Override
    public Warehouse getById(Integer id) {
        return warehouseMapper.getById(id);
    }
    
    @Override
    public List<Warehouse> getAll() {
        return warehouseMapper.getAll();
    }
}

package com.example.dbtermprj.mapper;

import com.example.dbtermprj.entity.Manager;

import java.util.List;

public interface ManagerMapper {
    
    public Integer add(Manager manager);
    
    public Integer deleteById(Integer id);
    
    public Integer updateById(Manager manager);
    
    public Manager getById(Integer id);
    public List<Manager> getAll();
    public List<Manager> getByWarehouseId(Integer warehouseId);
    
}

package com.example.dbtermprj.service;

import com.example.dbtermprj.entity.Manager;

import java.util.List;

public interface ManagerService {
    
    public int add(Manager manager);
    
    public int deleteById(int id);
    
    public int updateById(Manager manager);
    
    public Manager getById(int id);
    
    public List<Manager> getAll();
    
    public List<Manager> getByWarehouseId(int warehouseId);
    
}

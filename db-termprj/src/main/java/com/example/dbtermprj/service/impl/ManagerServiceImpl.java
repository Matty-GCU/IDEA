package com.example.dbtermprj.service.impl;

import com.example.dbtermprj.entity.Manager;
import com.example.dbtermprj.mapper.ManagerMapper;
import com.example.dbtermprj.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    
    @Autowired
    ManagerMapper managerMapper;
    
    @Override
    public int add(Manager manager) {
        return managerMapper.add(manager);
    }
    
    @Override
    public int deleteById(int id) {
        return managerMapper.deleteById(id);
    }
    
    @Override
    public int updateById(Manager manager) {
        return managerMapper.updateById(manager);
    }
    
    @Override
    public Manager getById(int id) {
        return managerMapper.getById(id);
    }
    
    @Override
    public List<Manager> getAll() {
        return managerMapper.getAll();
    }
    
    @Override
    public List<Manager> getByWarehouseId(int warehouseId) {
        return managerMapper.getByWarehouseId(warehouseId);
    }
}

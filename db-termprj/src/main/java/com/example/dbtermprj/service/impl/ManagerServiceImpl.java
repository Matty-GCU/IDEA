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
    public Integer add(Manager manager) {
        return managerMapper.add(manager);
    }
    
    @Override
    public Integer deleteById(Integer id) {
        return managerMapper.deleteById(id);
    }
    
    @Override
    public Integer updateById(Manager manager) {
        return managerMapper.updateById(manager);
    }
    
    @Override
    public Manager getById(Integer id) {
        return managerMapper.getById(id);
    }
    
    @Override
    public List<Manager> getAll() {
        return managerMapper.getAll();
    }
    
    @Override
    public List<Manager> getByWarehouseId(Integer warehouseId) {
        return managerMapper.getByWarehouseId(warehouseId);
    }
    
    @Override
    public Manager login(Integer id, String pwd) {
        return managerMapper.login(id, pwd);
    }
}

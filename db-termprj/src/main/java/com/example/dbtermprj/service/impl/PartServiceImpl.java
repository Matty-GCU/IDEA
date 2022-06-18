package com.example.dbtermprj.service.impl;

import com.example.dbtermprj.entity.Part;
import com.example.dbtermprj.mapper.PartMapper;
import com.example.dbtermprj.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    
    @Autowired
    PartMapper partMapper;
    
    @Override
    public int add(Part part) {
        return partMapper.add(part);
    }
    
    @Override
    public int deleteById(int id) {
        return partMapper.deleteById(id);
    }
    
    @Override
    public int updateById(Part part) {
        return partMapper.updateById(part);
    }
    
    @Override
    public Part getById(int id) {
        return partMapper.getById(id);
    }
    
    @Override
    public List<Part> getAll() {
        return partMapper.getAll();
    }
    
    @Override
    public List<Part> getByWarehouseId(int warehouseId) {
        return partMapper.getByWarehouseId(warehouseId);
    }
}

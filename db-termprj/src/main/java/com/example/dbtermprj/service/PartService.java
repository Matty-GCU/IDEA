package com.example.dbtermprj.service;

import com.example.dbtermprj.entity.Part;

import java.util.List;

public interface PartService {
    
    public Integer add(Part part);
    
    public Integer deleteById(Integer id);
    
    public Integer updateById(Part part);
    
    public Part getById(Integer id);
    public List<Part> getAll();
    public List<Part> getByWarehouseId(int warehouseId);
    
}

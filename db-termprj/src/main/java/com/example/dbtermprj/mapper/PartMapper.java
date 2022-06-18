package com.example.dbtermprj.mapper;

import com.example.dbtermprj.entity.Part;

import java.util.List;

public interface PartMapper {
    
    public int add(Part part);
    
    public int deleteById(int id);
    
    public int updateById(Part part);
    
    public Part getById(int id);
    public List<Part> getAll();
    public List<Part> getByWarehouseId(int warehouseId);
    
}

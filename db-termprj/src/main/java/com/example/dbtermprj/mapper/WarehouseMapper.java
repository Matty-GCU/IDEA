package com.example.dbtermprj.mapper;


import com.example.dbtermprj.entity.Warehouse;

import java.util.List;

public interface WarehouseMapper {
    
    public int add(Warehouse warehouse);
    
    public int deleteById(int id);
    
    public int updateById(Warehouse warehouse);
    
    public Warehouse getById(int id);
    public List<Warehouse> getAll();
}

package com.example.dbtermprj.service;


import com.example.dbtermprj.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    
    public int add(Warehouse warehouse);
    
    public int deleteById(int id);
    
    public int updateById(Warehouse warehouse);
    
    public Warehouse getById(int id);
    public List<Warehouse> getAll();
}

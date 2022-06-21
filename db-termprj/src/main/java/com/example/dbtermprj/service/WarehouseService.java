package com.example.dbtermprj.service;


import com.example.dbtermprj.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    
    public Integer add(Warehouse warehouse);
    
    public Integer deleteById(Integer id);
    
    public Integer updateById(Warehouse warehouse);
    
    public Warehouse getById(Integer id);
    public List<Warehouse> getAll();
}

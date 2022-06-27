package com.example.dbtermprj.controller;

import com.example.dbtermprj.entity.Warehouse;
import com.example.dbtermprj.service.WarehouseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
public class WareHouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/add")
    public int addManager(@RequestBody Warehouse warehouse) {
        return warehouseService.add(warehouse);
    }

    @DeleteMapping("/delete")
    public int deleteManager(Integer id) {
        return warehouseService.deleteById(id);
    }

    @PutMapping("/update")
    public int updateManager(@RequestBody Warehouse warehouse) {
        return warehouseService.updateById(warehouse);
    }

    @GetMapping("/getOne")
    public String getOnePart(Integer id) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(warehouseService.getById(id));
    }

    @GetMapping("/getAll")
    public String getAllParts() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(warehouseService.getAll());
    }
}

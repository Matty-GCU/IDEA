package com.example.dbtermprj.controller;

import com.example.dbtermprj.entity.Part;
import com.example.dbtermprj.service.PartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/part")
public class PartController {
    
    @Autowired
    PartService partService;
    
    @PostMapping("/add")
    public int addManager(@RequestBody Part part) {
        return partService.add(part);
    }
    
    @DeleteMapping("/delete")
    public int deleteManager(Integer id) {
        return partService.deleteById(id);
    }
    
    @PutMapping("/update")
    public int updateManager(@RequestBody Part part) {
        return partService.updateById(part);
    }
    
    @GetMapping("/getOne")
    public String getOnePart(Integer id) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(partService.getById(id));
    }
    
    @GetMapping("/getAll")
    public String getAllParts() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(partService.getAll());
    }
    
    @GetMapping("/getByWarehouseId")
    public String getByWarehouseId(Integer warehouseId) throws JsonProcessingException {
        System.out.println(warehouseId);
        return new ObjectMapper().writeValueAsString(partService.getByWarehouseId(warehouseId));
    }
}

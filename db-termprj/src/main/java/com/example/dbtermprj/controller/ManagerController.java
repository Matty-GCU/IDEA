package com.example.dbtermprj.controller;

import com.example.dbtermprj.entity.Manager;
import com.example.dbtermprj.service.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
@CrossOrigin(originPatterns = "*", allowCredentials = "true", allowedHeaders = "*")
public class ManagerController {
    
    @Autowired
    ManagerService managerService;
    
    @RequestMapping(value = "/login/{id}/{pwd}")
    public String login(@PathVariable Integer id, @PathVariable String pwd) {
        if (managerService.login(id, pwd) == null) {
            return "失败";
        }
        else {
            return "成功";
        }
    }
    
    @RequestMapping("/add")
    public int addManager(@RequestBody Manager manager) {
        return managerService.add(manager);
    }
    
    @DeleteMapping("/delete")
    public int deleteManager(Integer id) {
        return managerService.deleteById(id);
    }
    
    @PutMapping("/update")
    public int updateManager(@RequestBody Manager manager) {
        return managerService.updateById(manager);
    }
    
    @GetMapping("/getOne")
    public String getOneManager(Integer id) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(managerService.getById(id));
    }
    
    @GetMapping("/getAll")
    public String getAllManagers() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(managerService.getAll());
    }
    
    @GetMapping("/getByWarehouseId")
    public String getByWarehouseId(Integer warehouseId) throws JsonProcessingException {
        System.out.println(warehouseId);
        return new ObjectMapper().writeValueAsString(managerService.getByWarehouseId(warehouseId));
    }
    
}

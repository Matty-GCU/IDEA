package com.example.dbtermprj.entity;

public class Part {
    Integer id;
    String name;
    String size;
    Integer number;
    Integer warehouseId;
    
    public Part(Integer id, String name, String size, Integer number, Integer warehouseId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.number = number;
        this.warehouseId = warehouseId;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public Integer getWarehouseId() {
        return warehouseId;
    }
    
    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
    
    @Override
    public String toString() {
        return "PartMapper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", number=" + number +
                ", warehouseId=" + warehouseId +
                '}';
    }
}

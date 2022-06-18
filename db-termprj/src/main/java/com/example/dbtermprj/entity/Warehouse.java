package com.example.dbtermprj.entity;

/**
 * 仓库
 */
public class Warehouse {
    
    Integer id;
    String address;
    Integer area;
    
    public Warehouse(Integer id, String address, Integer area) {
        this.id = id;
        this.address = address;
        this.area = area;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Integer getArea() {
        return area;
    }
    
    public void setArea(int area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", area=" + area +
                '}';
    }
}

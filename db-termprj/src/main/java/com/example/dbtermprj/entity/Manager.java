package com.example.dbtermprj.entity;

/**
 * 管理员
 */
public class Manager {
    
    Integer id;
    String name;
    String gender;
    Integer age;
    Integer phone;
    Integer warehouseId;
    
    public Manager(Integer id, String name, String gender, Integer age, Integer phone, Integer warehouseId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.warehouseId = warehouseId;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Integer getPhone() {
        return phone;
    }
    
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    
    public Integer getWarehouseId() {
        return warehouseId;
    }
    
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }
    
    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", warehouseId=" + warehouseId +
                '}';
    }
}

package pojo;

public class User {
    int id;
    String name;
    
    public User() {
    }
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
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
    
    @Override
    public String toString() {
        return "用户{" +
                "用户编号=" + id +
                ", 姓名='" + name + '\'' +
                '}';
    }
}

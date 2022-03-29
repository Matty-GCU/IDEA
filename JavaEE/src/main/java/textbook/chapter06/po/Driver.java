package textbook.chapter06.po;

public class Driver {
    String id;
    String name;
    int drivingAge;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getDrivingAge() {
        return drivingAge;
    }
    
    public void setDrivingAge(int drivingAge) {
        this.drivingAge = drivingAge;
    }
    
    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", drivingAge=" + drivingAge +
                '}';
    }
}

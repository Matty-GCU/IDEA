package textbook.chapter06.po;

public class Driver {
    String id;
    String name;
    int drivingAge;
    
    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", drivingAge=" + drivingAge +
                '}';
    }
}

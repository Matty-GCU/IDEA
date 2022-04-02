package p23MyBatis.pojo;

public class User {
    int id;
    String name;
    String pwd;
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

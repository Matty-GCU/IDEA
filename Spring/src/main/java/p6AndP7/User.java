package p6AndP7;

public class User {
    private String name;
    
    /**
     * 如果在配置文件里没有配置bean的constructor-arg，则必须要有无参构造方法
     */
    public User() {
        System.out.println("调用User的无参构造方法");
    }
    
    /**
     * 如果在配置文件里配置了bean的property，则必须要有对应成员变量的setter方法
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void showName() {
        System.out.println(name);
    }
}

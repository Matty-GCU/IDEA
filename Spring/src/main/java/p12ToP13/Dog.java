package p12ToP13;

public class Dog {
    String dogName;
    
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
    
    public String getDogName() {
        return dogName;
    }
    
    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                '}';
    }
}

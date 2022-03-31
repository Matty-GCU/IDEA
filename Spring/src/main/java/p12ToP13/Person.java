package p12ToP13;

public class Person {
    
    private Dog dog;
    private Cat cat;
    
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    
    public void setCat(Cat cat) {
        this.cat = cat;
    }
    
    public Dog getDog() {
        return dog;
    }
    
    public Cat getCat() {
        return cat;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}

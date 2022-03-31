package p12ToP13;

public class Cat {
    String catName;
    
    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    public String getCatName() {
        return catName;
    }
    
    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }
}

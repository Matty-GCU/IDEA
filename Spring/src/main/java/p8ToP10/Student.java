package p8ToP10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    //各种不同类型的成员变量（Student对象的“依赖”），如何通过配置文件进行“注入”？
    String name;
    String[] namesOfFriends;
    Teacher favoriteTeacher;
    Teacher[] allTeachers;
    List<String> notebooks;
    Set<String> textbooks;
    Map<String, String> grades;
    String anEmptyString;
    String aNullValue;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String[] getNamesOfFriends() {
        return namesOfFriends;
    }
    
    public void setNamesOfFriends(String[] namesOfFriends) {
        this.namesOfFriends = namesOfFriends;
    }
    
    public Teacher getFavoriteTeacher() {
        return favoriteTeacher;
    }
    
    public void setFavoriteTeacher(Teacher favoriteTeacher) {
        this.favoriteTeacher = favoriteTeacher;
    }
    
    public Teacher[] getAllTeachers() {
        return allTeachers;
    }
    
    public void setAllTeachers(Teacher[] allTeachers) {
        this.allTeachers = allTeachers;
    }
    
    public List<String> getNotebooks() {
        return notebooks;
    }
    
    public void setNotebooks(List<String> notebooks) {
        this.notebooks = notebooks;
    }
    
    public Set<String> getTextbooks() {
        return textbooks;
    }
    
    public void setTextbooks(Set<String> textbooks) {
        this.textbooks = textbooks;
    }
    
    public Map<String, String> getGrades() {
        return grades;
    }
    
    public void setGrades(Map<String, String> grades) {
        this.grades = grades;
    }
    
    public String getAnEmptyString() {
        return anEmptyString;
    }
    
    public void setAnEmptyString(String anEmptyString) {
        this.anEmptyString = anEmptyString;
    }
    
    public String getaNullValue() {
        return aNullValue;
    }
    
    public void setaNullValue(String aNullValue) {
        this.aNullValue = aNullValue;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", namesOfFriends=" + Arrays.toString(namesOfFriends) +
                ", favoriteTeacher=" + favoriteTeacher +
                ", allTeachers=" + Arrays.toString(allTeachers) +
                ", notebooks=" + notebooks +
                ", textbooks=" + textbooks +
                ", grades=" + grades +
                ", anEmptyString='" + anEmptyString + '\'' +
                ", aNullValue='" + aNullValue + '\'' +
                '}';
    }
}

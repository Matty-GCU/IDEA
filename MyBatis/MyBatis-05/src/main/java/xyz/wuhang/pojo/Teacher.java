package xyz.wuhang.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    int tchId;
    String tchName;
    List<Student> students;
}

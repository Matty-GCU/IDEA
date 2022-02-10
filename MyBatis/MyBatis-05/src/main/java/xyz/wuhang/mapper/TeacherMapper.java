package xyz.wuhang.mapper;

import xyz.wuhang.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeacherById(int tchId);

}
